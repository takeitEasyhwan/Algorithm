import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean map[][] = new boolean[N][M];

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = line.charAt(j)=='1'?true:false;
            }
        }
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0,1));
        map[0][0] = false;
        while(!queue.isEmpty()) {
            Pos pollPos = queue.poll();
            if(pollPos.i==N-1 && pollPos.j==M-1) {
                System.out.println(pollPos.cnt);
                break;
            }
            if(0<pollPos.i) {
                if(map[pollPos.i-1][pollPos.j]) {
                    map[pollPos.i-1][pollPos.j] = false;
                    queue.add(new Pos(pollPos.i-1,pollPos.j,pollPos.cnt+1));
                }
            }
            if(0<pollPos.j) {
                if(map[pollPos.i][pollPos.j-1]) {
                    map[pollPos.i][pollPos.j-1] = false;
                    queue.add(new Pos(pollPos.i,pollPos.j-1,pollPos.cnt+1));
                }
            }
            if(pollPos.i<N-1) {
                if(map[pollPos.i+1][pollPos.j]) {
                    map[pollPos.i+1][pollPos.j] = false;
                    queue.add(new Pos(pollPos.i+1,pollPos.j,pollPos.cnt+1));
                }
            }
            if(pollPos.j<M-1) {
                if(map[pollPos.i][pollPos.j+1]) {
                    map[pollPos.i][pollPos.j+1] = false;
                    queue.add(new Pos(pollPos.i,pollPos.j+1,pollPos.cnt+1));
                }
            }
        }
    }
}
class Pos {
    int i;
    int j;
    int cnt;
    Pos(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}
