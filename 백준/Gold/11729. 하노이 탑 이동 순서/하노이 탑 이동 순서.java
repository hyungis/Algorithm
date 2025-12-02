import java.io.*;
import java.util.*;

public class Main {
    
	public static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	hanoi(1, 2, 3, n);
    	System.out.println(count);
    	System.out.println(sb);
    }
    
    static void hanoi(int from, int m, int to, int n) {
    	if(n == 0) return;
    	
    	count++;
    	hanoi(from, to, m, n-1);
    	sb.append(from+" "+to+'\n');
    	hanoi(m, from, to, n-1);
    }
    
    
}









