import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[100][100];
		StringTokenizer st;
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int x = a; x<a+10; x++) {
				for(int y = b; y<b+10; y++){
					if(x < 100 && y < 100) {
						arr[x][y] = true;
					}
					
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j]) cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}