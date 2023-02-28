import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String s) {
    	List<List> list = new LinkedList<>();
    	StringTokenizer st = new StringTokenizer(s,"}{");
    	int i=0;
    	
    	while(st.hasMoreTokens()) {
    		if(i%2==0) {
    			List<String> list1 = new LinkedList<>();
    			StringTokenizer st1 = new StringTokenizer(st.nextToken(),",");
    			while(st1.hasMoreTokens()) {
    				String temp = st1.nextToken();
    				if(!temp.equals(",")) {
    					list1.add(temp);
    				}
    			}
    			if(!list1.isEmpty())
    				list.add(list1);
    		}
    		else {
    			st.nextToken();
    		}
    		
    	}
    	list.sort(new Comparator<List>() {

			@Override
			public int compare(List o1, List o2) {
				// TODO Auto-generated method stub
				return o1.size()-o2.size();
			}
		});
    	int[] answer = new int[list.size()];
    	answer[0]=Integer.parseInt((String) list.get(0).get(0));
    	for(i=1;i<list.size();i++) {
    		for(int j=0;j<list.get(i).size();j++) {
    			if(!list.get(i-1).contains(list.get(i).get(j))) {
    				answer[i]=Integer.parseInt ((String) list.get(i).get(j));
    				break;
    			}
    		}
    	}

        
        return answer;
    }
}
