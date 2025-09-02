import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int min;
        int rCnt = 0, bCnt=0;
        for(int i=0;i<N;i++) {
            if(line.charAt(i)=='R')rCnt++;
            else bCnt++;
        }
        int currentRCnt = 0, currentBCnt = 0;
        for(int i=0;i<N;i++) {
            if(line.charAt(i)=='R')currentRCnt++;
            else currentBCnt++;
            if(currentBCnt==bCnt || currentRCnt == rCnt)
                break;
        }
        min = Integer.min(currentRCnt, currentBCnt);
        currentRCnt = 0;
        currentBCnt =0;

        for(int i=N-1;i>=0;i--) {
            if(line.charAt(i)=='R')currentRCnt++;
            else currentBCnt++;
            if(currentBCnt==bCnt || currentRCnt == rCnt)
                break;
        }
        min = Integer.min(min , Integer.min(currentRCnt, currentBCnt));
        System.out.println(min);
    }
}
