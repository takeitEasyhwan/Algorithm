import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line1 = br.readLine();
        String line2 = br.readLine();
        int[][] dp = new int[line1.length()+1][line2.length()+1];
        for(int i=0;i<=line1.length();i++)
            dp[i][0]=0;
        for(int i=0;i<=line2.length();i++)
            dp[0][i]=0;

        for(int i=1;i<=line1.length();i++) {
            for(int j=1;j<=line2.length();j++) {
                if(line1.charAt(i-1)==line2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[line1.length()][line2.length()]);
    }
}
