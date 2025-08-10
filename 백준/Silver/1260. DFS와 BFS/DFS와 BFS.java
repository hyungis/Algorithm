import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] arr;
	static int n, m, v;
	static boolean[] check;
	static StringBuilder sb;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[n+1];
        for(int i = 0; i<arr.length; i++) {
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a].add(b);
        	arr[b].add(a);
        }
        for(int i = 1; i<arr.length; i++) {
        	Collections.sort(arr[i]);
        }
        check = new boolean[n+1];
        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb);
        check = new boolean[n+1];
        sb = new StringBuilder();
        bfs(v);
        System.out.println(sb);
        
    }
    public static void dfs(int start) {
    	check[start] = true;
    	sb.append(start).append(" ");
    	
    	for(int v: arr[start]) {
    		if(!check[v]) {
    			dfs(v);
    		}
    	}
    }
    public static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	check[start] = true;
    	sb.append(start).append(" ");
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		for(int v : arr[now]) {
    			if(!check[v]) {
    				check[v] = true;
    				sb.append(v).append(" ");
    				q.add(v);
    			}
    		}
    	}
    }
    
}
