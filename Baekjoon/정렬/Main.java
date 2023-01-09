package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class NumSet{
	int num;
	int originOrder;
	boolean check;
	public NumSet(int num, int originOrder) {
		this.num = num;
		this.originOrder = originOrder;
	}
	@Override
	public String toString() {
		return "NumSet [num=" + num + ", originOrder=" + originOrder + ", check=" + check + "]";
	}
	
}
class NumSetSort1 implements Comparator<NumSet>{

	@Override
	public int compare(NumSet o1, NumSet o2) {
		// TODO Auto-generated method stub
		if(o1.num>o2.num)
			return 1;
		else 
			return -1;
	}
	
}
class NumSetSort2 implements Comparator<NumSet>{

	@Override
	public int compare(NumSet o1, NumSet o2) {
		// TODO Auto-generated method stub
		if(o1.originOrder>o2.originOrder)
			return 1;
		else
			return -1;
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			arr1[i] =Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		NumSet arr2[] = new NumSet[M];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) {
			arr2[i] = new NumSet(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2,new NumSetSort1());
		
		int k=0;
		for(int i=0;i<M;i++) {
			for(int j=k;j<N;j++) {
				if(arr2[i].num==arr1[j]) {
					k=j;
					arr2[i].check=true;
					break;
				}
			}
		}
		
		
		Arrays.sort(arr2, new NumSetSort2());
		for(int i=0;i<M;i++) {
			if(arr2[i].check==true)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}
}
