package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		int mult=2;
		boolean arr[]=new boolean[246913];
		arr[1]=true;
		for(int i=2;i<=246912;i++) {
			if(arr[i]==false) {
				mult=2;
				while(true) {
					if(i*mult<=246912) {
						arr[i*mult]=true;
						mult++;
					}
					else
						break;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int cnt=0;
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			for(int i=n+1;i<2*n;i++) {
				if(arr[i]==false) {
					
					cnt++;
				}
			}
			if(n==1)
				cnt++;
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

}
