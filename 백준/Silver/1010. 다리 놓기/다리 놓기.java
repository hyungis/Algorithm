import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			dp = new int[n+1][n+1];
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<=i; j++) {
					if(i == j || j == 0) dp[i][j] = 1;
					else {
						dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
					}
				}
			}
			int result = dp[n-1][k-1] + dp[n-1][k];
			sb.append(result).append('\n');
			
//			int result = dfs(n, k);
//			sb.append(result).append('\n');
		}
		System.out.println(sb);

	}
//	static int dfs(int n, int k) {
//		if(n == k || k == 0) {
//			return 1;
//		}
//		return dfs(n-1, k-1) + dfs(n-1, k);
//	}

}
