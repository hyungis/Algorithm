import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == 1) continue;
			else if (x == 2) cnt++;
			else {
				boolean result = true;
				for(int j = 2; j<x; j++) {
					if (x%j == 0) {
						result = false;
						break;
					}
					
				}
				if (result) cnt++;
				
			}
		}
		
		System.out.println(cnt);
		
		
	}

}