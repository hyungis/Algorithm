import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static int[][] map;
	static int[][] minWeight;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int INF = Integer.MAX_VALUE;
	
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
		minWeight = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				minWeight[i][j] = INF;
			}
		}
		
		dijkstra();
		System.out.println(minWeight[n-1][m-1]);

	} 
	static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		minWeight[0][0] = 0;
		
		pq.offer(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			if(visited[now.r][now.c]) continue;
			visited[now.r][now.c] = true;
			
			if(now.r == n-1 && now.c == m-1) return;
			 
			for(int i = 0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
				
				if(!visited[nr][nc] && minWeight[nr][nc] > map[nr][nc] + now.weight) {
					minWeight[nr][nc] = map[nr][nc] + now.weight;
					pq.offer(new Point(nr, nc, minWeight[nr][nc]));
				}
			}
		}
		
	}

}
