import java.io.*;
import java.util.*;

public class Main {

	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
			map = new HashMap<>();
			
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				
				if(a.equals("I")) {
					max.add(b);
					min.add(b);
					map.put(b, map.getOrDefault(b, 0) + 1);
				}else {
					if(map.size() == 0) continue;
					if(b == 1) {
						delete(max);
					}else {
						delete(min);
					}
				}
				
			}
			
			if(map.size() == 0) {
				sb.append("EMPTY").append('\n');
			}else {
				int res = delete(max);
				sb.append(res+" ");
				if(map.size() > 0) res = delete(min);
				sb.append(res).append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
	static int delete(PriorityQueue<Integer> q) {
		int res = 0;
		
		while(true) {
			res = q.poll();
			int cnt = map.getOrDefault(res, 0);
			if(cnt == 0) continue;
			
			if(cnt == 1) map.remove(res);
			else map.put(res, cnt-1);
			break;
		}
		return res;
	}
}
