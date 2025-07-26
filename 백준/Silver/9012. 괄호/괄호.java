import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<N; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean result = true;
			for(int j = 0; j<s.length(); j++) {
				char c = s.charAt(j);
				if (c == '(') {
					stack.push(c);
				} else {
					if (stack.empty()) {
						result = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (result && stack.empty()) {
				sb.append("YES").append('\n');
			} else {
				sb.append("NO").append('\n');
			}
		}
		
		System.out.println(sb);
		
		
		
	}

}
