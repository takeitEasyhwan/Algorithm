import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<StagePercent> stagePercent = new ArrayList<>();
        int stageCnt[] = new int[N];
        for(int i=0;i<stages.length;i++) {
        	if(stages[i]!=N+1)
        		stageCnt[stages[i]-1]++;
        }
        for(int i=0;i<N;i++) {
        	stagePercent.add(new StagePercent(i+1, stageCnt[i]));
        }
        double sum=stages.length;
        for(int i=0;i<stagePercent.size();i++) {
        	double newSum = sum-stagePercent.get(i).percent;
        	if(sum<=0)
        		stagePercent.get(i).percent=0;
        	else
        		stagePercent.get(i).percent/=sum;
        	sum=newSum;
        }
        Collections.sort(stagePercent,new StageSort());
        for(int i=0;i<N;i++) {
        	answer[i]=stagePercent.get(i).index;
        	System.out.println(stagePercent.get(i).percent);
        }
        return answer;
    }
}
class StageSort implements Comparator<StagePercent>{

	@Override
	public int compare(StagePercent o1, StagePercent o2) {
		if(o1.percent==o2.percent) {
			if(o1.index>o2.index)
				return 1;
			else
				return -1;
		}
		else {
			if(o1.percent>o2.percent)
				return -1;
			else 
				return 1;
		}
	}
	
}

class StagePercent{
	int index;
	double percent;
	public StagePercent(int index, double percent) {
		this.index = index;
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "StagePercent [index=" + index + ", percent=" + percent + "]";
	}
	
}
