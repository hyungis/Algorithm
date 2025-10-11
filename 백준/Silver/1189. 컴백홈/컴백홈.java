import java.io.*;
import java.util.*;

public class Main {
    
	static int r, c, k;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = 0;
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		r = Integer.parseInt(st.nextToken());
    		c = Integer.parseInt(st.nextToken());
    		k = Integer.parseInt(st.nextToken());
    		
    		map = new char[r][c];
    		visited = new boolean[r][c];
    		
    		for(int i = 0; i<r; i++) {
    			String s = br.readLine();
    			for(int j = 0; j<c; j++) {
    				map[i][j] = s.charAt(j);
    			}
    		}
    		
    		dfs(r-1, 0, 1);
    		System.out.println(result);
    
    }
    static void dfs(int x, int y, int cnt) {
    	if(x==0 && y == c-1) {
    		if(cnt == k) {
    			result++;
    		}
			return;
    	}
    	
    	visited[x][y] = true;
    	
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == 'T' || visited[nx][ny]) continue;
    		dfs(nx, ny, cnt+1);
    	}
    	visited[x][y] = false;
    }

    
}