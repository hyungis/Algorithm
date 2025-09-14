import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int answer = 0;
		
		for(int i = 0; i<m; i++) {
			if(s.charAt(i) == 'I') {
				int temp = i;
				int cnt = 0;
				
				while(temp+2 < m) {
					if(s.charAt(temp+1) == 'O' && s.charAt(temp+2) == 'I') {
						cnt++;
						temp += 2;
						if(cnt == n) {
							cnt--;
							answer++;
						}
					}
					else {
						break;
					}	
				}
				i = temp;
			}
		}
		
		System.out.println(answer);
		
	}
}
