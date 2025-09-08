import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        int cnt = 0;
        L = "0".repeat(R.length()-L.length())+L;
        for(int i = 0; i < L.length(); i++) {
            if(L.charAt(i) == R.charAt(i)) {
                if(L.charAt(i)=='8')
                    cnt++;
            }
            else
                break;
        }
        System.out.println(cnt);
    }
}
//8181 8382
