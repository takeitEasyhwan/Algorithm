//2580
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static int[][] sudokuArr = new int[9][9];
    public static Pos[] emptyArr;
    public static ArrayList<Pos> emptyPosList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < sudokuArr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < sudokuArr[0].length; j++) {
                int num = Integer.parseInt(st.nextToken());
                sudokuArr[i][j] = num;
                if(num==0) {
                    emptyPosList.add(new Pos(i,j));
                }
            }
        }
        emptyArr = new Pos[emptyPosList.size()];
        checkSudoku(0);

    }

    private static void checkSudoku(int index) {
        int indexIpos = emptyPosList.get(index).i;
        int indexJpos = emptyPosList.get(index).j;
        for(int i=1;i<=9;i++) {
            sudokuArr[indexIpos][indexJpos] = i;
            if(checkCorrect(index)) {
                if(emptyPosList.size()==index+1) {
                    printArr();
                    System.exit(0);
                }
                else
                    checkSudoku(index+1);
            }
            sudokuArr[indexIpos][indexJpos] = 0;
        }
    }

    private static void printArr() {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++)
                sb.append(sudokuArr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkCorrect(int index) {
        int indexIpos = emptyPosList.get(index).i;
        int indexJpos = emptyPosList.get(index).j;
        int num = sudokuArr[indexIpos][indexJpos];
        //가로, 세로, 9조각 check
        for(int i=0;i<9;i++) {
            if(sudokuArr[indexIpos][i]==num && i!=indexJpos)
                return false;
            if(sudokuArr[i][indexJpos]==num && i!=indexIpos)
                return false;
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(num==sudokuArr[i+indexIpos-indexIpos%3][j+indexJpos-indexJpos%3] && i!=indexIpos%3 && j!=indexJpos%3)
                    return false;
            }
        }
        return true;
    }

    static class Pos {
        int i,j;
        Pos(int i,int j) {
            this.i=i;
            this.j=j;
        }
    }
}
