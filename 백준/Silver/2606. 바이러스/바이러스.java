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
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		check = new boolean[n+1];
		arr = new ArrayList[n+1];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		dfs(1);
		System.out.println(count-1);
	}
	public static void dfs(int cnt) {
		check[cnt] = true;
		count++;
		for(int v: arr[cnt]) {
			if(check[v]) continue;
			dfs(v);
		}
	}
	

}