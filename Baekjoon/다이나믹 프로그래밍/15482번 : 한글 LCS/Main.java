import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int DP[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length()+1;i++) {
            for(int j=1;j<str2.length()+1;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    DP[i][j] = DP[i-1][j-1]+1;
                else
                    DP[i][j] = Integer.max(DP[i-1][j],DP[i][j-1]);
            }
        }
        System.out.println(DP[str1.length()][str2.length()]);
    }
}
