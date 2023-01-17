package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		long arr[] = new long[31];
		long sum=0;
		arr[0]=1;
		arr[1]=1;
		arr[2]=2;
		for(int i=3;i<=30;i++) {
			sum=0;
			for(int j=0;j<i;j++) {
				sum+=arr[j]*arr[i-1-j];
			}
			arr[i]=sum;
		}
		
		for(int i=0;i<1000;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			sb.append(arr[n]).append("\n");
			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();//128ms
	}

}
