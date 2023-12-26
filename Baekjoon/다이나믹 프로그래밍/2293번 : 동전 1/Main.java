import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coinArr = new int[n];
        for(int i=0;i<n;i++) {
            coinArr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n+1][k+1];
        dp[0][0]=1;
        for(int i=1;i<n+1;i++) {
            for(int j=0;j<k+1;j++) {
                if(j<coinArr[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i][j-coinArr[i-1]]+dp[i-1][j];
            }
        }
        System.out.println(dp[n][k]);
    }
}
