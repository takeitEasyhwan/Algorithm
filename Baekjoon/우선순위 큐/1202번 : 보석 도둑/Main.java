import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Jewel> jewelList = new ArrayList<>();
        ArrayList<Integer> bagList = new ArrayList<>();
        long sum=0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            jewelList.add(new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        for(int i=0;i<K;i++) {
            bagList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jewelList);
        Collections.sort(bagList);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0,j=0;i<K;i++) {//i->가방, j->보석
            while(j<N && jewelList.get(j).weight<=bagList.get(i)) {
                priorityQueue.offer(jewelList.get(j++).price);
            }
            if(!priorityQueue.isEmpty())
                sum+= priorityQueue.poll();

        }
        System.out.println(sum);
    }
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int price;
        Jewel(int weight,int price) {this.weight=weight;this.price=price;}

        @Override
        public int compareTo(Jewel o) {
            if(this.weight==o.weight)
                return o.price-this.price;
            return this.weight-o.weight;
        }
    }
}

