import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<line> arrayList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arrayList.add(new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arrayList);
//        for(int i=0;i<N;i++) {
//            System.out.println(arrayList.get(i).s+" "+arrayList.get(i).e);
//        }
        int s=arrayList.get(0).s, e=arrayList.get(0).e;
        int sum=0;
        for(int i=1;i<N;i++) {
            if(e<arrayList.get(i).s) {
                sum += e-s;
                e=arrayList.get(i).e;
                s=arrayList.get(i).s;
            }
            else
                e= Math.max(e,arrayList.get(i).e);
        }
        sum+=e-s;
        System.out.println(sum);
    }
    static class line implements Comparable<line>{
        int s,e;
        line(int s,int e){this.s=s;this.e=e;}


        @Override
        public int compareTo(line o) {
            if(this.s==o.s)
                return this.e-o.e;
            return this.s-o.s;
        }
    }
}
