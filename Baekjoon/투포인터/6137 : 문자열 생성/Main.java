import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int cnt=0;
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine().charAt(0)-'A';
        }
        int p1=0,p2=N-1;
        while(p1<=p2) {
            if(arr[p1]<arr[p2]) {
                sb.append((char)('A'+arr[p1]));
                p1++;
            }
            else if(arr[p1]>arr[p2]) {
                sb.append((char)('A'+arr[p2]));
                p2--;
            }
            else {
                boolean flag = false;//true면 p1++, false면 p2--
                flag = CheckAlpha(p1, p2, arr);
                if (flag) {
                    sb.append((char)('A' + arr[p1]));
                    p1++;
                } else {
                    sb.append((char)('A' + arr[p2]));
                    p2--;
                }
            }
            cnt++;
            if(cnt%80==0)
                sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean CheckAlpha(int p1, int p2, int[] arr) {
        while(true) {
            p1++;
            p2--;
            if(p1>=p2)
                break;
            if(arr[p1]<arr[p2])
                return true;
            else if(arr[p1]>arr[p2])
                return false;
        }
        return true;
    }
}
