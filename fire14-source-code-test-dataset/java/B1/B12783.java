import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Anirban
 */
public class RecycledNumbers {
    public static boolean check(String n, String m, int len){
        for(int i = 0; i < len; i++){
            if(m.compareTo(n.substring(i, i + len)) == 0)
                return true;
        }
        return false;
    }

    public static void main(String [] args)throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        int tc = 1;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            for(int i = A; i <= B; i++){
                for(int j = i + 1; j <= B; j++){
                    String n = i + "" ;
                    int len = n.length();
                    n += n;
                    String m = j + "";
                    if(check(n, m, len))
                        count++;
                }
            }
            System.out.printf("Case #%d: %d", tc, count);
            System.out.println();
			tc++;
        }
    }
}
