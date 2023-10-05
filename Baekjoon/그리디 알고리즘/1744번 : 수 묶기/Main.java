import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();
        int sum=0;
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==1)
                sum++;
            else if(num>0)
                plusList.add(num);
            else
                minusList.add(num);
        }
        Collections.sort(plusList);
        Collections.sort(minusList);
        Collections.reverse(plusList);
        if(plusList.size()%2!=0)
            plusList.add(1);
        if(minusList.size()%2!=0)
            minusList.add(1);
        for(int i=0;i<plusList.size();i+=2) {
            sum+= plusList.get(i)*plusList.get(i+1);
        }
        for(int i=0;i<minusList.size();i+=2) {
            sum+= minusList.get(i)*minusList.get(i+1);
        }
        System.out.println(sum);
    }
}
