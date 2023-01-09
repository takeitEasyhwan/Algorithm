package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int mult=2;
		int min=10001;
		int sum=0;
		boolean flag = false;
		boolean arr[]=new boolean[10001];
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
				if(flag==false) {
					flag=true;
					min=i;
				}
				sum+=i;
			}
		}
		if(flag==false)
			System.out.println("-1");
		else {
			System.out.println(sum);
			System.out.println(min);
		}
			
	}

}
