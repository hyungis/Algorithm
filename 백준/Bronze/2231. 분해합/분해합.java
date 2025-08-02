import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean result = false;
		int answer = 0;
		for(int i = 1; i<=Integer.parseInt(s); i++) {
			String n = String.valueOf(i);
			int cnt = i;
			for(int j = 0; j<n.length(); j++) {
				char c = n.charAt(j);
				cnt += c-'0';
			}
			if(cnt == Integer.parseInt(s)) {
				result = true;
				System.out.println(i);
				break;
			}
		}
		if(!result) System.out.println(0);
		
		
		
		
	}

}