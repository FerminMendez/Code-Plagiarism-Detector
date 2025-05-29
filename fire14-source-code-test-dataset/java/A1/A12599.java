import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    
    public static void main(String[] args) {
try{
        int no, i, valuemax, surprise, p, n, j, temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       no = Integer.parseInt(br.readLine());
        for (i = 0; i < no; i++) {
            int answer = 0;
            String str=br.readLine();
            StringTokenizer tok=new StringTokenizer(str," ");
            n = Integer.parseInt(tok.nextToken());
            surprise = Integer.parseInt(tok.nextToken());
            p = Integer.parseInt(tok.nextToken());
            for (j = 0; j < n; j++) {
                temp = Integer.parseInt(tok.nextToken());
                if (temp == 0) {
                    if (p != 0) {
                        continue;
                    } else {
                        answer++;
                    }
                    continue;
                }
                if (temp % 3 == 0) {
                    valuemax = temp / 3;
                    if (valuemax >= p) {
                        answer++;
                    } else if ((valuemax + 1 >= p) && (surprise != 0)) {
                        answer++;
                        surprise--;
                    }

                }
                if (temp % 3 == 1) {
                    valuemax = (temp / 3) + 1;
                    if (valuemax >= p) {
                        answer++;
                    }
                }
                if (temp % 3 == 2) {
                    valuemax = (temp / 3) + 1;
                    if (valuemax >= p) {
                        answer++;
                    } else if ((valuemax + 1 >= p) && (surprise != 0)) {
                        answer++;
                        surprise--;
                    }
                }
            }
            System.out.print("Case #" + (i + 1) + ": " + answer);
            if ((i + 1) != no) {
                System.out.print("\n");
            }
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
