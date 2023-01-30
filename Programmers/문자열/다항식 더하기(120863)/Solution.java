import java.util.StringTokenizer;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int termX =0;
        int monomial = 0;
        StringTokenizer st = new StringTokenizer(polynomial," ");
        while(st.hasMoreTokens()) {
        	String s = st.nextToken();
        	
        	if(!s.equals("+")) {
        		if(s.contains("x")&&s.equals("x")) {
            		termX++;
            	}
        		else if(s.contains("x")&&!s.equals("x")) {
        			termX+=Integer.parseInt(s.replaceAll("x", ""));
        		}
        		else
            		monomial+=Integer.parseInt(s);
        	}
	
        }
        if (termX!=0&&monomial!=0) {
        	if(termX==1)
        		answer="x + "+Integer.toString(monomial);
        	else
        		answer=Integer.toString(termX)+"x + "+Integer.toString(monomial);
        }
        else if (termX==0) {
        	answer=Integer.toString(monomial);
        }
        else {
        	if(termX==1)
        		answer="x";
        	else
        		answer=Integer.toString(termX)+"x";
        }
        	
        	
        return answer;
    }
}
