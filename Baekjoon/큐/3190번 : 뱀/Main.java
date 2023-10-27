import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int cnt=0;
        SnakePoint head = new SnakePoint(1,1);
        Queue<String> bodyQueue = new LinkedList<>();
        HashSet<String> bodySet = new HashSet<>();

        HashSet<String> appleSet = new HashSet<>();
        for(int i=0;i<K;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String appleYPos = st.nextToken();
            String appleXPos = st.nextToken();
            appleSet.add(appleXPos+" "+appleYPos);
        }
        int L = Integer.parseInt(br.readLine());
        int lastSecond=0;
        for(int i=0;i<=L;i++) {
            StringTokenizer st;
            int thisSecond;
            String turn;
            if(i!=L) {
                st = new StringTokenizer(br.readLine(), " ");
                thisSecond = Integer.parseInt(st.nextToken());
                turn = st.nextToken();
            }
            else {
                thisSecond = Integer.MAX_VALUE;
                turn = "D";
            }
            for(int j=0;j<thisSecond-lastSecond;j++) {
                cnt++;
                bodyQueue.add(head.xPos+" "+head.yPos);
                bodySet.add(head.xPos+" "+head.yPos);
                switch (head.direction) {
                    case 0->head.xPos++;
                    case 1->head.yPos++;
                    case 2->head.xPos--;
                    case 3->head.yPos--;
                }
                if(head.xPos<=0||head.xPos>N||head.yPos<=0||head.yPos>N) {
                    System.out.println(cnt);
                    return;
                }
                if(bodySet.contains(head.xPos+" "+head.yPos)) {
                    System.out.println(cnt);
                    return;
                }

                if(appleSet.contains(head.xPos+" "+head.yPos)) {
                    appleSet.remove(head.xPos+" "+head.yPos);
                }
                else {
                    bodySet.remove(bodyQueue.poll());
                }
            }
            lastSecond=thisSecond;
            head.turn(turn);
        }

        System.out.println(cnt);
    }
    static class SnakePoint {
        public int xPos;
        public int yPos;
        public int direction;//0->오른쪽,1->아래,2->왼쪽,3->위쪽
        SnakePoint(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
            direction = 0;
        }

        public void turn(String turn){
            if(turn.equals("D"))
                this.direction=(this.direction+1)%4;
            else {
                this.direction=(this.direction+3)%4;
            }
        }
    }
}
