import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        int check[] = new int[100_001];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int p1=0, p2=0;
        check[arr[0]]++;
        int max=0;
        boolean flag=false;
        do {
            if(!flag) {
                check[arr[++p2]]++;
                if(check[arr[p2]]>K)
                    flag=true;
            }
            else {
                check[arr[p1]]--;
                if(check[arr[p1]]==K)
                    flag=false;
                p1++;
            }
            if(!flag)
                max = Integer.max(max,p2-p1+1);
        }while(p2<N-1);
        System.out.println(max);
    }
}
