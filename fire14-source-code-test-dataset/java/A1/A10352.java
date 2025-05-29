import java.io.*;
import java.util.Scanner;

public class B {


    static final String IN_FILE = "B-small-attempt0.in.in";


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(IN_FILE));
        Writer out = new BufferedWriter(new FileWriter(IN_FILE+".out"));
//        Writer out = new OutputStreamWriter(System.out);


        Scanner sc = new Scanner(in);
        int cases = sc.nextInt();
        sc.nextLine();
        for(int caseNo=1; caseNo<=cases; caseNo++){
            out.write("Case #" + caseNo + ": ");
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();
            int res = 0;
            for(int i = 1; i <= N; i ++){
                int sum = sc.nextInt();
                int k = (sum - p) / 2;
                if(p > sum){
                    continue;
                }if(p-k <=1) {
                    res ++;
                } else if(p-k<=2 && S > 0){
                    res ++;
                    S --;
                }
            }
            out.write(Integer.toString(res));

            if(caseNo<cases){
                out.write("\n");
                out.flush();
            }


        }
        in.close();
        out.close();

    }
}
