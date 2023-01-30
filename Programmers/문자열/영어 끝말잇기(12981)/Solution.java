import java.util.HashMap;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<Integer, String> hMap = new HashMap<Integer, String>();
        int i=0;
        for(i=0;i<words.length;i++) {
        	
        	if(hMap.containsValue(words[i])) {
        		answer[0]=i%n+1;
        		answer[1]=i/n+1;
        		return answer;
        	}
        	else if(!hMap.isEmpty()) {
        		if(hMap.get(i-1).charAt(hMap.get(i-1).length()-1)!=words[i].charAt(0)) {
        			answer[0]=i%n+1;
            		answer[1]=i/n+1;
            		return answer;
        		}
        			
        	}
        	hMap.put(i, words[i]);
        		
        }
        answer[0]=0;
        answer[1]=0;
        return answer;
    }
}
