package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String n=br.readLine();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n.length();i++) {
			list.add(Character.getNumericValue(n.charAt(i)));
		}
		Collections.sort(list , Collections.reverseOrder());
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb);
	}

}
