import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean dp[] = new boolean[1001];
        //false == SK, true == CY
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        dp[4] = false;
        for(int i=5;i<=num;i++) {
            if(!dp[i-1]&&!dp[i-3]&&!dp[i-4])
                dp[i] = true;
            else
                dp[i] = false;
        }
        System.out.println(dp[num]?"CY":"SK");
    }
}
