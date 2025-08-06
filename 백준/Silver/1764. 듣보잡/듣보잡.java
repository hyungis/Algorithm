import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		for(int i = 0; i<m; i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String v : list) {
			System.out.println(v);
		}
		
		
		
	}

}