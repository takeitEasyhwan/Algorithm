import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] maps) {
        int[][] mapArray = new int[maps.length][maps[0].length()];
        ArrayList<Integer> sums = new ArrayList<>();

        for(int i=0;i< mapArray.length;i++) {
            for(int j=0;j<mapArray[0].length;j++) {
                if(maps[i].charAt(j)=='X')
                    mapArray[i][j]=0;
                else
                    mapArray[i][j]=maps[i].charAt(j)-'0';
            }
        }
        for(int i=0;i< mapArray.length;i++) {
            for(int j=0;j<mapArray[0].length;j++) {
                if(mapArray[i][j]!=0){
                    int sum = mapArray[i][j];
                    mapArray[i][j]=0;
                    sums.add(sum + checkArr(mapArray,i,j));
                }

            }
        }
        int[] answer = {};
        if(sums.isEmpty()){
            answer=new int[1];
            answer[0]=-1;
        }
        else {
            answer = new int[sums.size()];
            sums.sort(Comparator.naturalOrder());
            for(int i=0;i< answer.length;i++) {
                answer[i]=sums.get(i);
            }
        }
//        System.out.println(sums);

        return answer;
    }
    public int checkArr(int[][] mapArray,int i,int j) {
        int sum=0;
        if(i>0) {
            if (mapArray[i - 1][j] != 0) {
                sum += mapArray[i - 1][j];
                mapArray[i - 1][j] = 0;
                sum += checkArr(mapArray, i - 1, j);
            }
        }
        if(j<mapArray[0].length-1) {
            if (mapArray[i][j + 1] !=0) {
                sum += mapArray[i][j + 1];
                mapArray[i][j + 1] = 0;
                sum += checkArr(mapArray, i, j+1);
            }
        }
        if(i<mapArray.length-1) {
            if (mapArray[i+1][j] != 0) {
                sum += mapArray[i + 1][j];
                mapArray[i + 1][j] = 0;
                sum += checkArr(mapArray, i+1, j);
            }
        }
        if(j>0) {
            if (mapArray[i][j - 1] != 0) {
                sum += mapArray[i][j - 1];
                mapArray[i][j - 1] = 0;
                sum += checkArr(mapArray, i, j - 1);
            }
        }
        return sum;
    }
}

//["X591X",
// "X1X5X",
// "X231X",
// "1XXX1"]
