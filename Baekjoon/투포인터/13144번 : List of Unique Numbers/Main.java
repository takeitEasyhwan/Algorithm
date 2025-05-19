import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] check = new int[100_001];
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0;
        while (left < N) {
            while (right < N && check[arr[right]] == 0) {
                check[arr[right]]++;
                right++;
            }
            sum += (right - left);
            check[arr[left]]--;
            left++;
        }
        System.out.println(sum);
    }
}
