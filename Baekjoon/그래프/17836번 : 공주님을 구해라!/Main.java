import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int board[][] = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean visited[][][] = new boolean[N][M][2];//0은 노그람, 1은 그람
        Queue<Node> q = new LinkedList<>();
        int di[] = {0,1,0,-1};
        int dj[] = {1,0,-1,0};
        q.offer(new Node(0,0,0,false));
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.count>T) break;
            if(current.i==N-1 && current.j==M-1) {
                System.out.println(current.count);
                return;
            }
            for(int i=0;i<4;i++) {
                int ci = current.i+di[i];
                int cj = current.j+dj[i];

                if(0<=ci && ci<N && 0<=cj && cj<M) {
                    if(!current.isGram) {
                        if(!visited[ci][cj][0] && board[ci][cj] == 0) {
                            q.offer(new Node(ci,cj, current.count+1,false ));
                            visited[ci][cj][0]=true;
                        }
                        else if(!visited[ci][cj][0] && board[ci][cj] == 2) {
                            q.offer(new Node(ci,cj, current.count+1,true ));
                            visited[ci][cj][0] = true;
                        }
                    }
                    else {
                        if(!visited[ci][cj][1]) {
                            q.offer(new Node(ci,cj,current.count+1,true));
                            visited[ci][cj][1] = true;
                        }

                    }
                }
            }


        }
        System.out.println("Fail");
    }
}
class Node {
    int i;
    int j;
    int count;
    boolean isGram;
    Node(int i, int j, int count, boolean isGram) {
        this.i = i;
        this.j = j;
        this.count = count;
        this.isGram = isGram;
    }
}
