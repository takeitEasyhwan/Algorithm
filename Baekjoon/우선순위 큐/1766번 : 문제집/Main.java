import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] check = new int[N+1];
        for(int i=0;i<N+1;i++) {
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arrayList.get(num1).add(num2);
            check[num2]++;
        }
        for(int i=1;i<=N;i++) {
            if(check[i]==0) {
                priorityQueue.add(i);
            }
        }
        while(!priorityQueue.isEmpty()) {
            int pollNum = priorityQueue.poll();
            for(int i : arrayList.get(pollNum)) {
                check[i]--;
                if(check[i]==0)
                    priorityQueue.add(i);
            }
            sb.append(pollNum+" ");
        }

        System.out.println(sb);

    }
}
