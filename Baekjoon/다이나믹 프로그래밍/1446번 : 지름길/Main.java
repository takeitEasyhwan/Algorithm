import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int load [][] = new int[N][3];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++) {
                load[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int dp[] = new int[D+1];
        dp[0] = 0;
        for(int i=1;i<=D;i++) {
            dp[i] = dp[i-1]+1;
            for(int j=0;j<N;j++) {
                if(load[j][1] == i)
                    dp[i] = Math.min(dp[i],dp[load[j][0]]+load[j][2]);
            }
        }
        System.out.println(dp[D]);
    }
}
