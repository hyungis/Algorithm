import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int n,m;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	n = Integer.parseInt(br.readLine());
    	arr = new int[n];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	Arrays.sort(arr);
    	
    	m = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<m; i++) {
    		int a = Integer.parseInt(st.nextToken());
    		int result = binarySearch(a);
    		sb.append(result).append('\n');
    	}
    	System.out.println(sb);
    
	}
	public static int binarySearch(int x) {
		
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(x > arr[mid]) {
				start = mid+1;
			}else if(x < arr[mid]) {
				end = mid-1;
			}else {
				return 1;
			}
			
		}
		return 0;
	}
	
   
}
