import java.io.*;
import java.util.*;

public class Main {
    
	static int n;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int s_x, s_y, e_x, e_y;
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		int T = Integer.parseInt(br.readLine());
    		while(T-- > 0){
    			n = Integer.parseInt(br.readLine());
    			map = new int[n][n];
    			check = new boolean[n][n];
    			
    			st = new StringTokenizer(br.readLine());
    			s_x = Integer.parseInt(st.nextToken());
    			s_y = Integer.parseInt(st.nextToken());
    			
    			st = new StringTokenizer(br.readLine());
    			e_x = Integer.parseInt(st.nextToken());
    			e_y = Integer.parseInt(st.nextToken());
    			
    			int result = bfs(s_x, s_y, 0);
    			sb.append(result).append("\n");
    		}
    		System.out.println(sb);
    
    }
    static int bfs(int x, int y, int cnt) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x, y, cnt});
    	check[x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		int now_cnt = now[2];
    		
    		if(now_x == e_x && now_y == e_y) {
    			return now_cnt;
    		}
    		
    		for(int i = 0; i<8; i++) {
    			int nx = now_x + dx[i];
    			int ny = now_y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny]) continue;
    			q.offer(new int[] {nx, ny, now_cnt+1});
    			check[nx][ny] = true;
    			
    		}
    	}
    	
    	return -1;
    }
    
}
