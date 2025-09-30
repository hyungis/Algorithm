import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static ArrayList<Integer>[] nodes;
    static int[] arr;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N + 1];
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());

            nodes[s].add(e);
            arr[e]++;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            sb.append(cur).append(" ");
            for (int n : nodes[cur]) {
                if (--arr[n] == 0) {
                    queue.add(n);
                }
            }
        }

        System.out.println(sb);
    }
}