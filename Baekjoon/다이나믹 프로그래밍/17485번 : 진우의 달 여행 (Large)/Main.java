import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][M];
        int DP[][][] = new int[N][M][3];
        // \->0, |->1, /->2
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int j=0;j<M;j++) {
            DP[0][j][0] = map[0][j];
            DP[0][j][1] = map[0][j];
            DP[0][j][2] = map[0][j];
        }
        for(int i=1;i<N;i++) {
            DP[i][0][0] = Integer.MAX_VALUE;
            DP[i][0][1] = Integer.min(DP[i-1][0][0],DP[i-1][0][2])+map[i][0];
            DP[i][0][2] = Integer.min(DP[i-1][1][0],DP[i-1][1][1])+map[i][0];
            for(int j=1;j<M-1;j++) {
                DP[i][j][0] = Integer.min(DP[i-1][j-1][1],DP[i-1][j-1][2])+map[i][j];
                DP[i][j][1] = Integer.min(DP[i-1][j][0],DP[i-1][j][2])+map[i][j];
                DP[i][j][2] = Integer.min(DP[i-1][j+1][0],DP[i-1][j+1][1])+map[i][j];
            }
            DP[i][M-1][0] = Integer.min(DP[i-1][M-2][1],DP[i-1][M-2][2])+map[i][M-1];
            DP[i][M-1][1] = Integer.min(DP[i-1][M-1][0],DP[i-1][M-1][2])+map[i][M-1];
            DP[i][M-1][2] = Integer.MAX_VALUE;
        }
        int minNum = Integer.MAX_VALUE;
        for(int i=0;i<M;i++) {
            for(int j=0;j<3;j++) {
                if(minNum>DP[N-1][i][j])
                    minNum = DP[N-1][i][j];
            }
        }
        System.out.println(minNum);
    }
}
