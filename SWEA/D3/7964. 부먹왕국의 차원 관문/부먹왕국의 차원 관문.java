import java.io.*;
import java.util.*;

public class Solution {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	
        	int[] arr = new int[n];
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i<n; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int count = 0;
        	int result = 0;
        	for(int i = 0; i<n; i++) {
        		if(arr[i] == 0) {
        			count ++;
        		}else if(arr[i] ==1) {
        			count = 0;
        		}
        		
        		if(count == d) {
        			result++;
        			count = 0;
        		}
        	}
        	
        	sb.append("#").append(t).append(" ").append(result).append('\n');
        }
        System.out.println(sb);
        
    }


}

