package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long dp[][] = new long[66][11];
		for(int i=1;i<=10;i++) {
			dp[1][i]=11-i;
		}
		for(int i=2;i<=65;i++) {
			for(int j=1;j<=10;j++) {
				for(int k=j;k<=10;k++) {
					dp[i][j]+=dp[i-1][k];
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			sb.append(dp[Integer.parseInt(br.readLine())][1]).append("\n");
		}
		System.out.println(sb);

	}

}
