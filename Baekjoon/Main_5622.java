package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5622 {
//5622
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int time=0;
		for(int i=0;i<line.length();i++)
			time+=time(line.charAt(i));
		System.out.println(time);
	}
	public static int time(char c) {
		if('A'<=c&&c<='O')return (c-'A')/3+3;
		else if('P'<=c&&c<='S')return 8;
		else if('T'<=c&&c<='V')return 9;
		else return 10;
	}

}
