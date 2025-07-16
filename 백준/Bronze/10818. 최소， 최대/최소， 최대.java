import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 1000001;
		int max = -1000001;
		
		for (int i = 0; i<N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if (value < min) {
				min = value;
			}
			if (value > max) {
				max = value;
			}
		}
		System.out.println(min+" "+max);
	}
}
