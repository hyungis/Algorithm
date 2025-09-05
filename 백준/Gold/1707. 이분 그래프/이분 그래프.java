import java.io.*;
import java.util.*;

public class Main {

	static int v, e;
	static ArrayList<Integer>[] list;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			list = new ArrayList[v+1];
			check = new int[v+1];
			
			for(int i = 1; i<=v; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			boolean result = true;
			for(int i = 1; i<=v; i++) {
				if(check[i] == 0) {
					if(!bfs(i)) {
						result = false;
						break;
					}
				}
			}
			
			if(result) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
			
			
		}
		System.out.println(sb);
		
	}
	static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		check[start] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int v : list[now]) {
				if(check[now] == check[v]) {
					return false;
				}
				if(check[v] == 0) {
					check[v] = check[now]*-1;
					q.offer(v);
				}
			}
		}
		
		return true;
	}
}




