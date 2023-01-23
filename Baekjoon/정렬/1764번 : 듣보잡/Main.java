package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] arrN;
	static String[] arrM;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arrN = new String[N];
		arrM = new String[M];
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		for(int i=0;i<N;i++) {
			arrN[i] = br.readLine();
		}
		for(int i=0;i<M;i++) {
			arrM[i] = br.readLine();
		}
		Arrays.sort(arrN);
		Arrays.sort(arrM);
		int checkStart=0;
		for(int i=0;i<M;i++) {
			int check =binarySearch(arrM[i],checkStart,N-1);
			if(check!=-1) {
				sb.append(arrM[i]).append("\n");
				cnt++;
			}
			else
				checkStart=check;
			
		}
		System.out.println(cnt);
		System.out.println(sb);		
	}
	static int binarySearch(String key, int low, int high) {
		int mid;

		if(low <= high) {
			mid = (low + high) / 2;

			if(key.equals(arrN[mid])) {
				return mid;
			} else if(key.compareTo(arrN[mid])<0) { 
				return binarySearch(key ,low, mid-1);  
			} else {
				return binarySearch(key, mid+1, high); 
			}
		}

		return -1;
	}
}
