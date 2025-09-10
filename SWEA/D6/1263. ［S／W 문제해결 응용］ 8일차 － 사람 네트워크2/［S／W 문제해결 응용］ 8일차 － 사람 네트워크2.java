import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int[][] map = new int[N][N];

        	for(int i = 0; i<N; i++) {
        		for(int j = 0; j<N; j++) {
        			int x = Integer.parseInt(st.nextToken());
        			//입력값이 0이면 INF으로 초기화
        			if(x == 0) {
        				map[i][j] = 987654321;
        			}else {
        				map[i][j] = x;
        			}
        			if(i == j) map[i][j] = 0;
        			
        		}
        	}
        	
        	for(int k = 0; k<N; k++) {
        		for(int i = 0; i<N; i++) {
        			for(int j = 0; j<N; j++) {
        				map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
        			}
        		}
        	}
        	int[] cnt = new int[N];
        	for(int i = 0; i<N; i++) {
        		for(int j = 0; j<N; j++) {
        			cnt[j] += map[i][j];
        		}
        	}
        	int result = Integer.MAX_VALUE;
        	for(int v : cnt) {
        		result = Math.min(result, v);
        	}
        	sb.append("#").append(t).append(" ");
        	sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

}