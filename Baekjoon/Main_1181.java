package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class wordSorting implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.length()>o2.length())
			return 1;
		else if(o1.length()<o2.length())
			return -1;
		else {
			if(o1.compareTo(o2)>=1)
				return 1;
			else
				return -1;
		}
	}
	
}
public class Main_1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		while(n-->0) {
			list.add(br.readLine());
		}
		Collections.sort(list, new wordSorting());
		String lastWord="";
		for(int i=0;i<list.size();i++) {
			if(i==0) {
				sb.append(list.get(i)).append("\n");
				lastWord=list.get(i);
			}
			else {
				if(!lastWord.equals(list.get(i))) {
					sb.append(list.get(i)).append("\n");
					lastWord=list.get(i);
				}
			}
		}
		System.out.println(sb);
	}

}
