import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int result = 0;
			int sum = 0;
			String s = br.readLine();
			for(int j = 0; j<s.length(); j++) {
				char c = s.charAt(j);
				if (c == 'O') {
					sum++;
					result += sum;
				}
				if (c == 'X') {
					sum = 0;
				}
			}
			sb.append(result).append('\n');
			
		}
		
		System.out.println(sb);
		
		
	}		
}
	
	
	
	
	
