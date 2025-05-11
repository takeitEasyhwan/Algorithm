import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int desert[][] = new int[M][N];
        int DP[][] = new int[M][N];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                desert[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<M;i++)
            DP[i][0] = desert[i][0];
        for(int i=1;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<M;k++) {
                    if(j==k)
                        DP[k][i] = Math.max(DP[k][i-1]+desert[k][i]/2,DP[k][i]);
                    else
                        DP[k][i] = Math.max(DP[j][i-1]+desert[k][i],DP[k][i]);
                }
            }
        }
        int max=0;
        for(int i=0;i<M;i++)
            max = Math.max(max,DP[i][N-1]);
        System.out.println(max);
    }
}
