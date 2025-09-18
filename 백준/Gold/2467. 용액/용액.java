import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int L = 0, R = N - 1;
        int rNum = 0, lNum = 0, ans = Integer.MAX_VALUE;
        
        while (L < R) {
        	int sum = arr[L] + arr[R];
        	
        	if (ans >= Math.abs(sum)) {
        		lNum = arr[L];
        		rNum = arr[R];
        		ans = Math.abs(sum);
        	}
        	//양수면 오른쪽 --
        	//음수면 왼쪽++
        	if (sum > 0) {
        		R--;
        	} else if (sum < 0) {
        		L++;
        	} else {
        		R--;
        		L++;
        	}
        }
        
        System.out.print(lNum + " " + rNum);
    }
}
