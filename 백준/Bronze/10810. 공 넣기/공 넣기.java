import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N+1];
		
		for (int i=0; i<M; i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			int c =sc.nextInt();
			for(int j=a ; j<=b; j++) {
				arr[j] = c;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=1 ; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
