import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Integer[] array = new Integer[N];
        for(int i=0;i<N;i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int goodCnt = 0;
        for(int i=0;i<N;i++) {
            int firstPointer = 0, secondPointer = N-1;
            while(true) {
                if(firstPointer==i)
                    firstPointer++;
                else if(secondPointer==i)
                    secondPointer--;

                if(firstPointer>=secondPointer)
                    break;

                if(array[firstPointer]+array[secondPointer]==array[i]) {
                    goodCnt++;
                    break;
                }
                else if(array[firstPointer]+array[secondPointer]>array[i])
                    secondPointer--;
                else
                    firstPointer++;
            }
        }
        System.out.println(goodCnt);
    }
}
