import java.io.*;
import java.util.*;

public class Main {
    
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());

    	long result = pow(a, b, c);
    	System.out.println(result);
    }
    
    static long pow(int a, int b, int c) {
    	if(b == 1) {
    		return a % c;
    	}
    	
    	long temp = pow(a, b/2, c);
    	
    	if(b % 2 == 0) {
    		return temp*temp % c;
    	}
    	else {
    		return ((temp*temp)%c * (a%c))%c;
    	}
    	
    }
    
}









