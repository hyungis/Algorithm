import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int s = 0;
        int m = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	switch (str) {
        	case "add":{
        		s |= (1<<Integer.parseInt(st.nextToken()));
        		break;
        	}
        	case "remove":{
        		s &= ~(1<<Integer.parseInt(st.nextToken()));
        		break;
        	}
        	case "check":{
        		if( (s & (1<<Integer.parseInt(st.nextToken())) ) == 0){
        			sb.append(0).append('\n');
        			break;
        		}else {
        			sb.append(1).append('\n');
        			break;
        		}
        	}
        	case "toggle":{
        		s ^= (1<<Integer.parseInt(st.nextToken()));
        		break;
        		}
        	case "all":{
        		s = (1<<21)-1;
        		break;
        	}
        	case "empty":{
        		s = 0;
        		break;
        	}
        	}
        }
        System.out.println(sb);
        
        
    }
}
