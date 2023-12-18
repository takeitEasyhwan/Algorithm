import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[][][] planets = new int[M+1][N+1][3];//0 -> J, 1 -> O, 2-> I
        for(int i=1;i<=M;i++) {
            String line = br.readLine();
            for(int j=1;j<=N;j++) {
                for(int k=0;k<3;k++) {
                    planets[i][j][k] = planets[i][j-1][k] + planets[i-1][j][k] - planets[i-1][j-1][k];
                }
                switch (line.charAt(j-1)) {
                    case 'J' :
                        planets[i][j][0]++;
                        break;
                    case 'O' :
                        planets[i][j][1]++;
                        break;
                    case 'I' :
                        planets[i][j][2]++;
                        break;
                }
            }
        }
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int j=0;j<3;j++) {
                sb.append(planets[c][d][j] - planets[a-1][d][j] - planets[c][b-1][j] + planets[a-1][b-1][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
