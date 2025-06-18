import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sum =0;
        int c1=0, c2=0;
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            sum+=num;
            c1+=num%2;
            c2+=num/2;
        }
        if(sum%3!=0 || c1>c2)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
