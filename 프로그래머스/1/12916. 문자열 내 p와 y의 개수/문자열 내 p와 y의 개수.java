class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int sum_p = 0;
        int sum_y = 0;
        
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == 'p'){
                sum_p++;
            }else if(str.charAt(i) == 'y'){
                sum_y++;
            }
        }
        return sum_p == sum_y;
    }
}