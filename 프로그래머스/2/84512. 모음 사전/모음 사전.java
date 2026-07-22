import java.util.*;

class Solution {
    public char[] list = new char[]{'A', 'E', 'I', 'O', 'U'};
    public ArrayList<String> words = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs("");
        
        
        return words.indexOf(word) + 1;
    }
    
    public void dfs(String str){
        if(str.length() == 5){
            return;
        }
        
        for(char c : list){
            String next = str + c;
            words.add(next);
            dfs(next);
        }
    }
}