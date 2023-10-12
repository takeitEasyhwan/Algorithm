import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        long[] dp = new long[N+1];
        dp[N] = 0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int i=N-1;i>=0;i--) {
            if(arr[i][0]+i>N) {
                dp[i] = dp[i+1];
            }
            else {
                dp[i] = Math.max(dp[i+1],arr[i][1]+dp[i+arr[i][0]]);
            }

        }
        System.out.println(dp[0]);
    }
}
