
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int check[] = new int[N];
        Stack<hashData> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                if(stack.empty()) {
                    stack.push(new hashData(num,i));
                    break;
                }
                else if(stack.peek().num<num) {
                    check[stack.peek().index]=num;
                    stack.pop();
                }
                else {
                    stack.push(new hashData(num,i));
                    break;
                }
            }
        }
        while(!stack.empty()) {
            check[stack.pop().index]=-1;
        }
        //
        for(int i=0;i<N;i++) {
            sb.append(check[i]+" ");    
        }
        System.out.println(sb);
    }
    static class hashData {
        int num;
        int index;
        public hashData(int num, int index){
            this.num = num;
            this.index = index;
        }

    }
}
