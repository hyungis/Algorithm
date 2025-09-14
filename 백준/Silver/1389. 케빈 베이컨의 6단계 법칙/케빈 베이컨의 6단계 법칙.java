import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] result = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n; j++) {
				result[i][j] = 987654321;
				if( i == j ) {
					result[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			result[x][y] = result[y][x] = 1;
		}
		
		for(int k = 1; k<=n; k++) {
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
				}
			}
		}
		int res = Integer.MAX_VALUE;
		int ans = -1;
		for(int i = 1; i<=n; i++) {
			int total = 0;
			for(int j = 1; j<=n; j++) {
				total += result[i][j];
			}
			if(total < res) {
				res = total;
				ans = i;
			}
		}
		System.out.println(ans);
		
	}
	

}
