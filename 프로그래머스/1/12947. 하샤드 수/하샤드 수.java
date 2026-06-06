class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        int n = 0;
        for(int i = 0; i<s.length(); i++){
            int c = s.charAt(i) - '0';
            n += c;
        }
        if(x % n != 0){
            answer = false;
        }
        return answer;
    }
}