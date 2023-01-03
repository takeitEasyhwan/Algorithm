package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_10757 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String n = st.nextToken();
		String m = st.nextToken();
		BigInteger bigNumber1 = new BigInteger(n);
		BigInteger bigNumber2 = new BigInteger(m);
		System.out.println(bigNumber1.add(bigNumber2));
	}

}
