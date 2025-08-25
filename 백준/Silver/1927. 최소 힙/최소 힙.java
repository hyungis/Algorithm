import java.io.*;
import java.util.*;

public class Main {
	

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i<n; i++) {
        	int x = Integer.parseInt(br.readLine());
        	if(x == 0){
        		if(!q.isEmpty()) sb.append(q.poll()).append('\n');
        		else sb.append(0).append('\n');
        	}else {
        		q.add(x);
        	}
        }
        System.out.println(sb);
    }

    
}

