import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            int x = command[0];
            int y = command[1];
            int z = command[2];
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = x-1; i < y; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[idx] = list.get(z-1);
            idx++;
            System.out.print(list.get(z-1));
            
        }
        return answer;
    }
}