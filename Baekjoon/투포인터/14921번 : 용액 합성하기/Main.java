import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int zeroVal=200_000_001;
        int p1 = 0, p2 = N-1;
        while(p1<p2) {
            int gap = arr[p2]+arr[p1];
            if(Math.abs(zeroVal)>Math.abs(gap))
                zeroVal = gap;
            if(gap>0)
                p2--;
            else
                p1++;
        }
        System.out.println(zeroVal);
    }
}
