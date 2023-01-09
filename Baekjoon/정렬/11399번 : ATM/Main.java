package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer arr[] = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int sum=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				sum+=arr[j];
			}
		}
		System.out.println(sum);
	}

}
