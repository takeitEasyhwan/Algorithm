import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxDPArr[] = new int[3];
        int minDPArr[] = new int[3];
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            int max1 = maxDPArr[0],max3 = maxDPArr[2];
            maxDPArr[0] = Math.max(maxDPArr[0],maxDPArr[1])+num1;
            maxDPArr[2] = Math.max(maxDPArr[1],maxDPArr[2])+num3;
            maxDPArr[1] = Math.max(Math.max(max1,max3),maxDPArr[1])+num2;

            int min1 = minDPArr[0],min3 = minDPArr[2];
            minDPArr[0] = Math.min(minDPArr[0],minDPArr[1])+num1;
            minDPArr[2] = Math.min(minDPArr[1],minDPArr[2])+num3;
            minDPArr[1] = Math.min(Math.min(min1,min3),minDPArr[1])+num2;
        }
        System.out.print(Math.max(Math.max(maxDPArr[0],maxDPArr[1]),maxDPArr[2])+" ");
        System.out.print(Math.min(Math.min(minDPArr[0],minDPArr[1]),minDPArr[2]));

    }
}
