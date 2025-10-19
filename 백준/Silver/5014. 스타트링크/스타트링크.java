import java.io.*;
import java.util.*;

public class Main {
    
	static int start, end, up, down, tall; //시작점, 도착점, 올라가는 경우, 내려가는 경우, 건물사이즈
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		tall = Integer.parseInt(st.nextToken());
    		start = Integer.parseInt(st.nextToken());
    		end = Integer.parseInt(st.nextToken());
    		up = Integer.parseInt(st.nextToken());
    		down = Integer.parseInt(st.nextToken());
    		visited = new boolean[tall+1];
    		
    		int result = bfs(start, 0);
    		
    		if(result == -1) {
    			System.out.println("use the stairs");
    		}else {
    			System.out.println(result);
    		}
    		
    }
    
    static int bfs(int start, int cnt) {
    		Queue<int[]> q = new ArrayDeque<>();
    		q.offer(new int[] {start, cnt});
    		visited[start] = true;
    		
    		while(!q.isEmpty()) {
    			int[] now = q.poll();
    			int nowfloor = now[0];
    			int nowcnt = now[1];
    			
    			if(nowfloor == end) return nowcnt;
    			
    			int upfloor = nowfloor+up;
    			int downfloor = nowfloor-down;
    			
    			if(upfloor <= tall && !visited[upfloor]) {
    				q.offer(new int[] {upfloor, nowcnt+1});
    				visited[upfloor] = true;
    			}
    			
    			if(downfloor >= 1 && !visited[downfloor]) {
    				q.offer(new int[] {downfloor, nowcnt+1});
    				visited[downfloor] = true;
    			}
    			
    			

    		}
    		
    		
    		return -1;
    }
    
    
}
