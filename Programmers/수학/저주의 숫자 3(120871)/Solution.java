package baekjoon;

class Solution {
	public int solution(int n) {
		int cnt=0;
		int num=0;
		label : while(cnt!=n) {
			num++;
			if(num%3==0) {
				continue;
			}
				
			for(int i=0;i<Integer.toString(num).length();i++) {
				if(Integer.toString(num).charAt(i)=='3') {
					continue label;
				}
					
			}
			
			cnt++;
			System.out.println(num+ " 일때 "+cnt);
		}
		return num;
        
    }
}
