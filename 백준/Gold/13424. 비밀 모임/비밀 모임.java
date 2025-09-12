import java.util.*;
import java.io.*;

public class Main {
	
	static class Node implements Comparable<Node>{
		int to, weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int n, m, k;
	static ArrayList<Node>[] nodes;
	static int[] minNode;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	
        	nodes = new ArrayList[n+1];
        	for(int i = 1; i<=n; i++) {
        		nodes[i] = new ArrayList<>();
        	}
        	
        	for(int i = 0; i<m; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		int weight = Integer.parseInt(st.nextToken());
        		nodes[from].add(new Node(to, weight));
        		nodes[to].add(new Node(from, weight));
        	}
        	
        	int[] answer = new int[n+1];
        	k = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<k; i++) {
        		int start = Integer.parseInt(st.nextToken());
        		dijkstra(start);
        		
        		for(int j = 1; j<=n; j++) {
        			answer[j] += minNode[j];
        		}
        	}
        	int result = Integer.MAX_VALUE;
        	int res = 0;
        	
        	for(int i = 1; i<=n; i++) {
        		if(answer[i] < result) {
        			result = answer[i];
        			res = i;
        		}
        	}
        	sb.append(res).append('\n');
        	
        }
        System.out.println(sb);
        

    }
    static void dijkstra(int start) {
    	minNode = new int[n+1];
    	visited = new boolean[n+1];
    	
    	Arrays.fill(minNode, Integer.MAX_VALUE);
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start, 0));
    	minNode[start] = 0;
    	
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		
    		if(visited[cur.to]) continue;
    		visited[cur.to]= true;
    		
    		for(Node next : nodes[cur.to]) {
    			
    			if(!visited[next.to] && minNode[next.to] > minNode[cur.to] + next.weight) {
    				minNode[next.to] = minNode[cur.to] + next.weight;
    				pq.add(new Node(next.to, minNode[next.to]));
    			}
    		}
    	}
    	
    }
    

}