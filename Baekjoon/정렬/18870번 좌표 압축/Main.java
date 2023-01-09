package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] originArr = new int[n];
		int[] sortArr= new int[n];
		HashMap<Integer, Integer> rankMap = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			sortArr[i] = originArr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sortArr);
		int rank=0;
		for(int v : sortArr) {
			if(!rankMap.containsKey(v)) {
				rankMap.put(v, rank);
				rank++;
			}
		}
		for(int key : originArr) {
			int ranking = rankMap.get(key);	
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
		
		
	}

}
