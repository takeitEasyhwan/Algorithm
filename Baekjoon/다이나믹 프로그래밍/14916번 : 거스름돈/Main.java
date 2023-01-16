package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[100001];
		arr[1] = -1;
		arr[2] = 1;
		arr[3] = -1;
		arr[4] = 2;
		arr[5] = 1;
		
		for(int i=6;i<=n;i++) {
			if(arr[i-5]==-1&&arr[i-2]==-1)
				arr[i]=-1;
			else if(arr[i-5]==-1)
				arr[i]=arr[i-2]+1;
			else if(arr[i-2]==-1)
				arr[i]=arr[i-5]+1;
			else if(arr[i-5]<arr[i-2]) 
				arr[i]=arr[i-5]+1;
			else
				arr[i]=arr[i-2]+1;
		}
		System.out.println(arr[n]);
	}

}
