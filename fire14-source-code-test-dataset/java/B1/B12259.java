/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.*;

/**
 *
 * @author Peter
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        String inputFile, outputFile;
        inputFile = "C-small-attempt4.in"; //"C-small-attempt1.in";// "input.txt";
        outputFile = "output.txt";
        File file = new File(inputFile);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(file);
            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            FileWriter fstream = new FileWriter(outputFile);
            BufferedWriter out = new BufferedWriter(fstream);

            String line, output;
            line = dis.readLine();
            int testCases = Integer.parseInt(line);
            int A, B, m, n, caseNo = 1, count = 0;
            String[] param;
            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {
                output = "Case #" + caseNo + ": ";
                line = dis.readLine();
                param = line.split(" ");
                A = Integer.parseInt(param[0]);
                B = Integer.parseInt(param[1]);
                for(m = B; m > A; m--){
                    for(n = m - 1; n >= A; n--){
                        if(isRecycled(n + "", m + "")){
                            count++;
                           //System.out.println("n =" + n + " m =" + m + " count =" + count);
                        }
                    }
                }
                output += count;
                count = 0;
                out.append(output + "\n");
                caseNo++;
            }

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isRecycled(String n, String m){
        boolean recycled = false;
        
        if(n.length() != m.length()){
            return recycled;
        }
        
        for(int i = 0;i< n.length() ; i++){
            if(n.equals(m)){
                recycled = true;
                break;
            }else{
                n = n.charAt(n.length() - 1) + n.substring(0, n.length() - 1);
                if(n.equals(m)){
                recycled = true;
                break;
                }
            }
        }
        return recycled;
    }
}
