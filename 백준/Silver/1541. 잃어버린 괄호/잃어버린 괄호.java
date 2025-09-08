import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
        String[] s = br.readLine().split("-");
        int temp = 0;
        
        for(int i = 0; i<s.length; i++) {
        	
        	int sum = 0;
        	String[] cur = s[i].split("\\+");
        	for(int j = 0; j<cur.length; j++) {
        		sum += Integer.parseInt(cur[j]);
        	}
        	
        	if(i == 0) {
        		temp = sum;
        	}else {
        		temp -= sum;
        	}
        	
        }
        System.out.println(temp);
	}

}
