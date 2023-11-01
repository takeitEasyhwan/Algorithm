import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] check;
    public static Set<Character> set = Set.of('a','e','i','o','u');
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        check = new boolean[C];
        Character[] charArr = new Character[C];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++)  {
            charArr[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(charArr);
        recur(0,0,0,0,L,charArr);
        System.out.println(sb);
    }

    private static void recur(int startIndex, int count, int vCnt, int cCnt, int L, Character[] charArr) {
        if(vCnt>=L-1 || cCnt>=L)
            return;
        if(count==L) {
            for(int i=0;i<check.length;i++) {
                if(check[i])
                    sb.append(charArr[i]);
            }
            sb.append("\n");
            return;
        }
        for(int i=startIndex;i<charArr.length;i++) {
            if(!check[i]) {
                check[i]=true;
                if(set.contains(charArr[i]))
                    recur(i+1,count+1, vCnt+1,cCnt,L,charArr);
                else
                    recur(i+1,count+1, vCnt,cCnt+1,L,charArr);
                check[i]=false;
            }
        }
    }
}
