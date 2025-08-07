import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static boolean[][] check;
	static int[][] arr;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		check = new boolean[m][n];
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println("No");
		
		
	}
	public static void dfs(int x, int y) {
		if(x == m-1 && y == n-1) {
			System.out.println("Yes");
			System.exit(0);
		}
		
		for(int i = 0; i<2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=m || ny>=n || check[nx][ny] || arr[nx][ny] == 0) continue;
			check[nx][ny] = true;
			dfs(nx,ny);
		}
	}
	

}