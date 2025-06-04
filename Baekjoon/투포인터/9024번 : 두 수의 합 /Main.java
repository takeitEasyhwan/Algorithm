import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int p1 = 0, p2 = n-1;
            int cnt=0, minGap=Integer.MAX_VALUE;
            while(p1<p2) {
                if(Math.abs(arr[p1]+arr[p2]-K)==minGap) {
                    cnt++;
                }
                else if(Math.abs(arr[p1]+arr[p2]-K)<minGap) {
                    minGap = Math.abs(arr[p1]+arr[p2]-K);
                    cnt=1;
                }

                if(arr[p1]+arr[p2]<K)
                    p1++;
                else if(arr[p1]+arr[p2]>K)
                    p2--;
                else {
                    p1++;
                    p2--;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
