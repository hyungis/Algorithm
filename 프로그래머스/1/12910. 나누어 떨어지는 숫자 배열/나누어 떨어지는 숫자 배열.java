import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr){
            if(x % divisor == 0){
                list.add(x);
            }
        }
        Collections.sort(list);
        if(list.size() == 0){
            return new int[]{-1};
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}