import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[] check;
	static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        check = new boolean[n+1];
        
        for(int i = 1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j<=n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i<=n; i++) {
        	check[i] = true;
        	dfs(i, i, 1, 0);
        }
        System.out.println(result);
        
    }
    static void dfs(int start, int now, int cnt, int sum) {
    	if(cnt == n && arr[now][start] != 0) {
    		result = Math.min(result, sum+arr[now][start]);
    		return;
    	}
    	
    	for(int i = 1; i<=n; i++) {
    		if(check[i] || arr[now][i] == 0) continue;
    		check[i] = true;
    		dfs(start, i, cnt+1, sum+arr[now][i]);
    		check[i] = false;
    	}
    	
    }

}

