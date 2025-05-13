import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        long sum1=0, sum2=0;

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            sum1+= num;
            sum2+= num*num;
        }
        System.out.println((sum1*sum1-sum2)/2);
    }
}
