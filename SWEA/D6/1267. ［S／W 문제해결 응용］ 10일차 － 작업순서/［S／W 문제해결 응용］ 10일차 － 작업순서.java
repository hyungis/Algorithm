import java.io.*;
import java.util.*;

public class Solution {
	
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int[] isD;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++) {
        	st = new StringTokenizer(br.readLine());
        	v = Integer.parseInt(st.nextToken());
        	e = Integer.parseInt(st.nextToken());
        	arr = new ArrayList[v+1];
        	isD = new int[v+1];
        	for(int i = 1; i<=v; i++) {
        		arr[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<e; i++) {
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		arr[a].add(b);
        		isD[b]++;
        	}
        	
        	Queue<Integer> q = new ArrayDeque<>();
        	for(int i = 1; i<=v; i++) {
        		if(isD[i] == 0) q.add(i);
        	}
        	
        	sb.append("#").append(t).append(" ");
        	while(!q.isEmpty()) {
        		int now = q.poll();
        		sb.append(now).append(" ");
        		for(int v : arr[now]) {
        			isD[v]--;
        			if(isD[v] == 0) {
        				q.add(v);
        			}
        		}
        	}
        	sb.append('\n');
        	
        }
        System.out.println(sb);
        
        
    }



}

