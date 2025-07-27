import java.util.Deque;
import java.util.ArrayDeque;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Deque<Integer> d = new ArrayDeque<>();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("<");
		for(int i = 1; i <= n; i++) {
			d.add(i);
		}
		while(!d.isEmpty()) {
			for(int i=0; i<k; i++) {
				d.add(d.poll());
			}
			if(d.size() == 1) {
				sb.append(d.pollLast());
			} else sb.append(d.pollLast()).append(", ");
			
		}
		sb.append(">");
		System.out.println(sb);
	}

}
