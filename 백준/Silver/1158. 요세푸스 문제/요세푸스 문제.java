import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringTokenizer st;
    		StringBuilder sb = new StringBuilder();
    		
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int k = Integer.parseInt(st.nextToken());
    		
    		LinkedList<Integer> list = new LinkedList<Integer>();
    		for(int i = 1; i<=n; i++) {
    			list.add(i);
    		}
    		
    		sb.append("<");
    		int index = 0;
    		while(!list.isEmpty()) {
    			index = (index + k -1) % list.size();
    			sb.append(list.remove(index));
    			if(!list.isEmpty()) {
    				sb.append(", ");
    			}
    		}
    		sb.append(">");
    		System.out.println(sb);
    		
    }
    
    
}









