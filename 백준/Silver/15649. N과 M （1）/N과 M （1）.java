import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	static int[] arr;
	static boolean[] check;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		check = new boolean[n+1];
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
			arr[cnt] = i;
			dfs(cnt+1);
			check[i] = false;
			
		}
		
	}

}