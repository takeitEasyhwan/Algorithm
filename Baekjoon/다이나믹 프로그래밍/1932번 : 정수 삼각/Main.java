package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long arr[][] = new long[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0)
					arr[i][0]+=arr[i-1][0];
				else if(j==i)
					arr[i][j]+=arr[i-1][j-1];
				else {
					if(arr[i-1][j-1]>arr[i-1][j])
						arr[i][j]+=arr[i-1][j-1];
					else
						arr[i][j]+=arr[i-1][j];
					
				}
			}
		}
		long max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[n-1][i]>max)
				max=arr[n-1][i];
			
		}
		System.out.println(max);
	}

}
