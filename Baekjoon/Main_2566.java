package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2566 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = Integer.MIN_VALUE;
		int maxRow=0,maxCol=0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(max<num) {
					max=num;
					maxRow =i+1;
					maxCol =j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(maxRow+" "+maxCol);
	}

}
