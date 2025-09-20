import java.io.*;
import java.util.*;

public class Main {

	static int N, r, c;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int maxsize = (int) Math.pow(2, N);
		
		func(r, c, maxsize, 0);
		System.out.println(result);

	}
	static void func(int r, int c, int maxsize, int cnt) {
		if(maxsize == 1) {
			result = cnt;
			return;
		}
		
		int half = maxsize/2;
		if(r < half && c < half) {
			func(r, c, half, cnt);
		}
		else if(r < half && c >= half) {
			func(r, c-half, half, cnt+(half*half));
		}
		else if(r >= half && c < half) {
			func(r-half, c, half, cnt+((half*half)*2));
		}
		else if( r >= half && c >= half) {
			func(r-half, c-half, half, cnt+((half*half)*3));
		}
	}
	
}
