package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int mult=2;

		boolean arr[]=new boolean[1000001];
		arr[1]=true;
		for(int i=2;i<n;i++) {
			if(arr[i]==false) {
				mult=2;
				while(true) {
					if(i*mult<=n) {
						arr[i*mult]=true;
						mult++;
					}
					else
						break;
				}
			}
		}
		for(int i=m;i<=n;i++) {
			if(arr[i]==false) {
				
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}
