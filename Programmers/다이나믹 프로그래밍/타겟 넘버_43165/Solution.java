class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int arr[][] = new int[numbers.length][(int) Math.pow(2, numbers.length)];
        arr[0][0]=numbers[0]*-1;
        arr[0][1]=numbers[0];
        for(int i=1;i<numbers.length;i++) {
        	for(int j=0;j<Math.pow(2, i+1);j++) {
        		if(j%2==0) {
        			arr[i][j]=arr[i-1][j/2]-numbers[i];
        		}
        		else {
        			arr[i][j]=arr[i-1][j/2]+numbers[i];
        		}
        	}
        }
        for(int i=0;i<Math.pow(2, numbers.length);i++) {
        	if(arr[numbers.length-1][i]==target)
        		answer++;
        }
        return answer;
    }
}
