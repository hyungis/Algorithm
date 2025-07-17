import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			if(arr[a-'a'] == -1) {
				arr[a-'a'] = i;
			}
		}
		
		for (int val: arr) {
			System.out.print(val+" ");
		}
		
	}
}
