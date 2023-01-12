package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int arr[]= new int [K+2];
		arr[0]=1;
		for(int i=1;i<=K+1;i++) {
			if(i==1)arr[1]=0;
			else arr[i]=arr[i-1]+arr[i-2];
		}
		System.out.println(arr[K]+" "+arr[K+1]);
	}

}
