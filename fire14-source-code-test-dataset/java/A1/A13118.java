import java.io.*;
import java.util.*;

class q2 {
    public static void main(String args[]) {
        Scanner obj = new Scanner(System.in);
        int T = obj.nextInt();
        try {
            FileOutputStream out = new FileOutputStream("myfile.txt");
            PrintStream p = new PrintStream(out);

            for (int i = 0; i < T; i++) {
                int No_googlers = obj.nextInt();
                int pp = obj.nextInt();
				int S = obj.nextInt();
                
                int cnt2 = 0;
                int cnt4 = 0;
                for (int j = 0; j < No_googlers; j++) {
                    int num = obj.nextInt();
                    
                    if (num >= (3 * pp - 2)) {
                        cnt2++;}
                    else if(num ==0){
                        cnt2=cnt2;
                    } else if (num >= (3 * pp - 4)) {
                        cnt4++;
                    }
                }
                System.out.println(cnt4);
                if (cnt4 > S) {
                    cnt2 = cnt2 + S;
                } else {
                    cnt2 = cnt2 + cnt4;
                }
                p.print("Case #" + (i+1) + ": " + cnt2);
                p.println();
            }
            p.close();
        } catch (Exception e) {
            System.err.println("Error writing to file");
        }
    }
}