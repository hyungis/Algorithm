import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					arr[i].add(j);
				}
			}
		}	
		
		for(int i = 0; i<n; i++) {
			if(!arr[i].isEmpty()) {
				check = new boolean[n];
				dfs(i);
				for(int j = 0; j<n; j++) {
					if(check[j]) {
						sb.append(1).append(" ");
					}else {
						sb.append(0).append(" ");
					}
				}
			}else {
				for(int j = 0; j<n; j++) {
					sb.append(0).append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
		
	}
	static void dfs(int start) {
		
		for(int v : arr[start]) {
			if(check[v]) continue;
			check[v] = true;
			dfs(v);
		}
	}


}
