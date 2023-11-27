
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> checkLock;
    static boolean lockFlag;
    static int joinCnt;
    static int oneCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] mainArr = new int[H][W];
        checkLock = new ArrayList<>();
        for(int i=0;i<H;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<W;j++) {
                mainArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if(mainArr[i][j]==0) {
                    checkLock.clear();
                    checkLock.add(i*W+j);
                    mainArr[i][j] = 1;
                    lockFlag=false;
                    checkZero(mainArr, i, j);

                    if(lockFlag) {
                        for(int pos : checkLock) {
                            mainArr[pos/W][pos%W] = 2;
                        }
                    }
                }
            }
        }
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if(mainArr[i][j]==1) {
                    mainArr[i][j]=3;
                    checkOne(mainArr, i,j);
                }     
            }
        }
        System.out.println(oneCnt*6-joinCnt);
    }

    private static void checkZero(int[][] arr, int i, int j) {
        checkLock.add(i*arr[0].length+j);
        if(i==0 || j==0 || i==arr.length-1 || j==arr[0].length-1)
            lockFlag=true;
        int newJ = j+ (i%2==0?1:-1);
        if(j<arr[0].length-1) {
            if (arr[i][j + 1] == 0) {
                arr[i][j + 1] = 1;
                checkZero(arr, i, j + 1);
            }
        }
        if(j>0) {
            if (arr[i][j - 1] == 0) {
                arr[i][j - 1] = 1;
                checkZero(arr, i, j - 1);
            }
        }
        if(i>0 && 0<=newJ && newJ<=arr[0].length-1) {
            if (arr[i - 1][newJ] == 0) {
                arr[i - 1][newJ] = 1;
                checkZero(arr, i - 1, newJ);
            }
        }
        if(i>0) {
            if (arr[i - 1][j] == 0) {
                arr[i - 1][j] = 1;
                checkZero(arr, i - 1, j);
            }
        }
        if(arr.length-1>i && 0<=newJ && newJ <= arr[0].length-1) {
            if (arr[i + 1][newJ] == 0) {
                arr[i + 1][newJ] = 1;
                checkZero(arr, i + 1, newJ);
            }
        }
        if(arr.length-1>i) {
            if (arr[i + 1][j] == 0) {
                arr[i + 1][j] = 1;
                checkZero(arr, i + 1, j);
            }
        }
    }
    private static void checkOne(int[][] arr, int i, int j) {
        int newJ = j+ (i%2==0?1:-1);
        oneCnt++;
        if(j<arr[0].length-1) {
            if(arr[i][j+1]==1||arr[i][j+1]==3) {
                joinCnt++;
            }
        }
        if(j>0) {
            if(arr[i][j-1]==1||arr[i][j-1]==3) {
                joinCnt++;
            }
        }
        if(i>0 && 0<=newJ && newJ<=arr[0].length-1) {
            if(arr[i-1][newJ]==1||arr[i-1][newJ]==3) {
                joinCnt++;
            }
        }
        if(i>0) {
            if(arr[i-1][j]==1||arr[i-1][j]==3) {
                joinCnt++;
            }
        }
        if(arr.length-1>i && 0<=newJ && newJ <= arr[0].length-1) {
            if(arr[i+1][newJ]==1||arr[i+1][newJ]==3) {
                joinCnt++;
            }
        }
        if(arr.length-1>i) {
            if(arr[i+1][j]==1||arr[i+1][j]==3) {
                joinCnt++;
            }
        }

        if(j<arr[0].length-1) {
            if(arr[i][j+1]==1) {
                arr[i][j+1]=3;
                checkOne(arr,i,j+1);
            }
        }
        if(j>0) {
            if(arr[i][j-1]==1) {
                arr[i][j-1]=3;
                checkOne(arr,i,j-1);
            }
        }
        if(i>0 && 0<=newJ && newJ<=arr[0].length-1) {
            if(arr[i-1][newJ]==1) {
                arr[i-1][newJ]=3;
                checkOne(arr,i-1,newJ);
            }
        }
        if(i>0) {
            if(arr[i-1][j]==1) {
                arr[i-1][j]=3;
                checkOne(arr,i-1,j);
            }
        }
        if(arr.length-1>i && 0<=newJ && newJ <=arr[0].length-1) {
            if(arr[i+1][newJ]==1) {
                arr[i+1][newJ]=3;
                checkOne(arr,i+1,newJ);
            }
        }
        if(arr.length-1>i) {
            if(arr[i+1][j]==1) {
                arr[i+1][j]=3;
                checkOne(arr,i+1,j);
            }
        }
    }
}
