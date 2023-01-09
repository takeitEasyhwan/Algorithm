package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {
	//2941
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int cnt=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)=='-') {
				cnt++;
			}
			else if(word.charAt(i)=='=') {
				if(word.charAt(i-1)=='z') {
					if(i<=1) {
						cnt++;
					}
					else {
						if(word.charAt(i-2)=='d')
							cnt+=2;
						else
							cnt++;
					}
				}
				else
					cnt++;
			}
			else if(word.charAt(i)=='j') {
				if(i!=0) {
					if(word.charAt(i-1)=='l'||word.charAt(i-1)=='n')
						cnt++;
				}	
			}
					
		}
		System.out.println(word.length()-cnt);
	}

}
