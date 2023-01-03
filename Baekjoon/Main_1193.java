package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum=0;
		int cnt=0;
		while(true) {
			cnt++;
			sum+=cnt;
			if(sum>=n)break;
		}
		for(int i=1;i<=cnt;i++) {
			if(i==n-(sum-cnt)) {
				if((cnt+1)%2!=0)
					System.out.println(i + "/" +(cnt-i+1));
				else
					System.out.println((cnt-i+1) + "/" + i);
			}
		}
	}

}
