import java.util.*;

class Solution {
    
    int answer = 0;
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle){
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int i = x1; i<=x2; i++){
                for(int j = y1; j<=y2; j++){
                    map[i][j] = 1;
                }
            }
        }
        
        for(int[] rect : rectangle){
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for(int i = x1 + 1; i<x2; i++){
                for(int j = y1 + 1; j<y2; j++){
                    map[i][j] = 0;
                }
            }
        }
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer/2;
        
        
    }
    
    public void bfs(int x, int y, int targetX, int targetY){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int now_x = now[0];
            int now_y = now[1];
            int cnt = now[2];
            
            if(now_x == targetX && now_y == targetY){
                answer = cnt;
                return;
            }
            
            for(int i = 0; i<4; i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                
                if(nx < 0 || nx >= 101 || ny < 0 || ny >= 101 || visited[nx][ny] || map[nx][ny] == 0) continue;
                
                q.add(new int[]{nx, ny, cnt+1});
                visited[nx][ny] = true;
            }
        }
    }
    
}