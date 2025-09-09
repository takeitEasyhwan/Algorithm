import java.io.*;
import java.util.*;


public class Main {
    static boolean[][] board;
    static int boardSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int maxBoardSize = 0;
        board = new boolean[n][m];
        int boardCnt = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = st.nextToken().equals("1");
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j]) {
                    boardSize=0;
                    boardCnt++;
                    BFS(i,j);
                    maxBoardSize = Math.max(maxBoardSize, boardSize);
                }
            }
        }
        System.out.println(boardCnt+"\n"+maxBoardSize);
    }

    private static void BFS(int i, int j) {
        board[i][j] = false;
        boardSize++;
        int[] iIndex ={1,0,-1,0};
        int[] jIndex ={0,1,0,-1};
        for(int k=0;k<4;k++) {
            if(i+iIndex[k]<0||i+iIndex[k]>board.length-1||j+jIndex[k]<0||j+jIndex[k]>board[0].length-1) {
                continue;
            }
            if(board[i+iIndex[k]][j+jIndex[k]]) {
                BFS(i+iIndex[k],j+jIndex[k]);
            }
        }
    }
}
