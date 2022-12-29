package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String word = br.readLine();
		int arr[] = new int['z'-'a'+1];
		for(int i=0;i<arr.length ;i++) {
			arr[i]=-1;
		}
		
		for(int i=0;i<word.length();i++) {
			if(arr[word.charAt(i)-'a']==-1)
				arr[word.charAt(i)-'a']=i;
		}
		for(int i=0;i<arr.length ;i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

}
