class Solution {
    public String solution(String s) {
        String answer = "";
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += " ";
            }
            else{
                if(answer.length() == 0 || answer.charAt(answer.length()-1) == ' '){
                    answer += Character.toUpperCase(s.charAt(i));
                }else{
                    answer += Character.toLowerCase(s.charAt(i));    
                }
                
            }
        }
        return answer;
    }
}