import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n =  Integer.parseInt(st.nextToken());
        int num =  Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s=0, e = 0;
        int min = 100_000_001;
        int sum = 0;
        while(s<=n && e<=n) {
            if(sum >= num && min>e-s) {
                min=e-s;
            }
            sum+=sum<num?arr[e++]:-arr[s++];
        }
        System.out.println(min==100_000_001?0:min);
    }
}
