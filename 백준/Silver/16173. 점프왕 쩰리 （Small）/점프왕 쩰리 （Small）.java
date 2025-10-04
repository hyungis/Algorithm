import java.io.*;
import java.util.*;

public class Main {
    
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		n = Integer.parseInt(br.readLine());
    		map = new int[n][n];
    		visited = new boolean[n][n];
    		
    		for(int i = 0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<n; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		boolean result = dfs(0, 0);
    		if(result) {
    			System.out.println("HaruHaru");
    		}else {
    			System.out.println("Hing");
    		}
    	
    }
    static boolean dfs(int x, int y) {
    		if(map[x][y] == -1) {
    			return true;
    		}
    		
    		int cnt = map[x][y];
    		visited[x][y] = true;
    		
    		for(int i = 0; i<2; i++) {
    			int nx = x + dx[i]*cnt;
    			int ny = y + dy[i]*cnt;
    			
    			if(nx < 0 || ny < 0 || nx >=n || ny >= n || visited[nx][ny]) continue;
    			if(dfs(nx, ny)) return true;
    		}
    		return false;
    		
    }
}
