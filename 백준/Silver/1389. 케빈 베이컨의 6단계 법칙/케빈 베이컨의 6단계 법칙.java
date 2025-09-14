import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int ans = -1;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		
		for(int i = 1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		

		for(int i = 1; i<=n; i++) {
			visited = new boolean[n+1];
			bfs(i, 0);
		}
		System.out.println(ans);
		
	}
	
	static void bfs(int start, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, cnt});
		visited[start] = true;
		
		int result = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int v : arr[now[0]]) {
				if(visited[v]) continue;
				q.offer(new int[] {v, now[1]+1});
				result += now[1]+1;
				visited[v] = true;
			}
		}
		if(result < min) {
			min = result;
			ans = start;
		}
	}

}
