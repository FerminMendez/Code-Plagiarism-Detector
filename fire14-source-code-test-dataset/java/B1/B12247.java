
import java.io.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Problem C. Recycled Numbers
 *
 * @author admin
 */
public class ProblemC_RecycledNumbers {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:/C-small-attempt0.in")));

        br.readLine();  // Ignore T

        StringBuilder sb = new StringBuilder();
        int row = 1;

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            sb.append("Case #");
            sb.append(row);
            sb.append(": ");
            int ret = 0;
            String[] numbers = line.split(" ");
            int A = Integer.parseInt(numbers[0]);
            int B = Integer.parseInt(numbers[1]);
            
            for (int m = A+1; m <= B; m++) {
                for (int n = A; n < m; n++) {
                    if(recycled(n, m)) {
                        ret++;
                    }
                }
            }
            
            sb.append(ret);
            System.out.println(ret);
            sb.append('\n');
            row++;
        }
        
        File file=new File("ProblemC_RecycledNumbers.out");
        DataOutputStream output=new DataOutputStream(new FileOutputStream(file));
        output.write(sb.toString().getBytes());
        output.close();

    }

    public static boolean recycled(int n, int m) {
        
        String strN = String.valueOf(n);
        String strM = String.valueOf(m);
        
        for(int i=1; i<strN.length(); i++) {
            String temp = strN.substring(i) + strN.substring(0, i);
            
            if(strM.equals(temp)) {
                return true;
            }
        }

        return false;
    }
}
