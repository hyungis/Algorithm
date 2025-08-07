import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
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
		for(int i = 1; i<=n; i++) {
			if(check[i] == false) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	public static void dfs(int cnt) {
		check[cnt] = true;
		for(int v: arr[cnt]) {
			if(check[v]) continue;
			dfs(v);
		}
	}
	

}