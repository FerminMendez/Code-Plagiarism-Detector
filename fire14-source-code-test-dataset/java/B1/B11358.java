package os;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = 0;
        try {
            testcase = Integer.valueOf(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(NewMain1.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int z = 1; z <= testcase; z++) {
            String startA = null;
            String startB = null;
            String[] input = new String[2];
            try {
                input = br.readLine().split(" ");
                startA = input[0];
                startB = input[1];
            } catch (IOException e) {
                System.out.println("Error!");
                System.exit(1);
            }
            int countrecycle = 0;
            for (int A = Integer.valueOf(startA); A <= Integer.valueOf(startB); A++) {
                for (int B = Integer.valueOf(startB); B > A; B--) {

                    String num1 = String.valueOf(A);
                    String num2 = String.valueOf(B);
                    for (int i = 1; i < num1.length(); i++) {
                        String temp = "";
                        int count = i;
                        while (count != 0) {

                            temp += num1.charAt(num1.length() - count);
                            count--;
                        }
                        for (int j = 0; j < num1.length() - i; j++) {
                            temp += num1.charAt(j);
                        }
                        if (temp.equals(num2)) {
                            countrecycle++;
                            break;
                        }
                    }

                }
            }
            System.out.println("Case #"+z+": " + countrecycle);
        }
    }
}
