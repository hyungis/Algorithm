import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int test = 0 ; test<t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(n%h == 0) {
				int x = h*100;
				int y = n/h;
				System.out.println(x+y);
			} else {
				int x = (n%h)*100;
				int y = (n/h + 1);
				System.out.println(x+y);
			}
			
			
			
			
			
		}
		
		
		
		
	}

}