import java.util.Queue;
import java.util.LinkedList;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<>();
		int last = 0;
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				q.add(last);
				
			} else if (s.equals("pop")) {
				if(!q.isEmpty()) System.out.println(q.poll());
				else System.out.println(-1);
			} else if (s.equals("size")) {
				System.out.println(q.size());
			} else if (s.equals("empty")) {
				if (q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if (s.equals("front")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			} else if (s.equals("back")) {
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(last);
			}
		}
		
		
		
	}

}
