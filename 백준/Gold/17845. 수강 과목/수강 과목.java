import java.util.*;
import java.io.*;

public class Main {


	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] important = new int[k+1];
        int[] time = new int[k+1];
        int[][] result = new int[k+1][n+1];
        
        for(int i = 1; i<=k; i++) {
        	st = new StringTokenizer(br.readLine());
        	important[i] = Integer.parseInt(st.nextToken());
        	time[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i<=k; i++) {
        	int n_imp = important[i];
        	int n_time = time[i];
        	
        	for(int j = 1; j<=n; j++) {
        		if(n_time > j) {
        			result[i][j] = result[i-1][j];
        		}else {
        			result[i][j] = Math.max(result[i-1][j], result[i-1][j-n_time] + n_imp);
        		}
        	}
        }
        System.out.println(result[k][n]);
        

    }
    

}