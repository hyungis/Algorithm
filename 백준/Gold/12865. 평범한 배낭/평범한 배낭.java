import java.util.*;
import java.io.*;

public class Main {


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] items = new int[N+1];    //물건의 가치
 		int[] weights = new int[N+1];  //물건의 무게
		
 		int[][] result = new int[N+1][K+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <=N; i++) {
			int itemvalue = items[i];
			int itemweight = weights[i];
			
			for(int j = 1; j<=K; j++) {
				if(itemweight > j) {
					result[i][j] = result[i-1][j];
				}else {
					result[i][j] = Math.max(result[i-1][j], result[i-1][j-itemweight]+itemvalue);
				}
			}
		}
		
		System.out.println(result[N][K]);
		
	}

}
