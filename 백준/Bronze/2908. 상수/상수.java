import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		char[] arrA = new char[3];
		char[] arrB = new char[3];
		for (int i = 0; i < 3; i++) {
			arrA[2-i] = A.charAt(i);
			arrB[2-i] = B.charAt(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(arrA[i]);
		}
		int x = Integer.parseInt(sb.toString());
		
		sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(arrB[i]);
		}
		int y = Integer.parseInt(sb.toString());
		
		if (x > y) {
			System.out.println(x);
		} else {
			System.out.println(y);
		}
	}
}
