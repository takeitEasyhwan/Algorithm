import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char picture[][] = new char[N][N];
        boolean[][] check1 = new boolean[N][N], check2 = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                picture[i][j] = line.charAt(j);
            }
        }
        int cnt1=0, cnt2=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!check1[i][j]) {
                    check1[i][j]=true;
                    DFS1(picture, check1, i, j);
                    cnt1++;
                }
                if(!check2[i][j]) {
                    check2[i][j]=true;
                    DFS2(picture, check2, i, j);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 +" "+cnt2);
    }

    static void DFS2(char[][] picture, boolean[][] check2, int i, int j) {
        int[] di = {0,1,0,-1}, dj = {1,0,-1,0};
        for(int k=0;k<4;k++) {
            int ci = i+di[k], cj = j+dj[k];
            if(ci<0 || picture.length-1<ci || cj<0 || picture[0].length-1<cj)
                continue;
            if(!check2[ci][cj]) {
                if(picture[i][j]=='B' && picture[ci][cj]=='B') {
                    check2[ci][cj]=true;
                    DFS2(picture,check2,ci,cj);
                }
                else if(picture[i][j]!='B' && picture[ci][cj]!='B') {
                    check2[ci][cj] = true;
                    DFS2(picture, check2, ci, cj);
                }
            }
        }
    }

    static void DFS1(char[][] picture, boolean[][] check1, int i, int j) {
        int[] di = {0,1,0,-1}, dj = {1,0,-1,0};
        for(int k=0;k<4;k++) {
            int ci = i+di[k], cj = j+dj[k];
            if(ci<0 || picture.length-1<ci || cj<0 || picture[0].length-1<cj)
                continue;
            if(picture[i][j] == picture[ci][cj] && !check1[ci][cj]) {
                check1[ci][cj]=true;
                DFS1(picture,check1,ci,cj);
            }
        }
    }
}
