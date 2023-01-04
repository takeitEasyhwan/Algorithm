package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2775 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int arr[][] = new int[15][15];
		for(int i=0;i<15;i++) {
			arr[i][0]=0;
			arr[0][i]=i;
		}
		for(int i=1;i<15;i++) {
			for(int j=1;j<15;j++) {
				arr[i][j]=arr[i][j-1]+arr[i-1][j];
			}
		}
		while(t-->0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(arr[k][n]).append("\n");
		}
		System.out.println(sb);
	}

}
