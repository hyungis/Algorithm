import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		for(int i = 0; i<s.length(); i++) {
			list.add(s.charAt(i));
		}
		
		ListIterator<Character> iter = list.listIterator(list.size());
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			if(a.equals("P")) {
				iter.add(st.nextToken().charAt(0));
			}else if(a.equals("L")) {
				if(iter.hasPrevious()) {
					iter.previous();
				}
			}else if(a.equals("D")) {
				if(iter.hasNext()) {
					iter.next();
				}
			}else if(a.equals("B")) {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char a: list) {
			sb.append(a);
		}
		System.out.println(sb);
		
		
		
		
	
		
	}
}
