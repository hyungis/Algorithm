import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i<priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
        }
        
        int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean isTrue = false;
            
            for(int i = 0; i<q.size(); i++){
                int[] next = q.poll();
                if(cur[1] < next[1]){
                    isTrue = true;
                }
                q.add(next);
            }
            
            if(!isTrue){
                cnt++;
                if(cur[0] == location){
                    break;
                }
            }else{
                q.add(cur);
            }
        }
        
        return cnt;
        
    }
}