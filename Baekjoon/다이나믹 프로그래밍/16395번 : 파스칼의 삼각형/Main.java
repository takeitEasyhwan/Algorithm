package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[][] = new int [n+1][n+1];
		arr[1][1]=1;
		for(int i=2;i<=n;i++) {
			arr[i][1]=1;
			arr[i][i]=1;
			for(int j=2;j<i;j++) {
				arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
		}
		System.out.println(arr[n][k]);
	}

}
