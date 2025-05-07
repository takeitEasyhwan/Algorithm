import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0)
                break;
            cnt++;
            int dp[][] = new int[N][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[0][0] = Integer.parseInt(st.nextToken());
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][1] = Integer.parseInt(st.nextToken());
            dp[0][2] = dp[0][1]+Integer.parseInt(st.nextToken());
            for(int i=1;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                dp[i][0] = Integer.min(dp[i-1][0],dp[i-1][1])+Integer.parseInt(st.nextToken());
                dp[i][1] = Integer.min(Integer.min(dp[i][0],dp[i-1][0]),Integer.min(dp[i-1][1],dp[i-1][2]))+Integer.parseInt(st.nextToken());
                dp[i][2] = Integer.min(Integer.min(dp[i][1],dp[i-1][1]),dp[i-1][2])+Integer.parseInt(st.nextToken());
            }

            sb.append(cnt).append(". ").append(dp[N-1][1]).append("\n");
        }

        System.out.println(sb);

    }
}
