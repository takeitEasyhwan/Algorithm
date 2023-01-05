package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return x + " " + y+"\n";
	}
	
}
class CoordinateSort implements  Comparator<Coordinate>{
	@Override
	public int compare(Coordinate o1, Coordinate o2) {
		if(o1.y>o2.y)
			return 1;
		else if(o1.y<o2.y)
			return -1;
		else {
			if(o1.x>o2.x)
				return 1;
			else
				return -1;
		}
	}
}
public class Main_11651 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<Coordinate> list = new ArrayList<>();
		StringTokenizer st;
		while(n-->0) {
			st= new StringTokenizer(br.readLine()," ");
			list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new CoordinateSort());
		Iterator<Coordinate> iter = list.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb);
	}
	
}
