import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int dp[][] = new int[N+1][T+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());//공부 시간
            int S = Integer.parseInt(st.nextToken());//배점
            for(int j=1;j<=T;j++) {
                if(j<K)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-K]+S);
            }
        }
        System.out.println(dp[N][T]);
    }
}
