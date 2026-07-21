import java.util.*;

class Solution {
    public ArrayList<Integer>[] list;
    public boolean[] visited;
    public int min;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n+1];
        min = Integer.MAX_VALUE;
        
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1];
            list[x].add(y);
            list[y].add(x);
        }
        
        for(int i = 0; i<wires.length; i++){
            int cutA = wires[i][0];
            int cutB = wires[i][1];
            
            visited = new boolean[n+1];
            int cnt = dfs(1, cutA, cutB);
            int other = n-cnt;
            int diff = Math.abs(cnt-other);
            min = Math.min(min, diff);
            
        }
        
        return min;
    }
    
    public int dfs(int start, int cutA, int cutB){
        visited[start] = true;
        int count = 1;
        
        for(int next: list[start]){
            if(start == cutA && next == cutB || start == cutB && next == cutA) continue;
            if(!visited[next]){
                count += dfs(next, cutA, cutB);
            }
        }
        
        return count;
    }
}