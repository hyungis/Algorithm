import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int n;
	static int[][] arr;
	static int count = 0;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static List<Integer> list = new ArrayList<>();;
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		check = new boolean[n][n];
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<s.length(); j++) {
				char c = s.charAt(j);
				arr[i][j] = c-'0';
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] == 1 && check[i][j] == false) {
					sum = 0;
					dfs(i, j);
					count++;
					list.add(sum);
				}
			}
		}
		Collections.sort(list);
		System.out.println(count);
		for(int v: list) {
			System.out.println(v);
		}
		
	}
	public static void dfs(int x, int y) {
		check[x][y] = true;
		sum++;
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>= 0 && nx < n && ny < n && arr[nx][ny] == 1 && !check[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}

}