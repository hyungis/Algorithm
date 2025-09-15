import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V, E;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        boolean[] visited = new boolean[V + 1];
        int[] minEdge = new int[V + 1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0)); // 시작 정점

        int result = 0, cnt = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.v]) continue;

            visited[cur.v] = true;
            result += cur.w;
            if (++cnt == V) break; // 모든 정점 방문 완료

            for (Edge next : graph[cur.v]) {
                if (!visited[next.v] && next.w < minEdge[next.v]) {
                    minEdge[next.v] = next.w;
                    pq.offer(new Edge(next.v, next.w));
                }
            }
        }

        System.out.println(result);
    }
}
