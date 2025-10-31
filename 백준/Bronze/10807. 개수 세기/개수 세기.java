import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		int n = Integer.parseInt(br.readLine());
    		int[] arr = new int[n];
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i<n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		int target = Integer.parseInt(br.readLine());
    		int result = 0;
    		for(int v : arr) {
    			if(v == target) {
    				result++;
    			}
    		}
    		System.out.println(result);
    		
    }
    
    
}









