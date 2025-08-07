import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static boolean[] check;
	static ArrayList<Integer>[] arr;
	static int count = 0;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		result = new int[n+1];
		check = new boolean[n+1];
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
		for(int i = 0; i<arr.length; i++) {
			Collections.sort(arr[i], (a,b)-> b-a);
		}
		count++;
		bfs(r);
		for(int i = 1; i<=n; i++) {
			System.out.println(result[i]);
		}
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		check[start] = true;
		result[start] = count;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int v: arr[now]) {
				if(check[v] == false) {
					check[v] = true;
					q.add(v);
					count++;
					result[v] = count;
				}
			}
		}
	}

}