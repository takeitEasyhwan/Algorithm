import java.util.StringTokenizer;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
    	boolean[] result=new boolean[privacies.length];
    	
    	int[] todayArr = new int[today.length()];
    	StringTokenizer st = new StringTokenizer(today,".");
    	for(int i=0;i<3;i++) {
    		todayArr[i]=Integer.parseInt(st.nextToken());
    	}
    	
    	String[][] termsArr = new String[terms.length][2];
    	for(int i=0;i<terms.length;i++) {
    		st = new StringTokenizer(terms[i]," ");
    		termsArr[i][0]=st.nextToken();
    		termsArr[i][1]=st.nextToken();
    	}
    	
    	int[][] privaciesArr = new int[privacies.length][3];
    	for(int i=0;i<privacies.length;i++) {
    		st = new StringTokenizer(privacies[i]," ");
    		StringTokenizer st1 = new StringTokenizer(st.nextToken(),".");
    		String month=st.nextToken();
    		privaciesArr[i][0]=Integer.parseInt(st1.nextToken());
    		privaciesArr[i][1]=Integer.parseInt(st1.nextToken());
    		for(int j=0;j<termsArr.length;j++) {
    			if(month.equals(termsArr[j][0])) {
    				privaciesArr[i][1]+=Integer.parseInt(termsArr[j][1]);
    				if(privaciesArr[i][1]>12) {
    					privaciesArr[i][0]+=privaciesArr[i][1]/12;
    					privaciesArr[i][1]=privaciesArr[i][1]%12;
    					if(privaciesArr[i][1]==0) {
    						privaciesArr[i][1]=12;
    						privaciesArr[i][0]--;
    					}
    				}
    				break;
    			}
    		}
    		privaciesArr[i][2]=Integer.parseInt(st1.nextToken());
    	}
    	System.out.println(todayArr[0]+" "+todayArr[1]+" "+todayArr[2]+"\n");
    	for(int i=0;i<privacies.length;i++) {
    		System.out.println(privaciesArr[i][0]+" "+privaciesArr[i][1]+" "+privaciesArr[i][2]);
    	}
    	int cnt=0;
    	for(int i=0;i<privaciesArr.length;i++) {
    		if(todayArr[0]>privaciesArr[i][0]) {
    			cnt++;
    			result[i]=true;
    		}
    		else if(todayArr[0]==privaciesArr[i][0]&&todayArr[1]>privaciesArr[i][1]) {
    			cnt++;
    			result[i]=true;
    		}
    		else if(todayArr[0]==privaciesArr[i][0]&&todayArr[1]==privaciesArr[i][1]&&todayArr[2]>=privaciesArr[i][2]) {
    			cnt++;
    			result[i]=true;
    		}
    	}
    	
        int[] answer = new int[cnt];
        cnt=0;
        for(int i=0;i<result.length;i++) {
        	if(result[i]==true)
        		answer[cnt++]=i+1;
        }
        return answer;
    }
}
