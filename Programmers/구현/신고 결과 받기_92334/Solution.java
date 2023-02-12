import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        boolean[][] reportTable = new boolean[id_list.length][id_list.length];
        boolean[] reportResult = new boolean[id_list.length];
        for(int i=0;i<report.length;i++) {
        	StringTokenizer st = new StringTokenizer(report[i]," ");
        	String reporter=st.nextToken();
        	String reported=st.nextToken();
        	int reporterIndex=0;
        	int reportedIndex=0;
        	for(int j=0;j<id_list.length;j++) {
        		if(reporter.equals(id_list[j])) {
        			reporterIndex=j;
        			break;
        		}
        	}
        	for(int j=0;j<id_list.length;j++) {
        		if(reported.equals(id_list[j])) {
        			reportedIndex=j;
        			break;
        		}
        	}
        	reportTable[reporterIndex][reportedIndex]=true;
        }
        for(int i=0;i<id_list.length;i++) {
        	int sum=0;
        	for(int j=0;j<id_list.length;j++) {
        		if(reportTable[j][i]==true)
        			sum++;
        	}
        	if(sum>=k)
        		reportResult[i]=true;
        	else
        		reportResult[i]=false;
        }
        for(int i=0;i<id_list.length;i++) {
        	int sum=0;
        	for(int j=0;j<id_list.length;j++) {
        		if(reportResult[j]==true&&reportTable[i][j]==true)
        			sum++;
        	}
        	answer[i]=sum;
        }
        return answer;
    }
}
