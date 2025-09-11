import java.util.*;
import java.io.*;

public class Main {

	static int k, w, h;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] jumpx = {-2, -2, 2, 2, -1, -1, 1, 1};
	static int[] jumpy = {-1, 1, -1, 1, -2, 2, -2, 2};
	static boolean[][][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][w];
        visited = new boolean[k+1][h][w];
        for(int i = 0; i<h; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<w; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int result = bfs(0, 0, 0, 0);
        System.out.println(result);
        

    }
    //user -> 점프 사용한 횟수
    static int bfs(int x, int y, int used, int cnt) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x,y,used,cnt});
    	visited[0][x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		int now_used = now[2];
    		int now_cnt = now[3];
    		
    		if(now_x == h-1 && now_y == w-1) {
    			return now_cnt;
    		}
    		
    		for(int i = 0; i<4; i++) {
    			int nx = now_x + dx[i];
    			int ny = now_y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
    			if(visited[now_used][nx][ny] || map[nx][ny] == 1) continue;
    			visited[now_used][nx][ny] = true;
    			q.offer(new int[] {nx, ny, now_used, now_cnt+1});
    		}
    		
    		if(now_used >= k) continue;
    		for(int i = 0; i<8; i++) {
    			int nx = now_x + jumpx[i];
    			int ny = now_y + jumpy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
    			if(visited[now_used+1][nx][ny] || map[nx][ny] == 1)continue;
    			visited[now_used+1][nx][ny] = true;
    			q.offer(new int[] {nx, ny, now_used+1, now_cnt+1});
    		}
    	}

    	return -1;
    }

}