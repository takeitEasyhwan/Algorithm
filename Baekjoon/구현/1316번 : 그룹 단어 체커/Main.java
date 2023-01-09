package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int['z'-'a'+1];
		int cnt=0;
		for(int j=0;j<n;j++) {
			String word = br.readLine();
			for(int i=0;i<arr.length;i++)
				arr[i]=0;
			for(int i=0;i<word.length();i++) {
				if(arr[word.charAt(i)-'a']==0)
					arr[word.charAt(i)-'a']++;
				else {
					if(word.charAt(i-1)!=word.charAt(i)) {
						cnt++;
						break;
					}
						
				}
			}
			
		}
		System.out.println(n-cnt);
	}

}
