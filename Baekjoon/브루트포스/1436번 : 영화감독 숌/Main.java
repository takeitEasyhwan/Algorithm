package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		int i=0;
		for(i=666;i<Integer.MAX_VALUE;i++) {
			if(Integer.toString(i).contains("666"))
				cnt++;
			if(cnt==N)
				break;
		}
		System.out.println(i);
	}
}
