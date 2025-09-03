import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int arr[] = new int[N+k];
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            if(i<k-1) {
                arr[i+N] = num;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        map.put(c,1);
        for(int i=0;i<k;i++) {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        max = map.size();
        for(int i=0;i<N-1;i++) {
            if(map.containsKey(arr[i+k]))
                map.put(arr[i+k],map.get(arr[i+k])+1);
            else
                map.put(arr[i+k],1);

            if(map.get(arr[i])>1)
                map.put(arr[i],map.get(arr[i])-1);
            else
                map.remove(arr[i]);
            max = Math.max(max,map.size());
        }
        System.out.println(max);
    }
}
