import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] paradeGround = new int[N];
        int[] sumArr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++)
            paradeGround[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sumArr[a-1]+=k;
            sumArr[b]-=k;
        }
        for(int i=0;i<N;i++) {
            sumArr[i+1]+=sumArr[i];
            sb.append(paradeGround[i]+sumArr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
