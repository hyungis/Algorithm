import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int n, s;
	static int[] num;
	static int sum = 0;
	static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        if(s == 0) result--;
        
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, sum);
        System.out.println(result);
        
    }
    public static void dfs(int cnt, int sum) {
    	if (cnt == n) {
    		if(sum == s) {
    			result++;
    		}
    		return;
    	}
    	
    	dfs(cnt+1, sum+num[cnt]);
    	dfs(cnt+1, sum);
    }
}
