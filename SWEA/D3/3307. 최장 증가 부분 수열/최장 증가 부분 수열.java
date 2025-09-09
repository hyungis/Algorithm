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
        	int n = Integer.parseInt(br.readLine());
        	
        	int[] arr = new int[n];
        	int[] lis = new int[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	lis[0] = 1;
        	
        	for(int i = 1; i<n; i++) {
        		lis[i] = 1;
        		for(int j = 0; j<i; j++) {
        			if(arr[i] > arr[j]) {
        				lis[i] = Math.max(lis[i], lis[j]+1);
        			}
        		}
        	}
        	int max = -1;
        	for(int v : lis) {
        		max = Math.max(max, v);
        	}
        	sb.append(max).append('\n');
        }
        System.out.println(sb);
	}

}
