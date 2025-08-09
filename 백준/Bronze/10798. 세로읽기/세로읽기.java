import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[5][15];
		
		for(int i = 0; i<5; i++) {
			String s = br.readLine();
			for(int j = 0; j<s.length(); j++) {
				char c = s.charAt(j);
				arr[i][j] = c;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<15; i++) {
			for(int j = 0; j<5; j++) {
				if(arr[j][i] != '\u0000') {
					System.out.print(arr[j][i]);
				}
				
			}
		}
		
		
		
	}

}