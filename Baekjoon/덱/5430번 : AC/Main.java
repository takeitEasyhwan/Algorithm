import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            Bundle bun = new Bundle(br.readLine(),Integer.parseInt(br.readLine()), br.readLine());
            bun.readCommand();
            bun.printBundle();
        }
        System.out.println(sb);
    }
    static class Bundle{
        boolean direction;
        String command;
        Deque<Integer> deque;
        boolean errorCheck;
        Bundle(String command, int size, String line) {
            deque = new ArrayDeque<>();
            this.command = command;
            StringTokenizer st = new StringTokenizer(line,"[],");
            for(int i=0;i<size;i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            this.errorCheck = true;
            this.direction = true;
        }
        public void readCommand(){
            for(int i=0;i<command.length();i++) {
                if(command.charAt(i)=='R') {
                    direction=!direction;
                }
                else if(deque.isEmpty()) {
                    errorCheck = false;
                    return;
                }
                else if(direction) {
                    deque.pollFirst();
                }
                else
                    deque.pollLast();
            }
        }
        public void printBundle(){
            if (!errorCheck) {
                sb.append("error").append("\n");
                return;
            }
            sb.append("[");
            while(!deque.isEmpty()) {
                if(direction)
                    sb.append(deque.pollFirst());
                else
                    sb.append(deque.pollLast());
                if(deque.isEmpty())
                    break;
                sb.append(",");
            }
            sb.append("]\n");
        }
    }
}
