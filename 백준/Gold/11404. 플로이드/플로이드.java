import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	if(map[a-1][b-1] != 0) {
        		map[a-1][b-1] = Math.min(map[a-1][b-1], c);
        	}else {
        		map[a-1][b-1] = c;
        	}
        	
        }
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		if(map[i][j] == 0 && i != j) {
        			map[i][j] = 987654321;
        		}
        	}
        }
        
        for(int k = 0; k<n; k++) {
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<n; j++) {
        			map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
        		}
        	}
        }
        for(int i = 0; i<n; i++) {
        	for(int j = 0; j<n; j++) {
        		if(map[i][j] == 987654321) {
        			System.out.print( 0 +" ");
        		}else {
        			System.out.print(map[i][j] + " ");
        		}
        	}
        	System.out.println();
        }
    }

}