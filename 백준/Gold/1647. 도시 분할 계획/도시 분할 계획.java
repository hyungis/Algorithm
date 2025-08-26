import java.io.*;
import java.util.*;

public class Main {
	
	static int v, e;
	static int[] parents;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		if(pa > pb) parents[pb] = pa;
		else parents[pa] = pb;
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parents = new int[v+1];
        for(int i = 1; i<=v; i++) {
        	parents[i] = i;
        }
        
        edges = new Edge[e];
        for(int i = 0; i<e; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	edges[i] = new Edge(from, to, weight);
        }
        
        Arrays.sort(edges);
        
        int result = 0;
        int cnt = 0;
        int s = v-1;
        int max = 0;
        for(Edge v : edges) {
        	if(!union(v.from, v.to)) continue;
        	result += v.weight;
        	if(max < v.weight) max = v.weight;
        	if(++cnt == s) break;
        }
        System.out.println(result - max);
    }

    
}

