import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static int[][] arr;
	static boolean[][] check;
	static boolean[] checknum;
	static int[] dx = {-1, 1, 1, -1};
	static int[] dy = {1, 1, -1, -1};
	static int max, count;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	n = Integer.parseInt(br.readLine());
        	arr = new int[n][n];
        	max = -1;
        	
        	for(int i = 0; i<n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 0; j<n; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<n; j++) {
        			check = new boolean[n][n];
        			checknum = new boolean[101];
        			
        			check[i][j] = true;
        	    	checknum[arr[i][j]] = true;
        			dfs(i, j, i, j, 0, 1);
        		}
        	}
        	sb.append("#").append(t).append(" ");
        	if(max == -1) sb.append(-1).append('\n');
        	else sb.append(max).append('\n');
        }
        System.out.println(sb);
        
        
    }
    static void dfs(int startx, int starty, int x, int y, int dir, int cnt) {
    	
    	for(int d = dir; d < 4; d++) {
    		int nx = x + dx[d];
    		int ny = y + dy[d];
    		
    		if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
    		
    		if(startx == nx && starty == ny && cnt >= 4) {
    			max = Math.max(max, cnt);
    			return;
    		}
    		
    		if(check[nx][ny] || checknum[arr[nx][ny]]) continue;
    		
    		check[nx][ny] = true;
    		checknum[arr[nx][ny]] = true;
    		dfs(startx, starty, nx, ny, d, cnt+1);
    		check[nx][ny] = false;
    		checknum[arr[nx][ny]] = false;
    	}
    }

}

