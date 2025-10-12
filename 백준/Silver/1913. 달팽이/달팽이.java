import java.io.*;
import java.util.*;

public class Main {
    
	static int n, target, r_x, r_y;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		n = Integer.parseInt(br.readLine());
    		target = Integer.parseInt(br.readLine());
    		
    		map = new int[n][n];
    		int start = (int) Math.pow(n, 2);
    		dfs(0, 0, 0, start);
    		
    		for(int[] v : map) {
    			for(int x : v) {
    				sb.append(x).append(" ");
    			}
    			sb.append("\n");
    		}
    		sb.append(r_x+1).append(" ").append(r_y+1);
    		System.out.println(sb);
    
    }
    static void dfs(int x, int y, int dir, int start) {
    	if(map[x][y] != 0) {
    		return;
    	}
    	
    	map[x][y] = start;
    	if(map[x][y] == target) {
    		r_x = x;
    		r_y = y;
    	}
    	int nx = x + dx[dir];
    	int ny = y + dy[dir];
    	if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
    		dfs(x+dx[(dir+1)%4], y + dy[(dir+1)%4], (dir+1)%4, start-1);
    	}else {
    		dfs(nx, ny, dir, start-1);
    	}
    }
    
}
