import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] num;
	static int k;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
        	sb = new StringBuilder();
        	arr = new int[6];
        	st = new StringTokenizer(br.readLine());
        	k = Integer.parseInt(st.nextToken());
        	if(k == 0) break;
        	num = new int[k];
        	for(int i = 0; i<k; i++) {
        		num[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	dfs(0, 0);
        	System.out.println(sb);
        	
        }
    }
    public static void dfs(int cnt, int start) {
    	if(cnt == 6) {
    		for(int i = 0; i<arr.length; i++) {
    			sb.append(arr[i]).append(" ");
    		}
    		sb.append('\n');
    		return;
    	}
    	
    	for(int i = start; i<k; i++) {
    		arr[cnt] = num[i];
    		dfs(cnt+1, i+1);
    	}
    }
}
