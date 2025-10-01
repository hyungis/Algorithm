import java.util.*;
import java.io.*;

class Main {
	static final int MAX = 8, X = 0, Y = 1;
	static boolean[][] map = new boolean[MAX][MAX];
	static Queue<int[]> wallList = new ArrayDeque<>();
	static int[][] dict = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for (int i = 0; i < MAX; i++) {
    		String str = br.readLine();
    		for (int j = 0; j < MAX; j++) {
    			if (str.charAt(j) == '#') map[i][j] = true;
    		}
    	}
    	
    	for (int i = MAX - 1; i >= 0; i--) {
    		for (int j = 0; j < MAX; j++) {
    			if (map[i][j]) wallList.add(new int[] {i, j});
    		}
    	}
    	
    	System.out.println(bfs(MAX - 1, 0));
    }
    
    private static int bfs(int x, int y) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {x, y});
    	
    	while (!q.isEmpty()) {
    		int size = q.size();
    		boolean[][] visited = new boolean[MAX][MAX]; // 💡 시간 단위마다 초기화
    		
    		for (int t = 0; t < size; t++) {
    			int[] cur = q.poll();
    			
    			if (map[cur[X]][cur[Y]]) continue;
    			if (cur[X] == 0 && cur[Y] == MAX - 1) return 1;
    			
    			for (int i = 0; i < 9; i++) {
    				int nx = cur[X] + dict[i][X];
    				int ny = cur[Y] + dict[i][Y];
    				
    				if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
    				if (map[nx][ny] || visited[nx][ny]) continue;
    				
    				q.add(new int[] {nx, ny});
    				visited[nx][ny] = true;
    			}
    		}
    		
    		downWall();
    	}
    	return 0;
    }
    
    private static void downWall() {
    	int size = wallList.size();
    	for (int i = 0; i < size; i++) {
    		int[] wall = wallList.poll();
    		map[wall[X]][wall[Y]] = false;
    		wall[X]++;
    		if (wall[X] >= MAX) continue;
    		map[wall[X]][wall[Y]] = true;
    		wallList.add(wall);
    	}
    }
}
