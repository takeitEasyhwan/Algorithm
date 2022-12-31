package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_1152 {
//1152
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		boolean check=false;
		String line = br.readLine();
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)==' ') {
				if(check==false) {
					cnt++;
					check=true;
				}
				if(i==0||i==line.length()-1) {
					cnt--;
					check=true;
				}
			}
			else
				check=false;
		}
		if(line.equals(" "))
			cnt=-1;
		System.out.println(cnt+1);
	}

}
