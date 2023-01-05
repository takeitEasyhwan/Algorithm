package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			int num=Integer.parseInt(br.readLine());
			for(int i=num/2;i<num;i++) {
				if(arr[i]==false) {
					if(arr[num-i]==false) {
						sb.append(num-i).append(" ").append(i).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}

}
