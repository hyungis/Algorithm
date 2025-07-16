import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int b = Integer.parseInt(br.readLine());
		
		for (int x: arr) {
			if (x == b) {
				count += 1;
			}
		}
		System.out.println(count);
		
	}
}
