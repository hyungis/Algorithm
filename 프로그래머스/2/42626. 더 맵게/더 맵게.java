import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int scv : scoville){
            minheap.add(scv);
        }
        
        while(minheap.peek() < K){
            
            if(minheap.size() < 2){
                return -1;
            }
            
            int first = minheap.poll();
            int second = minheap.poll();
            
            int next = first + second*2;
            minheap.add(next);
            answer++;
        }
        
        return answer;
    }
}