package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word=br.readLine().toUpperCase();
		boolean check = false;
		int max=Integer.MIN_VALUE;
		char maxAlpha = 0;
		int alphaArr[] = new int['Z'-'A'+1];
		for(int i=0;i<word.length();i++) {
			alphaArr[word.charAt(i)-'A']++;
		}
		for(int i=0;i<'Z'-'A'+1;i++) {
			if(max<alphaArr[i]) {
				max=alphaArr[i];
				maxAlpha=(char) (i+'A');
				check=false;
			}
			else if(max==alphaArr[i])
				check=true;
		}
		if(check==true)
			System.out.println("?");
		else
			System.out.println(maxAlpha);
		
	}

}
