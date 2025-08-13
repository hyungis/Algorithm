import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static int[] weights;
    static int A;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for(int t= 1; t<=T; t++) {
    		n = Integer.parseInt(br.readLine());
    		weights = new int[n];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i<n; i++) {
    			weights[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		A = 0;
    		permBit(0, 0, 0, 0);
    		
    		
    		sb.append("#").append(t).append(" ").append(A).append("\n");
    		
    	}
    	System.out.println(sb);
    	
    
    
    
    	
    }
	private static void permBit(int nth, int status, int sumL, int sumR) {
		// 3. 가지 치기
		if(sumL < sumR) {
			return;
		}
		
		// 2. 기저 상황
		if(nth == n) {
			A++;
			return;
		}
		
		
		// 1. 재귀 상황
		for(int i = 0; i<n; i++) {
			if( (status & 1<<i) == 0) {
//				visited[i] = true;
				permBit(nth+1, status | 1 << i, sumL + weights[i], sumR);
				permBit(nth+1, status | 1 << i, sumL, sumR + weights[i]);
				
//				visited[i] = false;
			}
		}
	}
   
}
