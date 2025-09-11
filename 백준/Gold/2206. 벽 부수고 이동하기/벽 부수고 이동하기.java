import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for(int i = 0; i<n; i++) {
        	String s = br.readLine();
        	for(int j = 0; j<m; j++) {
        		map[i][j] = s.charAt(j)-'0';
        	}
        }
        
        visited = new boolean[2][n][m];
        
        int result = bfs(0, 0);
        System.out.println(result);

        

    }
    static int bfs(int x, int y) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x,y,0,1}); //x좌표, y좌표, (0이면 1을 안깨고 온 상태, 1이면 한번 깨고 온 상태), 현재개수
    	visited[0][x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		int brk = now[2];
    		int cnt = now[3];
    		
    		if(now_x == n-1 && now_y == m-1) {
    			return cnt;
    		}
    		for(int i = 0; i<4; i++) {
    			int nx = now_x + dx[i];
    			int ny = now_y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
    			
    			if(map[nx][ny] == 1 && brk == 1) continue;
    			if(map[nx][ny] == 1 && brk == 0 && !visited[1][nx][ny]) {
    				visited[1][nx][ny] = true;
    				q.offer(new int[] {nx, ny, 1, cnt+1});
    				
    			}
    			if(map[nx][ny] == 0 && !visited[brk][nx][ny]) {
    				visited[brk][nx][ny] = true;
    				q.offer(new int[] {nx, ny, brk, cnt+1});
    			}
    		}
    	}
    	return -1;
    }

}