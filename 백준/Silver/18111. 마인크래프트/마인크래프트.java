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
        int b = Integer.parseInt(st.nextToken());
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[][] map = new int[n][m];
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j<m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] > max) max = map[i][j];
        		if(map[i][j] < min) min = map[i][j];
        	}
        }
        int result = Integer.MAX_VALUE;
        int height = 0;
        
        for(int target = min; target<=max; target++) {
        	int time = 0;
        	int block = b;
        	for(int i = 0; i<n; i++) {
        		for(int j = 0; j<m; j++) {
        			//map의 값이 target보다 작을때
        			if(map[i][j] < target) {
        				int diff = target-map[i][j];
        				block -= diff;
        				time += diff;
        			}else if(map[i][j] > target) {
        				int diff = map[i][j] - target;
        				block += diff;
        				time += diff*2;
        			}
        		}
        	}
        	if(block < 0) continue;
        	if(time <= result) {
        		result = time;
        		height = target;
        	}
        	
        }
        if(result == Integer.MAX_VALUE) {
        	result = 0;
        	height = max;
        }
        System.out.println(result+ " " + height);
	}

}
