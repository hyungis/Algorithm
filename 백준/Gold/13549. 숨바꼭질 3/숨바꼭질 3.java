import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		check = new boolean[100001];
		dijkstra(n);
		

	}
	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		pq.offer(new int[] {0, start});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int nPosition = now[1];
			int count = now[0];
			
			if(nPosition == k) {
				System.out.println(count);
				return;
			}
			
			check[nPosition] = true;
			if(nPosition-1 >= 0 && !check[nPosition-1]) {
				pq.offer(new int[] {count+1, nPosition-1});
			}
			if(nPosition+1 <= 100000 && !check[nPosition+1]) {
				pq.offer(new int[] {count+1, nPosition+1});
			}
			if(nPosition*2 <= 100000 && !check[nPosition*2]) {
				pq.offer(new int[] {count, nPosition*2});
			}
			
		}
		
		
	}
}
