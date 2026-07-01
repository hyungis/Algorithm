class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        String answer = "";
        for(String s: seoul){
            if(s.equals("Kim")){
                answer = "김서방은 "+idx+"에 있다";
            }
            idx++;
        }
        return answer;
    }
}