import java.io.*;
import java.util.*;

public class Main {


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[12];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			if(n < 4) {
				sb.append(dp[n]).append('\n');
				continue;
			}
			for(int i = 4; i<=n; i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);
		
		
	}


}
