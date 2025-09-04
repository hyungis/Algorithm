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
			long[] dp = new long[101];
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			if(n < 6) {
				sb.append(dp[n]).append('\n');
				continue;
			}
			for(int i = 6; i<=n; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);
		
		
	}


}
