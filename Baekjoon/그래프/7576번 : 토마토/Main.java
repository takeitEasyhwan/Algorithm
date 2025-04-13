import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int tomatoCnt = 0;
        int finalTomatoDate=0;
        Queue<Tomato> queue = new LinkedList<>();
        int[][] farm = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n==0)
                    farm[i][j] = 0;
                else if(n==1) {
                    farm[i][j] = 1;
                    queue.add(new Tomato(i,j,0));
                    tomatoCnt++;
                }
                else {
                    farm[i][j] = -1;
                    tomatoCnt++;
                }
            }
        }
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            finalTomatoDate = tomato.date;
            if(0<tomato.i) {
                if(farm[tomato.i-1][tomato.j]==0) {
                    tomatoCnt++;
                    queue.add(new Tomato(tomato.i-1,tomato.j,tomato.date+1));
                    farm[tomato.i-1][tomato.j]=1;
                }
            }
            if(0<tomato.j) {
                if(farm[tomato.i][tomato.j-1]==0) {
                    tomatoCnt++;
                    queue.add(new Tomato(tomato.i,tomato.j-1,tomato.date+1));
                    farm[tomato.i][tomato.j-1]=1;
                }
            }
            if(tomato.i<N-1) {
                if(farm[tomato.i+1][tomato.j]==0) {
                    tomatoCnt++;
                    queue.add(new Tomato(tomato.i+1,tomato.j,tomato.date+1));
                    farm[tomato.i+1][tomato.j]=1;
                }
            }
            if(tomato.j<M-1) {
                if(farm[tomato.i][tomato.j+1]==0) {
                    tomatoCnt++;
                    queue.add(new Tomato(tomato.i,tomato.j+1,tomato.date+1));
                    farm[tomato.i][tomato.j+1]=1;
                }
            }
        }
        if(tomatoCnt == M*N)
            System.out.println(finalTomatoDate);
        else
            System.out.println(-1);

    }
}
class Tomato {
    int i;
    int j;
    int date;
    Tomato(int i, int j, int date) {
        this.i = i;
        this.j = j;
        this.date = date;
    }
}
