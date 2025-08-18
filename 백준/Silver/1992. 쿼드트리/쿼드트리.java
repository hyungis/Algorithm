import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static String answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i<n; i++) {
            String s = br.readLine();
            for(int j = 0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(0, 0, n);
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y, int size) {
        int target = arr[x][y];
        boolean result = true;

        for(int i = x, xEnd = x+size; i < xEnd; i++) {
            for(int j = y, yEnd = y+size; j< yEnd; j++) {
                if(target != arr[i][j]) {
                	result = false;
                	break;
                }
            }
        }
        if(result) {
        	sb.append(target);
        	return;
        }
        
        sb.append("(");
        
        dfs(x, y, size/2);              // 왼쪽 위
        dfs(x, y+size/2, size/2);       // 오른쪽 위
        dfs(x+size/2, y, size/2);       // 왼쪽 아래
        dfs(x+size/2, y+size/2, size/2);// 오른쪽 아래
        
        sb.append(")");


    }


}

