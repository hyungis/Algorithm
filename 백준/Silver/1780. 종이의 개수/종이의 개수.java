import java.io.*;
import java.util.*;

public class Main {
    
	static int n;
	static int[][] map;
	static int zcnt, mcnt, ocnt;
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		n = Integer.parseInt(br.readLine());
    		map = new int[n][n];
    		
    		for(int i = 0; i<n; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j<n; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		dfs(0, 0, n);
    		System.out.println(mcnt);
    		System.out.println(zcnt);
    		System.out.println(ocnt);
    
    }
    static void dfs(int x, int y, int size) {
    	int target = map[x][y];
    	
    	for(int i = x; i<x+size; i++) {
    		for(int j = y; j<y+size; j++) {
    			if(map[i][j] != target) {
    				int newsize = size/3;
    				
    				dfs(x, y, newsize);
    				dfs(x, y+newsize, newsize);
    				dfs(x, y+2*newsize, newsize);
    				
    				dfs(x+newsize, y, newsize);
    				dfs(x+newsize, y+newsize, newsize);
    				dfs(x+newsize, y+2*newsize, newsize);
    				
    				dfs(x+2*newsize, y, newsize);
    				dfs(x+2*newsize, y+newsize, newsize);
    				dfs(x+2*newsize, y+2*newsize, newsize);
    				return;
    			}
    		}
    	}
    	if(target == -1) mcnt++;
    	if(target == 0) zcnt++;
    	if(target == 1) ocnt++;
    	
    }
    
}