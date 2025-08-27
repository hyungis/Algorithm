import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        check = new boolean[n][n];
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //섬 구분하기
        int type = 1;
        for(int i = 0; i<n; i++) {
        	for(int j= 0; j<n; j++) {
        		if(arr[i][j] == 0) continue;
        		if(check[i][j]) continue;
        		checktype(i, j, type);
        		type++;
        	}
        }
        
        check = new boolean[n][n];
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		if(!check[i][j] && arr[i][j] != 0) {
        			check[i][j] = true;
        			bfs(i, j, arr[i][j]);
        		}
        	}
        }
        
        System.out.println(result);

    }
    static void bfs(int x, int y, int groupnum) {
    	check = new boolean[n][n];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x, y, 0});
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		int count = now[2];
    		
    		if(count >= result) continue;
    		
    		for(int i = 0; i<4; i++) {
    			int nx = now_x + dx[i];
    			int ny = now_y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx>=n || ny>=n) continue;
    			if(check[nx][ny]) continue;
    			if(arr[nx][ny] == groupnum) continue;
    			
    			if(arr[nx][ny] == 0) {
    				check[nx][ny] = true;
    				q.offer(new int[] {nx, ny, count+1});
    			}else {
    				result = Math.min(result, count);
    			}
    		}
    	}
    }
    
    static void checktype(int x, int y, int type) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x, y});
    	check[x][y] = true;
    	arr[x][y] = type;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		
    		for(int i = 0; i<4; i++) {
    			int nx = now_x + dx[i];
    			int ny = now_y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= n || ny >= n || arr[nx][ny] == 0 ||check[nx][ny]) continue;
    			check[nx][ny] = true;
    			q.offer(new int[] {nx, ny});
    			arr[nx][ny] = type;
    		}
    	}
    }
}

