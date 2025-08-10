import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static boolean[] selected;
    static boolean[][] bad;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int testcase = 1; testcase <= tc; testcase++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            selected = new boolean[n + 1];
            bad = new boolean[n + 1][n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bad[a][b] = true;
                bad[b][a] = true;
            }

            count = 0;
            dfs(1);
            System.out.println("#" + testcase + " " + count);
        }
    }

    static void dfs(int idx) {
        if (idx > n) {
        	for(int i = 1; i<=n; i++) {
        		if(!selected[i])continue;
        		for(int j = i + 1; j<= n; j++) {
        			if(selected[j] && bad[i][j]) {
        				return;
        			}
        		}
        	}
            count++;
            return;
        }
        
        selected[idx] = true;
        dfs(idx + 1);
        
        selected[idx] = false;
        dfs(idx + 1);
    }
}
