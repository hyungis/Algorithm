import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		sb = new StringBuilder();
		
		dfs(0, 1);
		System.out.println(sb);
		
	}
	public static void dfs(int cnt, int start) {
		if(cnt == m) {
			for(int v: arr) {
				sb.append(v).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = start; i<=n; i++) {
			arr[cnt] = i;
			dfs(cnt+1, i+1);
		}
	}

}