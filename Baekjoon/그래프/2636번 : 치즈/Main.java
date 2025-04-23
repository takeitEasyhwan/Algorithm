import java.util.*;
import java.io.*;
public class Main {
    static boolean cheese[][];
    static int cheeseCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cheese = new boolean[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                if(st.nextToken().equals("0"))
                    cheese[i][j] = false;
                else {
                    cheese[i][j] = true;
                    cheeseCnt++;
                }

            }
        }
        int cnt = 0, lastCheeseCnt=0;
        while(cheeseCnt>0) {
            boolean check[][] = new boolean[N][M];
            lastCheeseCnt = cheeseCnt;
            cnt++;
            DFS(0,0,check);
        }
        System.out.println(cnt+"\n"+lastCheeseCnt);
    }
    static void DFS(int i, int j, boolean[][] check) {
        int[] di = {0,1,0,-1}, dj = {1,0,-1,0};
        for(int k=0;k<4;k++) {
            int ci = i+di[k], cj = j+dj[k];
            if(ci<0 || cheese.length-1<ci || cj<0 || cheese[0].length-1<cj) {
                continue;
            }
            if(!cheese[ci][cj] && !check[ci][cj]) {
                check[ci][cj]=true;
                DFS(ci,cj,check);
            }
            else if(cheese[ci][cj] && !check[ci][cj]) {
                cheese[ci][cj] = false;
                check[ci][cj]=true;
                cheeseCnt--;
            }
        }
    }
}
