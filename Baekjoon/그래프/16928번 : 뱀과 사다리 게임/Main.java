import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer,Integer> ladderMap = new HashMap<>();
        Map<Integer,Integer> snakeMap = new HashMap<>();
        int[] gameBoard = new int[101];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            ladderMap.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            snakeMap.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        System.out.println(bfs(ladderMap,snakeMap,gameBoard));
    }

    private static int bfs(Map<Integer, Integer> ladderMap, Map<Integer, Integer> snakeMap, int[] gameBoard) {
        Queue<Integer> posQueue = new LinkedList<>();
        posQueue.offer(1);
        while(true) {
            int pos = posQueue.poll();
            for(int i=1;i<=6;i++) {
                int newPos=pos+i;
                if(ladderMap.containsKey(newPos))
                    newPos = ladderMap.get(newPos);
                else if(snakeMap.containsKey(newPos))
                    newPos = snakeMap.get(newPos);

                if(newPos==100) {
                    return gameBoard[pos]+1;
                }

                if(gameBoard[newPos]==0) {
                    gameBoard[newPos] = gameBoard[pos]+1;
                    posQueue.offer(newPos);
                }
                else if(gameBoard[newPos]>gameBoard[pos]+1){
                    gameBoard[newPos] = gameBoard[pos]+1;
                    posQueue.offer(newPos);
                }
            }
        }
    }
}
