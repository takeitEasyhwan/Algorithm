package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		label:while(true) {
			String line = br.readLine();
			if(line.equals("."))
				break;
			stack.clear();
			for(int i=0;i<line.length();i++) {
				if(line.charAt(i)=='('||line.charAt(i)=='[') {
					stack.push(line.charAt(i));
				}
				else if(line.charAt(i)==')') {
					if(stack.isEmpty()) {
						sb.append("no").append("\n");
						continue label;
					}
					else if(stack.pop()!='('){
						sb.append("no").append("\n");
						continue label;
					}
				}
				else if(line.charAt(i)==']') {
					if(stack.isEmpty()) {
						sb.append("no").append("\n");
						continue label;
					}
					else if(stack.pop()!='['){
						sb.append("no").append("\n");
						continue label;
					}
				}
			}
			if(stack.isEmpty())
				sb.append("yes").append("\n");
			else 
				sb.append("no").append("\n");
		}
		System.out.println(sb);
	}
}
