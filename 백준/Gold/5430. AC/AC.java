import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			String p = br.readLine(); //함수
			int n = Integer.parseInt(br.readLine());
			String x = br.readLine();
			
			Deque<Integer> q = new ArrayDeque<>();
			if(x.length() > 2) {
				String[] split = x.substring(1, x.length()-1).split(",");
				for(int i = 0; i<split.length; i++) {
					q.add(Integer.parseInt(split[i]));
				}
			}

			//뒤집을지 아닐지 판단(짝수면 안뒤집고, 홀수면 뒤집기)
			boolean reverse = false;
			boolean isError = false;
			
			for(int i = 0; i<p.length(); i++) {
				char c = p.charAt(i);
				if(c == 'R') {
					if(!reverse) {
						reverse = true;
					}else {
						reverse = false;
					}
				}
				
				if(c == 'D') {
					if(q.size() == 0) {
						isError = true;
					}else {
						if(!reverse) {
							q.poll();
						}else {
							q.pollLast();
						}
					}
				}
			}
			
			if(isError) {
				sb.append("error").append('\n');
			}else {
				sb.append("[");
				if(q.isEmpty()) {
					sb.append("]").append('\n');
				}else {
					int size = q.size();
					if (!reverse) {
					    for (int i = 0; i < size; i++) {
					        if (i == size - 1) {
					            sb.append(q.poll());
					        } else {
					            sb.append(q.poll()).append(",");
					        }
					    }
					    sb.append("]").append('\n');
					} else {
					    for (int i = 0; i < size; i++) {
					        if (i == size - 1) {
					            sb.append(q.pollLast());
					        } else {
					            sb.append(q.pollLast()).append(",");
					        }
					    }
					    sb.append("]").append('\n');
					}
				}
			}
			
			
		}
	
		System.out.println(sb);
	}
		
}
