import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static Map<Integer, Integer> ladder  = new HashMap<>();
	static Map<Integer, Integer> snake =new HashMap<>();
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int result = bfs(1);
		System.out.println(result);
		
	}
	static int bfs(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == 100) {
				return cur[1];
			}
			for(int i = 1; i<=6; i++) {
				int next = cur[0]+i;
				if(next > 100) continue;
				if(visited[next]) continue;
				
				if(ladder.containsKey(next)) {
					int x = ladder.get(next);
					q.offer(new int[] {x, cur[1]+1});
					visited[x] = true;
				}
				else if(snake.containsKey(next)) {
					int y = snake.get(next);
					q.offer(new int[] {y, cur[1]+1});
					visited[y] = true;
				}
				else{
					q.offer(new int[] {next, cur[1]+1});
					visited[next] = true;
				}
				
			}
		}
		return -1;
	}
}
