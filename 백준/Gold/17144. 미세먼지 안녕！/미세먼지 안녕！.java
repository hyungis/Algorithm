import java.util.*;
import java.io.*;

public class Main {

	static int R,C,T;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q = new ArrayDeque<>();
	static ArrayList<Integer> robot = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					robot.add(i);
				}
			}
		}
		for(int i = 0; i<T; i++) {
			virus();
		}
		
		int result = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
		
        
	}
	
	static void virus() {
		
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(map[i][j] != -1 && map[i][j] != 0) {
					//초기의 미세먼지 값 q에 저장
					q.offer(new int[] {i, j, map[i][j]});
				}
			}
		}
		//미세먼지 확산
		func();
		//공기청정기
		clear();
		
	}
	
	static void func() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int size = now[2];
			int cnt = 0; // 몇 방향으로 퍼졌는지 세기
			
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
				map[nx][ny] += size/5;
				cnt++;
			}
			map[x][y] -= (size/5)*cnt;
		}
		
	}
	
	static void clear() {
		int top = robot.get(0); //로봇 위 방향 x좌표
		
		for(int x = top-1; x > 0; x--) {
			map[x][0] = map[x-1][0];
		}
		
		for(int y = 0; y < C-1; y++) {
			map[0][y] = map[0][y+1];
		}
		
		for(int x = 0; x < top; x++) {
			map[x][C-1] = map[x+1][C-1];
		}
		
		for(int y = C-1; y > 1; y--) {
			map[top][y] = map[top][y-1];
		}
		
		map[top][1] = 0;

		int bottom = robot.get(1); //로봇 아래 방향 x좌표
		
		for(int x = bottom+1; x < R-1; x++) {
			map[x][0] = map[x+1][0];
		}
		
		for(int y = 0; y < C-1; y++) {
			map[R-1][y] = map[R-1][y+1];
		}
		
		for(int x = R-1; x > bottom; x--) {
			map[x][C-1] = map[x-1][C-1];
		}
		
		for(int y = C-1; y > 1; y--) {
			map[bottom][y] = map[bottom][y-1];
		}
		
		map[bottom][1] = 0;
		
	}
	
}
