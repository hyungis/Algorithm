import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] memory = new int[n+1];
        int[] cost = new int[n+1];
        
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] result = new int[n+1][10001];
		int ans = Integer.MAX_VALUE;
		
		for(int i = 1; i<=n; i++) {
			int mm = memory[i];
			int ct = cost[i];
			
			for(int j = 0; j<10001; j++) {
				if(j < ct) {
					result[i][j] = result[i-1][j];
				}else {
					result[i][j] = Math.max(result[i-1][j], result[i-1][j-ct]+mm);
				}
				
				if(result[i][j] >= m) {
					ans = Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);
		
	}

}
