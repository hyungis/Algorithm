import java.io.*;
import java.util.*;

public class Main {
	
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
	static int n;
	static int[][] map;
	static int[][] minWeight;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			sb.append("Problem").append(" ").append(tc).append(":").append(" ");
			map = new int[n][n];
			minWeight = new int[n][n];
			visited = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = dijkstra();
			sb.append(result).append('\n');
			tc++;
		}
		System.out.println(sb);
		

	}
	static int dijkstra() {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				minWeight[i][j] = INF;
			}
		}
		
		minWeight[0][0] = map[0][0];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, minWeight[0][0]));
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			if(visited[now.r][now.c])continue;
			visited[now.r][now.c] = true;
			
			if(now.r == n-1 && now.c == n-1) return now.weight;
			
			for(int i = 0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
				
				if(minWeight[nr][nc] > map[nr][nc]+ now.weight) {
					minWeight[nr][nc] = map[nr][nc]+ now.weight;
					pq.offer(new Point(nr, nc, minWeight[nr][nc]));
				}
			}
		}

		return -1;
	}
}
