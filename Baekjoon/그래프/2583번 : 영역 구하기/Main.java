import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static boolean[][] map;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        ArrayList<Integer> section = new ArrayList<>();
        map = new boolean[N][M];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            markBoard(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!map[i][j]) {
                    cnt++;
                    size = 0;
                    BFS(i,j);
//                    sb.append(size).append(" ");
                    section.add(size);
                }
            }
        }
        section.sort(Comparator.naturalOrder());
        sb.append(cnt).append("\n");
        for(int i=0;i<section.size();i++) {
            sb.append(section.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        map[i][j] = true;
        size++;
        int[] iIndex = {-1,0,1,0};
        int[] jIndex = {0,-1,0,1};
        for(int k=0;k<4;k++) {
            if(0<=i+iIndex[k] && i+iIndex[k]<map.length && 0<=j+jIndex[k] && j+jIndex[k]<map[i].length) {
                if(!map[i+iIndex[k]][j+jIndex[k]]) {
                    BFS(i+iIndex[k],j+jIndex[k]);
                }
            }
        }
    }

    static void markBoard(int i1, int j1, int i2, int j2) {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(i1<=j && j<i2 && j1<=i && i<j2) {// 1 ~ 2, 1 ~ 5
                    map[i][j] = true;
                }
            }
        }
    }

}
