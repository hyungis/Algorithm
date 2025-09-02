import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int n, weight;

		public Node(int n, int weight) {
			super();
			this.n = n;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int v, e;
	static ArrayList<Node>[] nodes;
	static int[] minNode;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		nodes = new ArrayList[v+1];
		for(int i = 1; i<=v; i++) {
			nodes[i] = new ArrayList<>();
		}
		minNode = new int[v+1];
		visited = new boolean[v+1];
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes[a].add(new Node(b, c));
		}
		Arrays.fill(minNode, Integer.MAX_VALUE);
		minNode[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.n]) continue;
			visited[cur.n] = true;
			
			for(Node x : nodes[cur.n]) {
				if(!visited[x.n] && minNode[x.n] > minNode[cur.n]+ x.weight) {
					minNode[x.n] =  minNode[cur.n]+ x.weight;
					pq.offer(new Node(x.n, minNode[x.n]));
				}
			}	
		}
		
		for(int i = 1; i<=v; i++) {
			if(minNode[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(minNode[i]);
		}

	}


}
