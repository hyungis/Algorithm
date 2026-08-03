import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i<progresses.length; i++){
            q.add(new int[]{progresses[i], speeds[i]});
        }
        
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] work = q.poll();
                q.add(new int[]{work[0]+work[1], work[1]});
            }
            
            int cnt = 0;
            while(!q.isEmpty() && q.peekFirst()[0] >= 100){
                q.poll();
                cnt++;
            }
            
            if(cnt > 0){
                list.add(cnt);
            }
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}