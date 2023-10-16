import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[] arr;
    public static int cnt;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt=0;
        checkQueen(N,0);
        System.out.println(cnt);
    }

    private static void checkQueen(int n, int floor) {
        for(int i=0;i<n;i++) {
            if(check(i, floor)) {
                arr[floor]=i;
                if(n==floor+1) {
                    cnt++;
                }
                else {
                    checkQueen(n,floor+1);
                }
            }
        }
    }

    private static boolean check(int pos,int floor) {
        for(int i=0;i<floor;i++) {
            if(arr[i]==pos)
                return false;
            if(Math.abs(i-floor) == Math.abs(arr[i]-pos))
                return false;
        }
        return true;
    }
}
