import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
        	sb.append("#").append(t).append(" ");
        	int N = Integer.parseInt(br.readLine());
        	int M = Integer.parseInt(br.readLine());

        	boolean[][] arr = new boolean[N+1][N+1];
        	
        	for(int i = 0; i<M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		arr[a][b] = true;
        	}
        	
        	for(int k = 1; k<=N; k++) {
        		for(int i = 1; i<=N; i++) {
        			for(int j = 1; j<=N; j++) {
        				if(arr[i][k] && arr[k][j])
        					arr[i][j] = true;
        			}
        		}
        	}
        	
        	int[] cnt = new int[N+1];
        	for(int i = 1; i<=N; i++) {
        		for(int j = 1; j<=N; j++) {
        			if(arr[i][j] || arr[j][i]) {
        				cnt[i]++;
        			}
        		}
        	}
        	int result = 0;
        	for(int i = 1; i<=N; i++) {
        		if(cnt[i] == N-1) {
        			result++;
        		}
        	}
        	sb.append(result).append('\n');
        }
        System.out.println(sb);

    }

}