import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static int result;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        arr = new int[101][101];
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	for(int j = x; j < x+10; j++) {
        		for(int k = y; k < y+10; k++) {
        			arr[j][k] = 1;
        		}
        	}
        }
        
        for(int i = 1; i<=100; i++) {
        	for(int j = 1; j<=100; j++) {
        		if(arr[i][j] == 1) {
        			check(i, j);
        		}
        	}
        }
        System.out.println(result);
    }
    static void check(int x, int y) {
    	int cnt = 0;
    	
    	for(int i = 0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
    		if(arr[nx][ny] == 0) cnt++;
    		
    	}
    	result += cnt;
    }

}

