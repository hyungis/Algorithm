import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		
		for (String val: arr){
			if (s.contains(val)) {
				s = s.replace(val, "*");
			}
		}
		
		System.out.println(s.length());
		
	}
}
