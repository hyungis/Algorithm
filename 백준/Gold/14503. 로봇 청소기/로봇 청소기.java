import java.io.*;
import java.util.*;

public class Main {
	// 0-북쪽, 1-동쪽, 2-남쪽, 3-서쪽
	static int n, m;
	static int[][] map;
	static int r, c, d;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);
		System.out.println(result+1);
		


		
	}
	static void dfs(int r, int c, int d) {
		// -1은 청소 
		map[r][c] = -1;
		
		//4방향 탐색해서 이동하기
		for(int i = 0; i<4; i++) {
			d = (d+3)%4;
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
			
			if(map[nr][nc] == 0) {
				result++;
				dfs(nr, nc, d);
				return;
			}
		}
		//4방향중에 빈칸이 없는경우
		int br = r-dr[d];
		int bc = c-dc[d];
		if(br >= 0 && bc >= 0 && br < n && bc < m && map[br][bc] != 1) {
			dfs(br, bc, d);
		}
		
	}
}




