import java.io.*;
import java.util.*;

public class Main {
	
	static int v, e;
	static int[] parents;
	static ArrayList<Edge> edges;
	
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
		parents[pb] = pa;
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        v = Integer.parseInt(br.readLine());
        parents = new int[v];
        for(int i = 0; i<v; i++) {
        	parents[i] = i;
        }
        
        edges = new ArrayList<>();
        for(int i = 0; i<v; i++) {
        	String[] s = br.readLine().split(" ");
        	for(int j = i+1; j<v; j++) {
        		edges.add(new Edge(i, j, Integer.parseInt(s[j])));
        	}
        }
        
        Collections.sort(edges);
        
        long result = 0;
        int cnt = 0;
        int s = v-1;
        for(Edge v : edges) {
        	if(!union(v.from, v.to)) continue;
        	result += v.weight;
        	if(++cnt == s) break;
        }
        System.out.println(result);

    }
}

