import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
    	Stack<Integer> stack = new Stack<>();
    	int answer = 0;
    	String temp = "";
    	for(int i=0;i<dartResult.length();i++) {
    		if('0'>dartResult.charAt(i)||dartResult.charAt(i)>'9') {
    			if(dartResult.charAt(i)=='S') 
    				stack.push(Integer.parseInt(temp));
    			else if(dartResult.charAt(i)=='D') 
    				stack.push((int) Math.pow(Integer.parseInt(temp),2));
    			else if(dartResult.charAt(i)=='T') 
    				stack.push((int) Math.pow(Integer.parseInt(temp),3));
    			else if(dartResult.charAt(i)=='#') 
    				stack.push(stack.pop()*-1);
    			else if(dartResult.charAt(i)=='*') {
    				int tempNum = stack.pop();
    				if(stack.isEmpty()) {
    					stack.push(tempNum*2);
    				}
    				else {
    					stack.push(stack.pop()*2);
    					stack.push(tempNum*2);
    				}
    			}
    			temp="";
    			
    		}
    		else
				temp+=dartResult.charAt(i);
    		
    	}
        while(!stack.isEmpty()) {
        	answer+=stack.pop();
        }
        return answer;
    }
}
