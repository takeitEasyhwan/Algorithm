package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_25305 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		Integer arr[] = new Integer[n];
		while(n-->0) {
			arr[n]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,Collections.reverseOrder());
		System.out.println(arr[k-1]);
	}

}
