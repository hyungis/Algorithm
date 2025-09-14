import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
			        return o1 - o2; 
			    }
			    return Math.abs(o1) - Math.abs(o2);
			}
			
		});
		
		for(int i = 0 ; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					sb.append(pq.poll()).append('\n');
				}
			}else {
				pq.add(x);
			}
			
		}
		System.out.println(sb);
		
	}
	

}
