import java.util.*;
import java.io.*;

public class Main {
    static int check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][N];
        PriorityQueue<Virus> pq = new PriorityQueue<>(new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return o1.vi-o2.vi;
            }
        });
        Queue<Virus> queue = new LinkedList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > 0)
                    pq.add(new Virus(i,j,0,arr[i][j]));
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while(!pq.isEmpty()) {
            queue.add(pq.poll());
        }
        while(!queue.isEmpty()) {
            Virus v = queue.poll();
            if(v.day==S) break;
            if(v.i == X-1 && v.j == Y-1) break;

            if(0<v.i)
                if(arr[v.i-1][v.j]==0) {
                    queue.add(new Virus(v.i-1,v.j,v.day+1,v.vi));
                    arr[v.i-1][v.j]=v.vi;
                }
            if(0<v.j)
                if(arr[v.i][v.j-1]==0) {
                    queue.add(new Virus(v.i,v.j-1,v.day+1,v.vi));
                    arr[v.i][v.j-1]=v.vi;
                }
            if(v.i<N-1)
                if(arr[v.i+1][v.j]==0) {
                    queue.add(new Virus(v.i+1,v.j,v.day+1,v.vi));
                    arr[v.i+1][v.j]=v.vi;
                }
            if(v.j<N-1)
                if(arr[v.i][v.j+1]==0) {
                    queue.add(new Virus(v.i,v.j+1,v.day+1,v.vi));
                    arr[v.i][v.j+1]=v.vi;
                }
        }
        System.out.println(arr[X-1][Y-1]);
    }
}
class Virus {
    int i;
    int j;
    int day;
    int vi;
    Virus (int i, int j, int day, int vi) {
        this.i = i;
        this.j = j;
        this.day = day;
        this.vi = vi;
    }
}
