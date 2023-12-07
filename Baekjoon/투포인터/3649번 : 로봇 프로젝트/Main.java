import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            while(true) {//9_999_999
                int x = Integer.parseInt(br.readLine()) * 10_000_000;
                int n = Integer.parseInt(br.readLine());
                Integer[] arr = new Integer[n];
                for(int i=0;i<n;i++) {
                    arr[i] = Integer.parseInt(br.readLine());
                }
                Arrays.sort(arr);

                boolean check = false;
                int s=0, e=n-1;
                while(s<e) {
                    if(arr[s]+arr[e]==x) {
                        check = true;
                        break;
                    }
                    else if(arr[s]+arr[e]>x) {
                        e--;
                    }
                    else {
                        s++;
                    }
                }
                if(check)
                    sb.append("yes ").append(arr[s]).append(" ").append(arr[e]).append("\n");
                else
                    sb.append("danger").append("\n");
            }
        }
        catch (Exception e) {
            System.out.println(sb);
        }
    }
}
