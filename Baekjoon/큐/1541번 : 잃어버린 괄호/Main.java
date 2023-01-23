package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Queue<String> queue = new LinkedList<>();
		int check=0;
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)=='-'||line.charAt(i)=='+') {
				queue.add(line.substring(check, i));
				check=i+1;
				queue.add(Character.toString(line.charAt(i)));
			}
			else if(i==line.length()-1) {
				queue.add(line.substring(check, i+1));
			}
		}
		int n=queue.size();
		String temp = "";
		queue.add("first");
		while(true) {
			
			if(queue.element().equals("-")) {
				queue.add(temp);
				queue.add(queue.poll());
			}
			else if(queue.element().equals("+")) {
				queue.poll();
				int tempNum= Integer.parseInt(temp)+Integer.parseInt(queue.poll());
				temp=Integer.toString(tempNum);
			}
			else if(queue.element().equals("first")) {
				queue.add(temp);
				queue.poll();
				break;
			}
			else
				temp=queue.poll();
		}
		int sum=Integer.parseInt(queue.poll());
		Iterator<String> iter = queue.iterator();
		
		while(iter.hasNext()) {
			temp=iter.next();
			if(!temp.equals("-"))
				sum-=Integer.parseInt(temp);
		}
		System.out.println(sum);
	}
}
