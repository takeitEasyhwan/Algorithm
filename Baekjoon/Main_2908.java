package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908 {
//2908
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		String num1=st.nextToken();
		String num2=st.nextToken();
		String newNum1 = "",newNum2 = "";
		for(int i=0;i<3;i++) {
			newNum1+=num1.charAt(2-i);
			newNum2+=num2.charAt(2-i);
		}
		if(Integer.parseInt(newNum1)>Integer.parseInt(newNum2))
			System.out.println(newNum1);
		else
			System.out.println(newNum2);
	}

}
