import java.util.*;
import java.io.*;

public class Solution {


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] score = new int[N+1];
			int[] cal = new int[N+1];
			int[][] result = new int[N+1][L+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i<=N; i++) {
				int b_score = score[i];
				int b_cal = cal[i];
				
				for(int j = 1; j<=L; j++) {
					if(b_cal > j) {
						result[i][j] = result[i-1][j];
					}else {
						result[i][j] = Math.max(result[i-1][j], result[i-1][j-b_cal] + b_score);
					}
				}
				
			}
			sb.append(result[N][L]).append('\n');
			
			
			
		}
		System.out.println(sb);
		
	}

}
