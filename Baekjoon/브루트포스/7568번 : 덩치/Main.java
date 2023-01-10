package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Body{
	int weight;
	int height;
	int rank;
	public Body(int weight, int height) {
		this.weight = weight;
		this.height = height;
		rank=1;
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Body arr[] = new Body[N];
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			arr[i] = new Body(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				if(arr[i].weight>arr[j].weight&&arr[i].height>arr[j].height)
					arr[j].rank++;
				else if(arr[i].weight<arr[j].weight&&arr[i].height<arr[j].height)
					arr[i].rank++;
			}
		}
		for(int i=0;i<N;i++) {
			sb.append(arr[i].rank).append(" ");
		}
		System.out.println(sb);
	}		
}
