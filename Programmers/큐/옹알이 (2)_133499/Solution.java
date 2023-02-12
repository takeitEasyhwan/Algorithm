import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] babbling) {
    	int answer=0;
    	Queue<Character> queue = new LinkedList<Character>();
    	String[][] arr= new String[4][2];
    	
    	for(int i=0;i<babbling.length;i++) {
    		arr[0][0]="aya";
        	arr[1][0]="ye";
        	arr[2][0]="woo";
        	arr[3][0]="ma";
        	arr[0][1]="1";
        	arr[1][1]="1";
        	arr[2][1]="1";
        	arr[3][1]="1";
    		for(int j=0;j<babbling[i].length();j++)
    			queue.add(babbling[i].charAt(j));
    		String temp="";
    		while(!queue.isEmpty()) {
    			temp+=queue.poll();
    			for(int k=0;k<4;k++) {
    				if(arr[k][1].equals("1")&&arr[k][0].equals(temp)) {
    					temp="";
    					for(int l=0;l<4;l++) {
    						arr[l][1]="1";
    					}
    					arr[k][1]="0";
    					
    				}
    			}
    		}
    		if(temp.equals(""))
    			answer++;
    	}
    	return answer;
    }
    
}
