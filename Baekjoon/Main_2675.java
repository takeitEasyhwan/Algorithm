package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2675
public class Main_2675 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int l=Integer.parseInt(st.nextToken());
			String word = st.nextToken();
			for(int i=0;i<word.length();i++) {
				for(int j=0;j<l;j++) {
					sb.append(word.charAt(i));
				}
				
				
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
