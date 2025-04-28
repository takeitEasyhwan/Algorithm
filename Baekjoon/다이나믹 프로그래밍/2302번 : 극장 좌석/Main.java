import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int answer=1;
        int nArr[] = new int[M+2];
        nArr[0] = 0;
        nArr[M+1] = N+1;
        for(int i=0;i<M;i++) {
            nArr[i+1] = Integer.parseInt(br.readLine());
        }
        int DP[] = new int[41];
        DP[0]=1;
        DP[1]=1;
        DP[2]=2;
        for(int i=3;i<41;i++) {
            DP[i] = DP[i-2]+DP[i-1];
        }
        for(int i=1;i<=M+1;i++) {
            answer*=DP[nArr[i]-nArr[i-1]-1];
        }
        System.out.println(answer);
    }
}
