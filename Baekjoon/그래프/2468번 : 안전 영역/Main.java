import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int map[][] = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(min>num)min=num;
                if(max<num)max=num;
                map[i][j] = num;
            }
        }
        int maxCnt=0;
        for(int k=min-1;k<=max;k++) {
            int cnt=0;
            boolean check[][] = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j]>k && !check[i][j]) {
                        cnt++;
                        check[i][j]=true;
                        DFS(map,check,i,j,k);
                    }
                }
            }
            if(maxCnt<cnt)
                maxCnt=cnt;
        }
        System.out.println(maxCnt);
    }
    static void DFS(int[][] map, boolean[][] check, int i, int j, int k) {
        int di[] = {-1,0,1,0};
        int dj[] = {0,1,0,-1};
        for(int l=0;l<4;l++) {
            int din = i+di[l];
            int djn = j+dj[l];
            if(0>din || din>map.length-1 || 0>djn || djn>map[0].length-1)
                continue;
            if(map[din][djn]>k && !check[din][djn]) {
                check[din][djn]=true;
                DFS(map,check,din,djn,k);
            }
        }
    }
}
