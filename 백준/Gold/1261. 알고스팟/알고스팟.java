import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point implements Comparable<Point>{
		int r, c, weight;

		public Point(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int result = bfs();
		System.out.println(result);

	} 
	static int bfs() {
		Deque<Point> dq = new ArrayDeque<>();
		dq.offer(new Point(0, 0, 0));
		
		while(!dq.isEmpty()) {
			Point now = dq.poll();
			
			if(visited[now.r][now.c])continue;
			visited[now.r][now.c]=true;
			
			if(now.r == n-1 && now.c == m-1) return now.weight;
			
			for(int i = 0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
				
				if(map[nr][nc] == 0) {
					dq.addFirst(new Point(nr, nc, now.weight));
				}else {
					dq.addLast(new Point(nr, nc, now.weight+1));
				}
			}
		}
		
		return -1;
	}

}
