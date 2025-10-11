import java.io.*;
import java.util.*;

public class Main {
    
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		map = new int[n][m];
    		
    		
    		for(int i = 0; i<n; i++) {
    			String s = br.readLine();
    			for(int j = 0; j<m; j++) {
    				
    				map[i][j] = s.charAt(j) - '0';
    			}
    		}
    		boolean result = false;
    		for(int i = 0; i<m; i++) {
    			if(map[0][i] == 0) {
    				visited = new boolean[n][m];
    				result = dfs(0, i);
    				if(result) {
    					break;
    				}
    			}
    		}
    		
    		System.out.println(result ? "YES" : "NO");
    
    }
    static boolean dfs(int x, int y) {
    	if(x == n-1) {
    		return true;
    	}
    	visited[x][y] = true;
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1) continue;
    		if(dfs(nx, ny)) return true;
    	}
    	
    	return false;
    }

}