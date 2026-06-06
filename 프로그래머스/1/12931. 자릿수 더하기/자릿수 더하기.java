import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        for(int i = 0; i<s.length(); i++){
            int c = s.charAt(i) - '0';
            answer += c;
            System.out.println(answer);
        }

        return answer;
    }
}