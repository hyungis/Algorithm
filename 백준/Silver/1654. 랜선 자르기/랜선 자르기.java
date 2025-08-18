import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	static long max;
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[k];
        max = 0;
        for(int i = 0; i<k; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	if(arr[i] > max) {
        		max = arr[i];
        	}
        }
        max++;
        search();
        System.out.println(max-1);
        
        
        
        
    }
    public static void search() {
    	long min = 0;
    	
    	while(min < max) {
    		long count = 0;
    		long mid = (min+max)/2;
    		
    		for(int i = 0; i<k; i++) {
    			count += arr[i]/mid;
    		}
    		if(count<n) {
    			max = mid;
    		}else {
    			min = mid+1;
    		}
    	}
    }


}

