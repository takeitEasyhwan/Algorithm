package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long arr[] = new long[100];
		arr[0]=1;
		arr[1]=1;
		arr[2]=1;
		arr[3]=2;
		arr[4]=2;
		for(int i=5;i<100;i++) {
			arr[i]=arr[i-1]+arr[i-5];
		}
		while(T-->0) {
			int N =  Integer.parseInt(br.readLine());
			sb.append(arr[N-1]).append("\n");
		}
		System.out.println(sb);
	}


}
