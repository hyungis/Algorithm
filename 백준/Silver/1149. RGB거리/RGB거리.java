import java.io.*;
import java.util.*;

public class Main {


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 1001;
			}
		}
		
		for(int i = 0; i<3; i++) {
			dp[0][i] = map[0][i];
		}
		
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<3; j++) {
				if(j == 0) {
					dp[i][j] = Math.min(dp[i-1][1] + map[i][j], dp[i-1][2] + map[i][j]);
				}
				if(j == 1) {
					dp[i][j] = Math.min(dp[i-1][0] + map[i][j], dp[i-1][2] + map[i][j]);
				}
				if(j == 2) {
					dp[i][j] = Math.min(dp[i-1][1] + map[i][j], dp[i-1][0] + map[i][j]);
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0; i<3; i++) {
			result = Math.min(result, dp[n-1][i]);
		}
		System.out.println(result);
	}


}
