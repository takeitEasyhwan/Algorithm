package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<3;j++) {
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<3;j++) {
				long min=Integer.MAX_VALUE;
				for(int k=0;k<3;k++) {
					if(j!=k&&min>dp[i-1][k])
						min=dp[i-1][k];
				}
				dp[i][j]+=min;
			}
		}
		long min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			if(min>dp[N-1][i])
				min=dp[N-1][i];
			
		}
		System.out.println(min);

	}

}
