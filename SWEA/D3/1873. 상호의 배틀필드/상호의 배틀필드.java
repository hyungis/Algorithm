import java.io.*;
import java.util.*;

public class Solution {
	
	static int h, w, n, dir;
	static char[][] map;
	static int tankx, tanky;
	static int[] dx = {0, -1, 0, 1};    // < ^ > v 방향
	static int[] dy = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	h = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	map = new char[h][w];
        	dir = 0; tankx = 0; tanky = 0;
        	
        	for(int i = 0; i<h; i++) {
        		String s = br.readLine();
        		for(int j = 0; j<w; j++) {
        			map[i][j] = s.charAt(j);
        			if(map[i][j] == '<') {
        				dir = 0;
        				tankx = i; tanky = j;
        			}else if(map[i][j] == '^') {
        				dir = 1;
        				tankx = i; tanky = j;
        			}else if(map[i][j] == '>') {
        				dir = 2;
        				tankx = i; tanky = j;
        			}else if(map[i][j] == 'v') {
        				dir = 3;
        				tankx = i; tanky = j;
        			}
        		}
        	}

        	
        	n = Integer.parseInt(br.readLine());
        	String s = br.readLine();
        	for(int i = 0; i<n; i++) {
        		char c = s.charAt(i);
        		if(c == 'S') {
        			shoot();
        		}else {
        			move(c);
        		}
        	}
        	sb.append("#").append(t).append(" ");
        	for(int i = 0; i<h; i++) {
        		for(int j = 0; j<w; j++) {
        			sb.append(map[i][j]);
        		}
        		sb.append('\n');
        	}
        	
        }
        System.out.println(sb);
        
    }
    static void move(char c) {
    	char temp = ' ';
    	switch(c) {
    	case 'U': dir = 1; temp = '^'; break;
    	case 'D': dir = 3; temp = 'v'; break;
    	case 'L': dir = 0; temp = '<'; break;
    	case 'R': dir = 2; temp = '>'; break;
    	}
    	
    	map[tankx][tanky] = temp;
    	int nx = tankx + dx[dir];
    	int ny = tanky + dy[dir];
    	
    	if(nx < 0 || ny < 0 || nx >= h || ny >= w) return;
    	
    	if(map[nx][ny] == '.') {
    		map[nx][ny] = temp;
    		map[tankx][tanky] = '.';
    		tankx = nx; tanky = ny;
    	}
    }
    
    
    
    static void shoot() {
    	int nx = tankx + dx[dir];
    	int ny = tanky + dy[dir];
    	
    	while(true) {
    		if(nx < 0 || ny < 0 || nx >= h || ny >= w) break;
    		
    		if(map[nx][ny] == '*') {
    			map[nx][ny] = '.';
    			return;
    		}else if(map[nx][ny] == '#') {
    			return;
    		}
    		nx += dx[dir];
    		ny += dy[dir];
    	}
    }

    
}

