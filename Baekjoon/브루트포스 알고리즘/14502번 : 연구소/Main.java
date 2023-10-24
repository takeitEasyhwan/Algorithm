import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        findRoom(arr,0,N,M,0,0);
        System.out.println(max);
    }

    private static void findRoom(int[][] arr, int count, int N, int M, int lastI, int lastJ) {
        if(count==3) {
            //check virus
            checkVirus(arr,N,M);
            return;
        }
        for(int i=lastI;i<N;i++) {
            int j=0;
            if(i==lastI)
                j=lastJ;
            for(;j<M;j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=1;
                    findRoom(arr,count+1,N,M,i,j);
                    arr[i][j]=0;
                }
            }
        }
    }
    private static void checkVirus(int[][] arr, int N, int M) {
        int[][] tempArr = new int[N][M];
        int cnt=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                tempArr[i][j] = arr[i][j];
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(tempArr[i][j]==2)
                    checkContamination(tempArr,i,j,N,M);
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(tempArr[i][j] == 0)
                    cnt++;
            }
        }
        if(max<cnt)
            max=cnt;
    }

    private static void checkContamination(int[][] arr, int ipos, int jpos, int N, int M) {
        if(ipos>0) {
            if(arr[ipos-1][jpos]==0) {
                arr[ipos-1][jpos]=2;
                checkContamination(arr,ipos-1,jpos,N,M);
            }
        }
        if(jpos>0) {
            if(arr[ipos][jpos-1]==0) {
                arr[ipos][jpos-1]=2;
                checkContamination(arr,ipos,jpos-1,N,M);
            }
        }
        if(ipos<N-1) {
            if(arr[ipos+1][jpos]==0) {
                arr[ipos+1][jpos]=2;
                checkContamination(arr,ipos+1,jpos,N,M);
            }
        }
        if(jpos<M-1) {
            if(arr[ipos][jpos+1]==0) {
                arr[ipos][jpos+1]=2;
                checkContamination(arr,ipos,jpos+1,N,M);
            }
        }

    }
}
