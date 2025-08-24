import java.io.*;
import java.util.*;

public class Main {
	
	static char map[][];
	static boolean[] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        map = new char[5][5];
        check = new boolean[25];
        for(int i = 0 ; i<5; i++) {
        	String s = br.readLine();
        	for(int j = 0; j<5; j++) {
        		char c = s.charAt(j);
        		map[i][j] = c;
        	}
        }
        
        func(0, 0, 0);
        
        System.out.println(result);
        
    }
    static void func(int idx, int depth, int ycnt) {
    	if(ycnt >= 4) return;
    	
    	if(depth == 7) {
    		visited = new boolean[5][5];
    		int count = dfs((idx-1)/5, (idx-1)%5);
    		if(count == 7) result++;
    		return;
    	}
    	
    	for(int i = idx; i < 25; i++) {
    		check[i] = true;
    		if(map[i/5][i%5] == 'Y') {
    			func(i+1, depth+1, ycnt+1);
    		}else {
    			func(i+1, depth+1, ycnt);
    		}
    		check[i] = false;
    	}
    }
    
    static int dfs(int x, int y) {
    	visited[x][y] = true;
    	int cnt = 1;
    	
    	
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
    		
    		if(!visited[nx][ny] && check[nx*5+ny]) {
    			cnt += dfs(nx, ny);
    		}
    	}
    	return cnt;
    }
    

}

