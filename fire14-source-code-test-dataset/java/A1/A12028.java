import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: andraz
 * Date: 14.4.12
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class Dancing {
    public static void main(String args[]) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int rep=0; rep<t; rep++) {
            String line[] = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int s = Integer.parseInt(line[1]);
            int p = Integer.parseInt(line[2]);
            int count = 0;
            for(int i=0; i< n; i++) {
                int total = Integer.parseInt(line[3+i]);
                if(total>=3*p - 2) {
                    count++;
                } else if ((total >= 3*p - 4) && (total>=p) && (s>0)) {
                    count++;
                    s--;
                }
            }
            System.out.printf("Case #%d: %d\n", rep+1, count);
        }

    }
}
