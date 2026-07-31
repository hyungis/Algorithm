import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<String> route;
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        visited = new boolean[tickets.length];
        route = new ArrayList<>();
        
        route.add("ICN");
        dfs(tickets, "ICN", 0);
        return answer;
    }
    
    public void dfs(String[][] tickets, String current, int count){
        if(answer != null){
            return;
        }
        if(count == tickets.length){
            answer = route.toArray(new String[0]);
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(current)){
                visited[i] = true;
                route.add(tickets[i][1]);
                
                dfs(tickets, tickets[i][1], count+1);
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }
        
        
    }
}