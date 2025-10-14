import java.io.*;
import java.util.*;

public class Main {
    
	static int n;
	
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		String s;
    		while((s = br.readLine()) != null) {
    			n = Integer.parseInt(s);
    			int size = (int) Math.pow(3, n);
    			
    			char[] arr = new char[size];
    			for(int i = 0; i<size; i++) {
    				arr[i] = '-';
    			}
    			
    			dfs(0, size, arr);
    			for(char v : arr) {
    				sb.append(v);
    			}
    			sb.append("\n");
    		}
    		System.out.println(sb);
    }
    static void dfs(int start, int len, char[] arr) {
    	if(len == 1) return;
    	
    	len = len / 3;
    	
    	for(int i = start+len; i < start + 2*len; i++) {
    		arr[i] = ' ';
    	}
    	dfs(start, len, arr);
    	dfs(start+2*len, len, arr);
    }
    
    
}









