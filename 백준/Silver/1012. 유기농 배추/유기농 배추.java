import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int n, m, k;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] check;
	static int result;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t<tc; t++) {
        	result = 0;
        	st = new StringTokenizer(br.readLine());
        	m = Integer.parseInt(st.nextToken());
        	n = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	arr = new int[n][m];
        	check = new boolean[n][m];
        	
        	for(int i = 0; i<k; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		arr[b][a] = 1;
        	}
        
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<m; j++) {
        			if(!check[i][j] && arr[i][j] == 1) {
        				dfs(i, j);
        				result++;
        			}
        			
        		}
        	}
        	System.out.println(result);
        }
        
        
        
    }
    public static void dfs(int x, int y) {
    	check[x][y] = true;
    	
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && !check[nx][ny]) {
    			dfs(nx, ny);
    		}
    	}
    }
}
