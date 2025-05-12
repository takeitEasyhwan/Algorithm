import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int DP[] = new int[N+1];
        int TP[][] = new int[2][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            TP[0][i] = Integer.parseInt(st.nextToken());
            TP[1][i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++) {
            if(TP[0][N-i-1]+(N-i-1)<=N)
                DP[N-i-1] = Integer.max(DP[N-i], DP[N-i-1+TP[0][N-i-1]]+TP[1][N-i-1]);
            else
                DP[N-i-1] = DP[N-i];
        }
        System.out.println(DP[0]);
    }
}
