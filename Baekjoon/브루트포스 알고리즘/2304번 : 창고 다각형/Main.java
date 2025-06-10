import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pos arr[] = new Pos[N];
        int highestPos=0, highestHeight = 0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int cPos = Integer.parseInt(st.nextToken());
            int cHeight = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(cPos,cHeight);
            if(highestHeight<cHeight) {
                highestHeight = cHeight;
                highestPos = cPos;
            }
        }
        Arrays.sort(arr);
        int sum=0;
        int lastHeight=0;
        int lastPos=0;
        for(int i=0;i<N;i++) {
            if(i==0) {
                lastPos = arr[i].pos;
                lastHeight = arr[i].height;
            }
            else if(lastHeight<=arr[i].height) {
                sum+=(arr[i].pos-lastPos)*lastHeight;
                lastPos = arr[i].pos;
                lastHeight = arr[i].height;
            }
        }
        lastHeight=0;
        lastPos=0;
        for(int i=0;i<N;i++) {
            if(i==0) {
                lastPos = arr[N-1-i].pos;
                lastHeight = arr[N-1-i].height;
            }
            else if(lastHeight<arr[N-1-i].height) {
                sum+=(lastPos- arr[N-1-i].pos)*lastHeight;
                lastPos = arr[N-1-i].pos;
                lastHeight = arr[N-1-i].height;
            }
        }
        System.out.println(sum+highestHeight);
    }
}
class Pos implements Comparable<Pos>{
    int pos;
    int height;
    Pos(int pos, int height){
        this.pos = pos;
        this.height = height;
    }

    @Override
    public int compareTo(Pos o) {
        return this.pos - o.pos;
    }
}
