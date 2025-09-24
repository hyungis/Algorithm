import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int first = 0, last = 0, min = Integer.MAX_VALUE;
        Long sum = 0L;
        
        while (first < N) {
        	if (sum < M && last < N) {
        		sum += arr[last++];
        	} else if (sum >= M) {
        		min = Math.min(min, last - first);
        		sum -= arr[first++];
        	} else {
        		sum -= arr[first++];
        	}
        	
        	if (first > last) {
        		last = first;
        	}
        }
        
        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }
}

