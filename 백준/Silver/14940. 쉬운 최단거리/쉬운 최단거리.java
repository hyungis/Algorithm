import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int targetx, targety;
	static boolean[][] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		check = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					targetx = i;
					targety = j;
				}
			}
		}
		map[targetx][targety] = 0;
		bfs(targetx, targety);
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				if(!check[i][j] && map[i][j] == 1) {
					sb.append(-1).append(" ");
				}else {
					sb.append(map[i][j]).append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x,y});
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int now_x = now[0];
			int now_y = now[1];
			
			for(int i = 0; i<4; i++) {
				int nx = now_x + dx[i];
				int ny = now_y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m || check[nx][ny] || map[nx][ny] == 0) continue;
				map[nx][ny] = map[now_x][now_y] + 1;
				q.offer(new int[] {nx, ny});
				check[nx][ny] = true;
			}
		}
	}
}