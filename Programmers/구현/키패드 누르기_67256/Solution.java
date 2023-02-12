class Solution {
    public String solution(int[] numbers, String hand) {
    	String answer = "";
    	int lPosition=3;
    	int rPosition=3;
    	boolean lCenterCheck=false;
    	boolean rCenterCheck=false;
    	for(int i=0;i<numbers.length;i++) {
    		if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
    			answer+="L";
    			lPosition=numbers[i]/3;
    			lCenterCheck=false;
    		}
    		else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
    			answer+="R";
    			rPosition=numbers[i]/3-1;
    			rCenterCheck=false;
    		}
    		else {
    			int currentNum;
    			if(numbers[i]==0)
    				currentNum = 3;
    			else
    				currentNum = numbers[i]/3;
    			
    			int lDistance=Math.abs(currentNum-lPosition);
    			int rDistance=Math.abs(currentNum-rPosition);
    			if(lCenterCheck==false)
    				lDistance++;
    			if(rCenterCheck==false)
    				rDistance++;
    			if((lDistance>rDistance)||(lDistance==rDistance&&hand.equals("right"))) {
    				rPosition=currentNum;
    				rCenterCheck=true;
    				answer+="R";
    			}
    			else {
    				lPosition=currentNum;
    				lCenterCheck=true;
    				answer+="L";
    			}
    				
    		}
    	}
        return answer;
    }
}
