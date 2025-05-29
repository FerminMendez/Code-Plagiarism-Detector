import java.io.*;
import java.util.*;

public class ReNum {

	static BufferedReader br;
	static PrintWriter pw;
	
    public static void main(String args[]) {
        try {
            br = new BufferedReader(new FileReader("C-small-attempt1.in"));
			pw = new PrintWriter(new File("ReNumAns.out"));
			String no = br.readLine();
            int number = Integer.parseInt(no);
            for (int h = 0; h <= number - 1; h++) {
                int finAns =0;
                String nos = br.readLine();
                String[] n = nos.split(" ");
                int num1 = Integer.parseInt(n[0]);
                int e = Integer.parseInt(n[1]);
                int size = n[0].length();
               
                
                for (int i=num1;i<=e;i++){
                    String t = Integer.toString(i);
                    for (int j = 1;j<size;j++){
                        t= t.substring(1,size)+t.substring(0,1);
                        
                        int num2 = Integer.parseInt(t);
                        if (num2>i && num2<=e && num2>=num1){
                            finAns++;
                            
                            
                        }
                                                
                    }
                }

                int caseNo = 1 + h;
                String ans = "Case #" + caseNo + ": " + finAns;
                pw.println(ans);
                pw.flush();

            }


        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
