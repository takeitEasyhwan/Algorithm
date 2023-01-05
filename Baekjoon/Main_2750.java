package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class Main_2750 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while(n-->0) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}
		System.out.println(sb);
	}

}
