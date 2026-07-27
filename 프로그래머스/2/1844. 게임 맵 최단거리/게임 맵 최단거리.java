import java.util.*;

class Solution {
    
    public int[] dx = new int[]{1, -1, 0, 0};
    public int[] dy = new int[]{0, 0, 1, -1};
    public boolean[][] visited;
    public int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        int answer = bfs(0, 0, maps);
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int now_count = now[2];
            
            if(now_x == n-1 && now_y == m-1){
                return now_count;
            }
            
            for(int i = 0; i<4; i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                q.add(new int[]{nx, ny, now_count+1});
                visited[nx][ny] = true;
                
            }
        }
        
        return -1;
    }
}