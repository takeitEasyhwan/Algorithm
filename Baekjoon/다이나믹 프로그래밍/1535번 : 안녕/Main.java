package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][2];//
		int K[][] = new int [n+1][100];
		for(int i=0;i<2;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				arr[j][i]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<100;i++)
			K[0][i]=0;
		for(int i=0;i<=n;i++)
			K[n][0]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<100;j++) {
				if(arr[i-1][0]>j)
					K[i][j]=K[i-1][j];
				else {
					if(K[i-1][j]>K[i-1][j-arr[i-1][0]]+arr[i-1][1])
						K[i][j]=K[i-1][j];
					else
						K[i][j]=K[i-1][j-arr[i-1][0]]+arr[i-1][1];
				}
			}
		}
		System.out.println(K[n][99]);
		
	}

}
