
import java.util.*;
import java.io.*;

public class template {

    private StringBuilder result = new StringBuilder();
    
    public static void main(String[] args) {
        new template().go();
    }

    public void go() {

        File inputFile = new File("/Users/amornchaikanokpullwad/Documents/input.in");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(inputFile));
            int numTests = Integer.parseInt(br.readLine());
            
            for (int testCounter = 0; testCounter < numTests; ++testCounter) {
                int count = 0;
                String text[] = br.readLine().split(" ");
                long A = Long.parseLong(text[0]);
                long B = Long.parseLong(text[1]);
                for (long i = A; i <= B; i++) {
                    for (int j = 1; j < Long.toString(i).length(); j++) {
                        //System.out.println(j + " " + i);
                        long temp = reverse(Long.toString(i),j);
                        if (temp <= i) continue;
                        if (temp <= B) {
                            System.out.println(i+"+"+B);
                            count++;
                        }
                    }
                    
                    
                    //System.out.println(i+"+"+B);
                    
                    
                    
                }
                appendResult(testCounter, count);
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        writeResultToFile();
        System.out.println(result);
    }

    private void appendResult(int testCase, int outp) {

        result.append("Case #" + (testCase+1) + ": ");
        result.append(outp+"");

        result.append("\n");
    }

    private void writeResultToFile() {
        PrintWriter pr = null;

        try {
            pr = new PrintWriter(new File("/Users/amornchaikanokpullwad/Documents/output.in"));
            pr.print(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pr != null) {
                pr.close();
            }
        }
    }
    
    private long reverse(String in,int le){
       
        StringBuilder temp = new StringBuilder();
        for (int i = le; i > 0; i--) {
            //System.out.println(in);
            temp.append(in.charAt(in.length()-i));
            
        }
        for (int i = 0; i < in.length()-le; i++) {
            temp.append(in.charAt(i));
        }
        return Long.parseLong(temp.toString());
    }
}