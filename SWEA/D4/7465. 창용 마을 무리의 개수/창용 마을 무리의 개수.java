import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, m;
	static int[] parents;
	
	static void make() {
		for(int i = 1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb) return;
		if(pa > pb) parents[pb] = pa;
		else parents[pa] = pb;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	parents = new int[n+1];
        	make();
        	
        	for(int i = 0; i<m; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		union(a,b);
        	}
        	
        	int result = 0;
        	for(int i = 1; i<=n; i++) {
        		if(parents[i] == i) result++;
        	}
        	
        	sb.append(result).append('\n');
        	
        }
        System.out.println(sb);
        
       

    }

}

