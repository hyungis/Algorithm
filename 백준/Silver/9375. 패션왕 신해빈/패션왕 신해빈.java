import java.io.*;
import java.util.*;

public class Main {
	

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++) {
        	HashMap<String, Integer> map = new HashMap<>();
        	int n = Integer.parseInt(br.readLine());
        	for(int j = 0; j<n; j++) {
        		st = new StringTokenizer(br.readLine());
        		String s = st.nextToken();
        		String s2 = st.nextToken();
        		if(map.containsKey(s2)) {
        			map.put(s2, map.get(s2)+1);
        		}else {
        			map.put(s2, 1);
        		}
        	}
        	
        	if(map.size() == 1) {
        		sb.append(n).append('\n');
        	}else {
        		int result =1;
            	for(int v : map.values()) {
            		result *= (v+1);
            	}
            	sb.append(result-1).append('\n');
        	}
        	
        	
        }
        
        System.out.println(sb);

    }

    
}

