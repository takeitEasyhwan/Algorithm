import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public Integer[] solution(int[] numlist, int n) {
    	Integer answer[] = new Integer[numlist.length];
    	for(int i=0;i<numlist.length;i++)
    		answer[i]=numlist[i];
    	
    	Arrays.sort(answer, new nearSort(n));
    	return answer;
    }
    class nearSort implements Comparator<Integer>{
    	int n;

		public nearSort(int n) {
			this.n = n;
		}

		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1-n)>Math.abs(o2-n))
				return 1;
			else if(Math.abs(o1-n)<Math.abs(o2-n))
				return -1;
			else {
				if (o1<o2)
					return 1;
				else
					return -1;
			}
				
		}
    	
    }

}
