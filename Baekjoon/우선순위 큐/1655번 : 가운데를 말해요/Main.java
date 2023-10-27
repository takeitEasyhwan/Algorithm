import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> frontPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> backPriorityQueue = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0)
                frontPriorityQueue.add(num);
            else
                backPriorityQueue.add(num);
            if(i!=0) {
                backPriorityQueue.add(frontPriorityQueue.poll());
                frontPriorityQueue.add(backPriorityQueue.poll());
            }
            sb.append(frontPriorityQueue.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
