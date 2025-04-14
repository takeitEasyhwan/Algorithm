import java.util.*;
import java.io.*;

public class Main {
    static int maxSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char board[][] = new char[R][C];
        for(int i=0;i<R;i++) {
            String line = br.readLine();
            for(int j=0;j<C;j++) {
                board[i][j] = line.charAt(j);
            }
        }
        Set<Character> set = new HashSet<>();
        DFS(0,0,set,board);
        System.out.println(maxSize);
    }

    static void DFS(int i, int j, Set<Character> set, char[][] board) {
        set.add(board[i][j]);
//        System.out.println(set);
        maxSize = Math.max(set.size(),maxSize);
        if(0<i) {
            if(!set.contains(board[i-1][j])) {
                DFS(i-1,j,set,board);
            }
        }
        if(0<j) {
            if(!set.contains(board[i][j-1])) {
                DFS(i,j-1,set,board);
            }
        }
        if(i<board.length-1) {
            if(!set.contains(board[i+1][j])) {
                DFS(i+1,j,set,board);
            }
        }
        if(j<board[0].length-1) {
            if(!set.contains(board[i][j+1])) {
                DFS(i,j+1,set,board);
            }
        }
        set.remove(board[i][j]);
    }
}


