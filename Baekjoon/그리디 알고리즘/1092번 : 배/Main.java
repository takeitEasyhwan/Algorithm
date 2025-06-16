import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int craneArr[] = new int[N];
        for(int i=0;i<N;i++)
            craneArr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(craneArr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int boxArr[] = new int[M];
        for(int i=0;i<M;i++)
            boxArr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(boxArr);
        boolean check[] = new boolean[M];
        int cnt=0, boxCnt=0;
        while(true) {
            cnt++;
            int cp = N-1, bp = M-1;
            boolean flag = false;
            while(cp>=0 && bp>=0) {
                if(check[bp]) {
                    bp--;
                }
                else if(craneArr[cp]>=boxArr[bp]) {
                    check[bp] = true;
                    cp--;
                    bp--;
                    boxCnt++;
                    flag = true;
                }
                else if(craneArr[cp]<boxArr[bp]) {
                    bp--;
                }
            }
            if(!flag) {
                System.out.println(-1);
                return;
            }
            if(boxCnt==M)
                break;
        }
        System.out.println(cnt);
    }
}
