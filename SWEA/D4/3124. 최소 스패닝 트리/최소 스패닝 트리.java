import java.io.*;
import java.util.*;

public class Solution {
	
	static int v, e;
	
	static class node implements Comparable<node>{
		int from, to, weight;
		
		public node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int[] parents;
	static node[] nodes;
	
	static void make() {
		for(int i = 1; i<=v; i++) {
			parents[i] = i;
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
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
        	v = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	parents = new int[v+1];
        	make();
        	nodes = new node[e];
        	for(int i = 0; i<e; i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken());
        		int to = Integer.parseInt(st.nextToken());
        		int weight = Integer.parseInt(st.nextToken());
        		nodes[i] = new node(from, to, weight);
        	}
        	Arrays.sort(nodes);
        	
        	long result = 0;
        	int cnt = 0;
        	for(node x: nodes) {
        		if(!union(x.from, x.to)) continue;
        		result+= x.weight;
        		if(++cnt == v-1) break;
        	}
        	sb.append("#").append(t).append(" ").append(result).append('\n');
        }
        System.out.println(sb);

    }

}

