import java.io.*;
import java.util.*;

public class Main {
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	String line = br.readLine();
    	Stack<Character> stack = new Stack<>();
    	
    	boolean isTrue = true;
    	int result = 0;
    	int cnt = 1;
    	for(int i = 0; i<line.length(); i++) {
    		char c = line.charAt(i);
    		if(c == '(') {
    			stack.push(c);
    			cnt *= 2;
    		}
    		else if(c == '[') {
    			stack.push(c);
    			cnt *= 3;
    		}
    		else {
    			if(c == ')') {
    				if(stack.empty() || stack.peek() != '(') {
    					isTrue = false;
    					break;
    				}
    				if(line.charAt(i-1) == '(') {
    					result += cnt;
    				}
    				stack.pop();
    				cnt /= 2;
    			}
    			
    			if(c == ']') {
    				if(stack.empty() || stack.peek() != '[') {
    					isTrue = false;
    					break;
    				}
    				if(line.charAt(i-1) == '[') {
    					result += cnt;
    				}
    				stack.pop();
    				cnt /= 3;
    			}
    		}

    	}
    	
    	if(!isTrue || !stack.isEmpty()) {
    		System.out.println(0);
    	}else {
    		System.out.println(result);
    	}
    		
    }
    
    
}









