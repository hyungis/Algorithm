import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[42];
		int result = 0;
		
		for(int i = 0; i<10; i++) {
			int x = Integer.parseInt(br.readLine()) % 42;
			if (!arr[x]) {
				arr[x] = true;
			}
		}
		
		for(boolean i : arr) {
			if (i) {
				result++;
			}
		}
		
		System.out.println(result);
		
	}		
}
	
	
	
	
	
