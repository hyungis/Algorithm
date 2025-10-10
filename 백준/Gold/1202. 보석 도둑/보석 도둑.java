import java.io.*;
import java.util.*;

public class Main {

    static class Jewel{
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewels = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.m, o2.m)));
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        int[] knapsacks = new int[K];
        for(int i=0 ; i<K ; i++){
            knapsacks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(knapsacks);

        long sum = 0;

        PriorityQueue<Jewel> pq = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1.v, o2.v)));
        for(int i=0 ; i<K ; i++){
            while(!jewels.isEmpty() && jewels.peek().m <= knapsacks[i]){
                pq.offer(jewels.poll());
            }

            if(pq.isEmpty()) continue;
            sum += pq.poll().v;
        }

        System.out.println(sum);
    }

}