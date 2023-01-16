package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[D+2];
		arr[1]=1;
		arr[2]=0;
		for(int i=3;i<=D+1;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		int x=arr[D];
		int y=arr[D+1];
		for(int i=0;i<K;i++) {
			for(int j=1; j<=i; j++){
                if(j*x + i*y == K){
                    System.out.println(j+"\n"+i);
                    return;
                }
            }
		}
		
	}

}
