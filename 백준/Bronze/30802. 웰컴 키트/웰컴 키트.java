import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[6];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i< arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int v: arr) {
			if(v == 0) {
				continue;
			} else {
				cnt += (v+t-1)/t;
			}
		}
		
		
		
		
		
		System.out.println(cnt);
		System.out.println(n/p + " " + n%p);
			
		
		
		
	}

}