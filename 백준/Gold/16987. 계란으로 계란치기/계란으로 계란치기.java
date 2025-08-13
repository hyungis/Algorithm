import java.io.*;
import java.util.*;

public class Main {
	
	static int n, cnt;
	static int[][] egg;
	static int max;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	egg = new int[n][2];
    	for(int i = 0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		egg[i][0] = Integer.parseInt(st.nextToken());
    		egg[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	dfs(0, 0);
    	System.out.println(max);
    
    	
    }
	public static void dfs(int now, int cnt) {
		if(now == n || cnt == n-1) {
			max = Math.max(max, cnt);
			return;
		}
		
		if(egg[now][0] <= 0) {
			dfs(now+1, cnt);
		}else {
			for(int i = 0; i<n; i++) {
				if(now == i)continue;
				
				if(egg[i][0] > 0) {
					egg[now][0] -= egg[i][1];
					egg[i][0] -= egg[now][1];
					if(egg[now][0] <= 0 && egg[i][0] <= 0) { // 두개 다 깨졌을 때
						dfs(now+1, cnt + 2);
					}else if(egg[now][0] > 0 && egg[i][0] > 0) { //두개 다 안깨졌을 때
						dfs(now+1, cnt);
					}else {
						dfs(now+1, cnt + 1);
					}
					egg[now][0] += egg[i][1];
					egg[i][0] += egg[now][1];
				}
			}
		}
	}
   
}
