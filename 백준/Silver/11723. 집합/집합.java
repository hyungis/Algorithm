import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<Integer> set = new HashSet<>();
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
			case "add":{
				set.add(Integer.parseInt(st.nextToken()));
				break;
			}
			case "remove":{
				set.remove(Integer.parseInt(st.nextToken()));
				break;
			}
			case "check":{
				if(set.contains(Integer.parseInt(st.nextToken()))){
					sb.append(1).append('\n');
					break;
				}else {
					sb.append(0).append('\n');
					break;
				}
			}
			case "toggle":{
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					set.remove(x);
					break;
				}else {
					set.add(x);
					break;
				}
			}
			case "all":{
				for(int j = 1; j<=20; j++) {
					set.add(j);
				}
				break;
			}
			case "empty":{
				set.clear();
				break;
			}
			
			}
		}
		
		System.out.println(sb);
		
		
	}

}