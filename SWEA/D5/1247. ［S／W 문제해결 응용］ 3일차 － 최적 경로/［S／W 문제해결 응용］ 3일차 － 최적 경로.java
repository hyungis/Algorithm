import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int h_x, h_y, c_x, c_y, n, n_x, n_y;
	static int[][] customer;
	static int min;
	static boolean[] check;
	static int[] arr;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			c_x = Integer.parseInt(st.nextToken());
			c_y = Integer.parseInt(st.nextToken());
			n_x = c_x;
			n_y = c_y;
			h_x = Integer.parseInt(st.nextToken());
			h_y = Integer.parseInt(st.nextToken());
			customer = new int[n][2];
			check = new boolean[n];
			arr = new int[n];
			for(int i = 0; i<n; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#"+tc+" "+min);
		}
		
		
		
		
	}
	public static void dfs(int cnt) {
		if(cnt == n) {
			sum = 0;
			for(int v : arr) {
				sum += Math.abs(c_x - customer[v][0]) + Math.abs(c_y - customer[v][1]);
				c_x = customer[v][0];
				c_y = customer[v][1];
			}
			sum += Math.abs(c_x - h_x) + Math.abs(c_y - h_y);
			min = Math.min(min, sum);
			c_x = n_x;
			c_y = n_y;
			return;
		}
		for(int i = 0; i<n; i++) {
			if(check[i]) continue;
			check[i] = true;
			arr[cnt] = i;
			dfs(cnt+1);
			check[i] = false;
		}
	}

}