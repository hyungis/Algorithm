import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] minDp = new int[3];
        int[] maxDp = new int[3];
        int[] tempMin = new int[3];
        int[] tempMax = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            minDp[j] = maxDp[j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tempMin[0] = a + Math.min(minDp[0], minDp[1]);
            tempMin[1] = b + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
            tempMin[2] = c + Math.min(minDp[1], minDp[2]);

            tempMax[0] = a + Math.max(maxDp[0], maxDp[1]);
            tempMax[1] = b + Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
            tempMax[2] = c + Math.max(maxDp[1], maxDp[2]);

            minDp[0] = tempMin[0];
            minDp[1] = tempMin[1];
            minDp[2] = tempMin[2];

            maxDp[0] = tempMax[0];
            maxDp[1] = tempMax[1];
            maxDp[2] = tempMax[2];
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        System.out.println(max + " " + min);
    }
}
