class Solution {
    
    public boolean[] visited;
    public int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String current, String target, String[] words, int cnt){
        if(current.equals(target)){
            answer = cnt;
            return;
        }
        
        for(int i = 0; i<words.length; i++){
            if(visited[i]) continue;
            
            if(canConvert(current, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
        
    }
    
    public boolean canConvert(String from, String to){
        int cnt = 0;
        for(int i = 0; i<from.length(); i++){
            if(from.charAt(i) == to.charAt(i)){
                cnt++;
            }
        }
        if(cnt == (from.length() -1)){
            return true;
        }
        else{
            return false;
        }
    }
}