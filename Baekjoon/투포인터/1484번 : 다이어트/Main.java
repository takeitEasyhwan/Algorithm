import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int G = Integer.parseInt(br.readLine());
        int p1=1,p2=2;
        while(p2>p1) {
            if(p2-p1==1 && Math.pow(p2,2)-Math.pow(p1,2)>G) {
                break;
            }
            if(Math.pow(p2,2)-Math.pow(p1,2)==G) {
                sb.append(p2).append("\n");
                p1++;
                p2++;
            }
            else if(Math.pow(p2,2)-Math.pow(p1,2)>G)
                p1++;
            else
                p2++;
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
