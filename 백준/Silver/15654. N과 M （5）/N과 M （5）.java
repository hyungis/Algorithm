import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] check;
	static int[] arr;
	static int n, m;
	static StringBuilder sb;
	static int[] arr2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		check = new boolean[n+1];
		arr = new int[m];
		arr2 = new int[n+1];
		for(int i = 1; i<=n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		
		sb = new StringBuilder();
		
		dfs(0);
		System.out.println(sb);
		
		
	}
	public static void dfs(int cnt) {
		if(cnt == m) {
			for(int v: arr) {
				sb.append(v).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i<=n; i++) {
			if(check[i]) continue;
			check[i] = true;
			arr[cnt] = arr2[i];
			dfs(cnt+1);
			check[i] = false;
		}
		
	}

}