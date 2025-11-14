import java.io.*;
import java.util.*;

public class Main {
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	String s = br.readLine();
    	Stack<Character> stack = new Stack<>();
    	
    	int result = 0;
    	
    	for(int i = 0; i<s.length(); i++) {
    		char c = s.charAt(i);
    		
    		if(c == '(') {
    			stack.add(c);
    		}
    		else {
    			if(s.charAt(i-1) == '(') {
    				stack.pop();
    				result += stack.size();
    			}
    			else {
    				result++;
					stack.pop();
    				
    			}
    		}
    	}
    	System.out.println(result);
    		
    }
    
    
}









