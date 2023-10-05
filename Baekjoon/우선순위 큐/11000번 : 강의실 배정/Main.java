import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Solution> arrayList = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arrayList.add(new Solution(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arrayList, new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                if(o1.s==o2.s)
                    return o1.e-o2.e;
                return o1.s-o2.s;
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(arrayList.get(0).e);
        for(int i=1;i< arrayList.size();i++) {
            if(priorityQueue.peek()<=arrayList.get(i).s) {
                priorityQueue.poll();
            }
            priorityQueue.offer(arrayList.get(i).e);
        }
        System.out.println(priorityQueue.size());
    }
    static class Solution {
        int s,e;
        Solution(int s,int e) {this.s=s; this.e=e;}
    }
}
//3
//1 3
//2 4
//3 5

//2
