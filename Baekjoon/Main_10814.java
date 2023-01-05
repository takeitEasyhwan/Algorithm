package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Member> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(n-->0) {
			st= new StringTokenizer(br.readLine()," ");
			list.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(list, new SortMember());
		Iterator<Member> iter = list.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb);
	}

}
class SortMember implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		if(o1.age>o2.age)
			return 1;
		else if(o1.age<o2.age)
			return -1;
		else {
			if(o1.join>o2.join)
				return 1;
			else
				return -1;
		}
	}
	
}
class Member{
	int age;
	String name;
	int join;
	private static int count=0;
	public Member(int age, String name) {
		this.age = age;
		this.name = name;
		this.join=++count;
	}
	@Override
	public String toString() {
		return age+" "+name+"\n";
	}
}