import java.util.*;

class Solution {
    
    public ArrayList<Integer>[] list;
    public boolean[] visited;
    public int answer = 0;
    
    public int solution(int n, int[][] computers) {
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    list[i+1].add(j+1);
                }
            }
        }
        
        
        for(int i = 1; i<=n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int current){
        visited[current] = true;
        
        for(int next : list[current]){
            if(!visited[next]){
                dfs(next);
            }
        }
        
    }
    
    
}