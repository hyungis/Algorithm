//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//
//public class Main {
//	
//	static ArrayList<Integer>[] arr;
//	static boolean[] check;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());
//		StringTokenizer st;
//		
//		arr = new ArrayList[n+1];
//		check = new boolean[n+1];
//		
//		for(int i = 0; i<arr.length; i++) {
//			arr[i] = new ArrayList<>();
//		}
//		
//		for(int i = 0; i<m; i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			arr[a].add(b);
//			arr[b].add(a);
//		}
//		
//		bfs(0, 1);
//		
//		int result = 0;
//		for(int i = 2; i<check.length; i++) {
//			if (check[i]) result++;
//		}
//		System.out.println(result);
//		
//	}
//	public static void bfs(int depth, int start) {
//		Queue<Integer> q = new ArrayDeque<>();
//		q.offer(start);
//		
//		while(!q.isEmpty()) {
//			if (depth == 3) break;
//			int now = q.poll();
//			for(int v: arr[now]) {
//				if(check[v]== false) {
//					check[v] = true;
//					q.offer(v);
//				}
//			}
//			depth++;
//		}
//	}
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        arr = new ArrayList[n+1];
        check = new boolean[n+1];
        
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            arr[a].add(b);
            arr[b].add(a);
        }
        
        bfs(1);  // start from 상근이 = 1
        
        int result = 0;
        for (int i = 2; i <= n; i++) {  // i = 1 (상근이) 제외
            if (check[i]) result++;
        }
        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        check[start] = true;

        int depth = 0;

        while (!q.isEmpty() && depth < 2) {  // depth 0 -> 친구, depth 1 -> 친구의 친구
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                for (int next : arr[now]) {
                    if (!check[next]) {
                        check[next] = true;
                        q.offer(next);
                    }
                }
            }
            depth++;
        }
    }
}
