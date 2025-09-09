import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		
		int idx = 0;
		for(int i = 1; i<n; i++) {
			if(arr[i] > dp[idx]) {
				dp[++idx] = arr[i];
			}else {
				int ii = binarysearch(dp, idx, arr[i]);
				dp[ii] = arr[i];
			}
		}
		System.out.println(arr.length-(idx+1));
		
	}
	static int binarysearch(int[] dp, int end, int n) {
		int start = 0;
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(dp[mid] >= n) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return end;
	}
	
}