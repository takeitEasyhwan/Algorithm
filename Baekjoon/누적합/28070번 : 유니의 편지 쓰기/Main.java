import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[120_002];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " -");
            int year1 = Integer.parseInt(st.nextToken());
            int month1 = Integer.parseInt(st.nextToken());
            int year2 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            dp[year1*12+month1]++;
            dp[year2*12+month2+1]--;
        }
        int maxPeople=0;
        int maxDay=0;
        for(int i=24_000;i<dp.length;i++) {
            dp[i] += dp[i-1];
            if(maxPeople<dp[i]) {
                maxPeople = dp[i];
                maxDay = i;
            }
        }
        if(maxDay%12==0)
            System.out.print(maxDay/12-1+"-"+12);
        else if(maxDay%12<10)
            System.out.println(maxDay/12+"-0"+maxDay%12);
        else
            System.out.print(maxDay/12+"-"+maxDay%12);
    }
}
