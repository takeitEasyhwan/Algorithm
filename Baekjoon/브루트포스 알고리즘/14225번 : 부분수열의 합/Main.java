import java.util.*;
import java.io.*;
public class Main {
    static boolean[] check = new boolean[2_000_000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int arr[] = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;
        for(int i=0;i<N;i++) {
            rec(arr,i,N,sum);
        }
        for(int i=1;i<check.length;i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }

        }
    }

    private static void rec(int[] arr, int i, int N,int sum) {
        sum+=arr[i];
        check[sum] = true;
        for(int j=i+1;j<N;j++) {
            rec(arr,j,N,sum);

        }

        sum-=arr[i];
    }
}
