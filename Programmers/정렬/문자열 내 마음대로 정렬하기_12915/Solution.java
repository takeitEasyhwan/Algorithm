import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new numSort(n));
        return strings;
    }
    class numSort implements Comparator<String>{
    	int n;
		public numSort(int n) {
			this.n = n;
		}
		@Override
		public int compare(String o1, String o2) {
			if(o1.charAt(n)>o2.charAt(n))
				return 1;
			else if(o1.charAt(n)<o2.charAt(n))
				return -1;
			else {
				if(o1.compareTo(o2)>0)
					return 1;
				else 
					return -1;
			}
		}
    	
    }
}
