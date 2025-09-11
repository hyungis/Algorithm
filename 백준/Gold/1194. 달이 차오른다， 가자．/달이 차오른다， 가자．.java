import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static char[][] map;
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
        map = new char[n][m];
        visited = new boolean[64][n][m];
        int x, y;
        x = y = 0;
        
        for(int i = 0; i<n; i++) {
        	String s = br.readLine();
        	for(int j = 0; j<m; j++) {
        		map[i][j] = s.charAt(j);
        		if(map[i][j] == '0') {
        			x = i; y = j;
        		}
        	}
        }
        int result = bfs(x, y, 0, 0);
        System.out.println(result);

    }
    static int bfs(int x, int y, int key, int cnt) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.offer(new int[] {x, y, key, cnt});
    	visited[key][x][y] = true;
    	
    	while(!q.isEmpty()) {
    		int[] now = q.poll();
    		int now_x = now[0];
    		int now_y = now[1];
    		int now_key = now[2];
    		int now_cnt = now[3];
    		
    		if(map[now_x][now_y] == '1') {
    			return now_cnt;
    		}
    		
    		for(int i = 0; i<4; i++) {
        		int nx = now_x + dx[i];
        		int ny = now_y + dy[i];
        		
        		if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#' || visited[now_key][nx][ny]) continue;
        		
        		if(map[nx][ny] == '.' || map[nx][ny] == '0' || map[nx][ny] == '1') {
        			visited[now_key][nx][ny] = true;
        			q.offer(new int[] {nx, ny, now_key, now_cnt+1});
        		}
        		//열쇠를 발견했을 때
        		if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
        			int nextkey = now_key | 1 << (map[nx][ny] - 'a');
        			if(!visited[nextkey][nx][ny]) {
        				visited[now_key][nx][ny] = true;
        				visited[nextkey][nx][ny] = true;
        				q.offer(new int[] {nx, ny, nextkey, now_cnt+1});
        			}
        		}
        		//문을 발견했을 때
        		if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
        			int door = 1 << (map[nx][ny] - 'A');
        			if((now_key & door) > 0) {
        				visited[now_key][nx][ny] = true;
        				q.offer(new int[] {nx, ny, now_key, now_cnt+1});
        			}
        		}
        		
        		
        	}
    	}
    	return -1;
    }

}