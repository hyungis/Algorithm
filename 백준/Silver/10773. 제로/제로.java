import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int result = 0;
		
		for(int i = 0; i<k; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				stack.pop();
			} else stack.push(x);
		}
		
		for(int v : stack) {
			result += v;
		}
		
		System.out.println(result);
		
	}

}
