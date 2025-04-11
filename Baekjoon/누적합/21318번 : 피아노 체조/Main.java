import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int arrSum[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrSum[i] = arr[i-1]>arr[i]?arrSum[i-1]+1:arrSum[i-1];
        }
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(0-arrSum[Integer.parseInt(st.nextToken())-1]+arrSum[Integer.parseInt(st.nextToken())-1]).append("\n");
        }
        System.out.println(sb);
    }
}
