import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(arr[0]);
    	for(int i=0;i<arr.length;i++) {
    		if(stack.peek()!=arr[i])
    			stack.push(arr[i]);
    	}
        int[] answer = new int[stack.size()];
        for(int i=0;i<answer.length;i++)
        	answer[answer.length-1-i]=stack.pop();
        return answer;
    }
}
