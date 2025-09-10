import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	map[a][b] = 1;
        }
        for(int i = 1; i<=n; i++) {
        	for(int j = 1; j<=n; j++) {
        		if(map[i][j] == 0 && i!=j) {
        			map[i][j] = 987654321; 
        		}
        	}
        }
        
        for(int k = 1; k<=n; k++) {
        	for(int i = 1; i<=n; i++) {
        		for(int j = 1; j<=n; j++) {
        			map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        		}
        	}
        }
        
        int s = Integer.parseInt(br.readLine());
        for(int i = 0; i<s; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if(map[a][b] != 987654321) {
        		sb.append(-1).append('\n');
        	} 
        	else if(map[b][a] != 987654321) {
        		sb.append(1).append('\n');
        	}
        	else if(map[a][b] == 987654321) {
        		sb.append(0).append('\n');
        	}
        	
        }
        System.out.println(sb);

    }

}