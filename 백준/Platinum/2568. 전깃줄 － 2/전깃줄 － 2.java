import java.io.*;
import java.util.*;

class Wire {
	int s, e, len;

	public Wire(int s, int e) {
		super();
		this.s = s;
		this.e = e;
	}
	@Override
    public String toString() {
        return "(" + s + ", " + e + ", " + len + ")";
    }
}
public class Main {
	static int N;
	static Wire[] arr;
	static Wire[] lis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new Wire[N];
		lis = new Wire[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[i] = new Wire(s, e);
		}
		
		Arrays.sort(arr, (n1, n2) -> {
			return n1.s - n2.s;
		});
		
		int len = 0;
		lis[0] = new Wire(0, 0);
		for (int i = 0; i < N; i++) {
			if (arr[i].e > lis[len].e) {
				lis[++len] = arr[i];
				arr[i].len = len;
			} else {
				int index = binarySearch(0, len, arr[i].e);
				lis[index] = arr[i];
				arr[i].len = index;
			}
		}
		
		System.out.println(N - len);
		Stack<Integer> s = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (len == arr[i].len) {
				len--;
			} else {
				s.add(arr[i].s);
			}
		}
		
		while (!s.isEmpty()) {
			sb.append(s.pop()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int binarySearch(int L, int R, int V) {
		int mid = 0;
		
		while (L < R) {
			mid = (L + R) / 2;
			
			if (lis[mid].e < V) {
				L = mid + 1;
			} else {
				R = mid;
			}
		}
		
		return R;
	}
}
