import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int AMaxNum=-1;
        int ASum = 0;
        ArrayList<Integer> maxNumIndexArrayList = new ArrayList<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            ASum += num;
            if(num>AMaxNum) {
                AMaxNum = num;
                maxNumIndexArrayList.clear();
                maxNumIndexArrayList.add(i);
            }
            else if(num==AMaxNum) {
                maxNumIndexArrayList.add(i);
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        int BMaxNum=-1;
        int BSum = 0;
        int BArray[] = new int[M];
        for(int i=0;i<M;i++) {
            int num = Integer.parseInt(st.nextToken());
            BArray[i]=num;
            BSum += num;
            if(num>BMaxNum) {
                BMaxNum = num;
            }
        }
        long sum=0;
        sum += (long)(ASum + AMaxNum*(M-1))*1_000_000_000;
        if(maxNumIndexArrayList.size()==1)
            sum+=BSum + BArray[0]*(maxNumIndexArrayList.get(0)) + BArray[M-1]*(N-maxNumIndexArrayList.get(0)-1);
        else
            sum+=BSum + BArray[0]*(maxNumIndexArrayList.get(0)) + BMaxNum*(maxNumIndexArrayList.get(maxNumIndexArrayList.size()-1)-maxNumIndexArrayList.get(0)) + (N-maxNumIndexArrayList.get(maxNumIndexArrayList.size()-1)-1)*BArray[M-1];

        System.out.println(sum);
    }
}
