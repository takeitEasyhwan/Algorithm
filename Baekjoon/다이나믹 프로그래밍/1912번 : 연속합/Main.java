import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int min = 0;
        int answer = Integer.MIN_VALUE;
        arr[0]=0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++) {
            answer = Math.max(answer,arr[i]-min);
            min = Math.min(min,arr[i]);
        }
        System.out.println(answer);
    }
}
