import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			if(s.equals(".")) break;
			
			for(int i = 0; i<s.length(); i++) {
				char c = s.charAt(i);
				if(c == '(' || c == '[') {
					stack.push(c);
				}else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {
						stack.push(c);
					}
				}else if(c == ']') {
					if(!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					}else {
						stack.push(c);
					}
				}
			}
			if(stack.isEmpty()) {
				sb.append("yes").append('\n');
			}else {
				sb.append("no").append('\n');
			}
		}
		
		System.out.println(sb);
		
		
		
		
		
		
	}

}