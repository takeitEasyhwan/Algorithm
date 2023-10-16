import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static boolean[] visit;
    public static  int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];//방문한 곳
        arr = new int[M];//출력 array
        dfs(N,M,0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if(m==depth) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<n;i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }
}
