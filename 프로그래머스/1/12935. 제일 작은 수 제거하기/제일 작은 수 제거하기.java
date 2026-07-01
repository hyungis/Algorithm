import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        if(arr.length == 1){
            list.add(-1);
        }else{
            for(int x : arr){
                if(x == min) continue;
                list.add(x);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}