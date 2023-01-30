import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] babbling) {
    	int answer=0;
    	Queue<Character> queue = new LinkedList<Character>();
    	for(int i=0;i<babbling.length;i++) {
    		for(int j=0;j<babbling[i].length();j++)
    			queue.add(babbling[i].charAt(j));
    		String temp="";
    		while(!queue.isEmpty()) {
    			temp+=queue.poll();
    			if(temp.equals("aya")||temp.equals("ye")||temp.equals("woo")||temp.equals("ma")) {
    				temp="";
    			}
    			
    		}
    		if(temp.equals(""))
    			answer++;
    	}
    	return answer;
    }
    
}
