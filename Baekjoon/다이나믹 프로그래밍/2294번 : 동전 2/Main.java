import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int dp[][] = new int[n+1][k+1];
        for(int i=0;i<=k;i++) {
            dp[0][i] = -1;
        }
        for(int i=1;i<=n;i++) {
            int num = Integer.parseInt(br.readLine());
            for(int j=1;j<=k;j++) {
                if(j<num)
                    dp[i][j] = dp[i-1][j];
                else if(dp[i-1][j]==-1 && dp[i][j-num]==-1)
                    dp[i][j] = -1;
                else if(dp[i-1][j]==-1)
                    dp[i][j] = dp[i][j-num]+1;
                else if(dp[i][j-num]==-1)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-num]+1);
            }
        }
        System.out.println(dp[n][k]);
    }
}
