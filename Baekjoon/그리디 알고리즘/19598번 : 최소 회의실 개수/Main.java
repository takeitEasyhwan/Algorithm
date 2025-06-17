import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting meetingArr[] = new Meeting[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            meetingArr[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetingArr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetingArr[0].e);

        for(int i=1;i<N;i++) {
            if(pq.peek()<=meetingArr[i].s)
                pq.poll();
            pq.offer(meetingArr[i].e);
        }
        System.out.println(pq.size());
    }
}
class Meeting implements Comparable<Meeting>{
    int s;
    int e;
    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.s!=o.s)
            return this.s - o.s;
        return this.e-o.e;
    }
}
