import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int lengh = Integer.parseInt(st.nextToken());
    		
    		int[] arr = new int[n];
    		st = new StringTokenizer(br.readLine());
    		
    		for(int i = 0; i<n; i++) {
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		Arrays.sort(arr);
    		
    		for(int i = 0; i<n; i++) {
    			if(arr[i] <= lengh) {
    				lengh++;
    			}
    		}
    		System.out.println(lengh);
    		
    }
    
    
}
