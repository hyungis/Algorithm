import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i = 0; i<n; i++) {
			deque.add(Integer.parseInt(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 1; i<=n; i++) {
			stack.push(i);
			sb.append("+").append('\n');
			 
			while(!stack.isEmpty() && !deque.isEmpty() && stack.peek().equals(deque.peekFirst())) {
				deque.pollFirst();
				stack.pop();
				sb.append("-").append('\n');
			}
			
		}
		if(!stack.isEmpty()) System.out.println("NO");
		else System.out.println(sb);
		
	}

}