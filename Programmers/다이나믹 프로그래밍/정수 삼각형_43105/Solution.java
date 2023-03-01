class Solution {
    public int solution(int[][] triangle) {
        int answer = -1;
        for(int i=1;i<triangle.length;i++) {
        	triangle[i][0]+=triangle[i-1][0];
        	triangle[i][i]+=triangle[i-1][i-1];
        	for(int j=1;j<i;j++) {
        		triangle[i][j]+=Integer.max(triangle[i-1][j-1], triangle[i-1][j]);
        	}
        }
        for(int i=0;i<triangle.length;i++) {
        	if(answer<triangle[triangle.length-1][i])
        		answer=triangle[triangle.length-1][i];
        }
        return answer;
    }
}
