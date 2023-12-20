import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] dp = new int[H+2];
        for(int i=0;i<N;i++) {
            int obstacle = Integer.parseInt(br.readLine());
            if(i%2==0) {
                dp[1]++;
                dp[obstacle+1]--;
            }
            else {
                dp[H-obstacle+1]++;
            }
        }
        int min=Integer.MAX_VALUE;
        int minCount=0;
        for(int i=1;i<=H;i++) {
            dp[i]+=dp[i-1];
            if(dp[i]<min) {
                min=dp[i];
                minCount=1;
            }
            else if(dp[i]==min) {
                minCount++;
            }
        }
        System.out.println(min+" "+minCount);
    }
}
