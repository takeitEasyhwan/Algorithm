import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Numset> arrayListNumset = new ArrayList<>();
        int[][] arrayAlpha = new int['Z'-'A'+1][8];//[어떤 알파벳][몇자리수]
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<line.length();j++) {
                arrayAlpha[line.charAt(line.length()-j-1)-'A'][arrayAlpha[0].length-j-1]++;
            }
        }

        for(int i=0;i<arrayAlpha.length;i++) {
            int sum=0;
            for(int j=0;j<arrayAlpha[0].length;j++) {
                if(arrayAlpha[i][j]!=0)
                    sum+=(int)Math.pow(10,arrayAlpha[0].length-j-1)*arrayAlpha[i][j];
            }
            if(sum!=0) {
                arrayListNumset.add(new Numset((char) ('A'+i),sum));
            }
        }
        Collections.sort(arrayListNumset);

        int multNum = 9;
        int sum=0;
        for(int i=0;i<arrayListNumset.size();i++) {
            sum+=arrayListNumset.get(i).num*multNum--;
        }
        System.out.println(sum);


    }
    static class Numset implements Comparable<Numset> {
        char alpha;
        int num;
        Numset(char alpha, int num) {
            this.alpha=alpha;
            this.num=num;
        }

        @Override
        public int compareTo(Numset o) {
            return o.num-this.num;
        }
    }
}
