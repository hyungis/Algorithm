class Solution {
    public int solution(int[] citations) {
        for(int h = citations.length; h>= 0; h--){
            int cnt = 0;
            
            for(int citation: citations){
                if(citation >= h){
                    cnt++;
                }
            }
            
            if(cnt >= h){
                return h;
            }
        }
        return 0;
    }
}