import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        int check=0;
        int temp=0;
        for(int i=0;i<s.length();i++) {
        	temp++;
        	if(s.charAt(i)==' ') {
        		answer+=' ';
        		check+=temp;
        	}
        	else if((i-check)%2==0) {
        		answer+=s.toUpperCase().charAt(i);
        	}
        	else {
        		answer+=s.toLowerCase().charAt(i);
        	}
        		
        		
        	
        }
        
   
        return answer.substring(0, answer.length());
    }
}
