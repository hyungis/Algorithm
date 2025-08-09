import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("C:\\Users\\User\\Downloads\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {0, 0, -1}; // 좌, 우, 상
		int[] dy = {-1, 1, 0};
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int x = 0, y = 0;
			
			for(int i = 0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i == 99 && arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			while (x > 0) {
				for(int i = 0; i<3; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx< 0 || nx >= 100 || ny < 0 || ny >= 100 || arr[nx][ny] == 0) continue;
					
					x = nx;
					y = ny;
					arr[nx][ny] = 0;
				}
			}
			
			System.out.println("#"+tc+" "+ y);
		}
		
		
		
		
	}

}