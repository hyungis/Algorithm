import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (s.charAt(i-1) == '(') {
					stack.pop();
					result += stack.size();
				} else {
					result += 1;
					stack.pop();
				}
			}
		}
		System.out.println(result);
		
	}

}
