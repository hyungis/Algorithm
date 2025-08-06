import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, String> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=n; i++) {
			String s = br.readLine();
			map.put(i, s);
			map2.put(s, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<m; i++) {
			String str = br.readLine();
			if(str.charAt(0) - 'A' >= 0) {
				sb.append(map2.get(str)).append('\n');
			}else {
				sb.append(map.get(Integer.parseInt(str))).append('\n');
			}
		}
		System.out.println(sb);
		
		
	}

}