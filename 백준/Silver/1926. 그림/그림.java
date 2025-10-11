import java.io.*;
import java.util.*;

public class Main {
    
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count;
	static int max = 0;
	static int maxcnt;
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		map = new int[n][m];
    		visited = new boolean[n][m];
    		
    		for(int i = 0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<m; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		for(int i = 0; i<n; i++) {
    			for(int j = 0; j<m; j++) {
    				if(visited[i][j]) continue;
    				
    				if(map[i][j] == 1) {
    					maxcnt = 0;
    					dfs(i, j, 1);
    					count++;
    					if(maxcnt > max) max = maxcnt;
    				}
    			}
    		}
    		System.out.println(count);
    		System.out.println(max);
    }
    static void dfs(int x, int y, int cnt) {
    	visited[x][y] = true;
    	maxcnt++;
    	
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;
    		dfs(nx, ny, cnt+1);
    	}
    }
    
}

