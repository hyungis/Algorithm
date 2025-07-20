import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = N;
		
		for (int i = 0; i < N; i++) {
			boolean[] arr = new boolean[26];
			String s = sc.next();
			arr[s.charAt(0) - 'a'] = true;
			for (int j = 1; j < s.length(); j++){
				char c = s.charAt(j);
				
				if (c==s.charAt(j-1)) {
					continue;
				}
				
				if (arr[c-'a']) {
					result--;
					break;
				}
				arr[c-'a'] = true;
			}
		}
		System.out.println(result);
	}
}
