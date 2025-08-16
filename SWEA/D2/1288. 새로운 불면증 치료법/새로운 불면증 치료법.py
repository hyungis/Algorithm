import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] arr;
	static int n,m;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int t=1; t<=T; t++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		int mask = 0;
    		int target = (1<<10) -1;
    		int result = 0;
    		
    		int k = 0;
    		while(mask != target) {
    			k++;
    			int num = n*k;
    			while(num>0) {
    				mask |= 1 << (num%10);
    				num /= 10;
    			}
    		}
    		result = n*k;
    		
    		sb.append("#").append(t).append(" ").append(result).append('\n');
    	}
    	System.out.println(sb);
    	
    	
    	
	}
	
	
   
}
