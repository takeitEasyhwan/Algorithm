import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int rankArr[] = new int[k+1];
        int min;
        for(int i=0;i<Math.min(k,score.length);i++) {
        	min=2001;
        	for(int j=0;j<=i;j++) {
        		if(score[j]<min)
        			min = score[j];
        	}
        	answer[i]=min;
        	rankArr[i+1]=score[i];
        }
        Arrays.sort(rankArr);
        for(int i=k;i<score.length;i++) {	
        	if(score[i]>=rankArr[1]) {
        		rankArr[0]=score[i];
        		Arrays.sort(rankArr);
        	}
        	answer[i]=rankArr[1];
        }
        
        return answer;
    }
}
