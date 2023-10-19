import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] itemArr = new int[N+1][2];
        long[][] dp = new long[N+1][K+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            itemArr[i][0] = Integer.parseInt(st.nextToken());
            itemArr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=K;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    if(j>=itemArr[i][0])
                        dp[i][j] = Math.max(dp[i-1][j-itemArr[i][0]]+itemArr[i][1],dp[i][j]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
