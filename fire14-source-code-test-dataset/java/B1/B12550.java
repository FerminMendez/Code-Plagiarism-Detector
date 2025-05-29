
package grn;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author alexho
 */
public class GRN {
    
    private static int [] result;
    private static ArrayList<String> permutation = new ArrayList<String>();
    
    
    private void readInput (String infn) throws FileNotFoundException, IOException {
        String line = null;        
        int testCases = 0;
        BufferedReader bufRdr = null;      
        String delimiter = " ";
        File file = new File(infn);
        bufRdr = new BufferedReader(new FileReader(file));            

        testCases = Integer.valueOf(bufRdr.readLine());        
        GRN.result = new int [testCases];
        for (int i=0;i<GRN.result.length;i++) {
            GRN.result[i] = 0;
        }
        
        int index=0;
                
        while ( (line = bufRdr.readLine()) != null ) {
                        
            String [] temp;            
            temp = line.split(delimiter);
//            GRN.usedperm.clear();
            this.computeMax(temp, index);            
            index++;
//            for (int i=0;i<GRN.usedperm.size();i+=2) {
//                if (i != GRN.usedperm.size()-1)
//                    System.out.println(i/2+": "+GRN.usedperm.get(i)+","+GRN.usedperm.get(i+1));
//            }
//            System.out.println();

        }
        bufRdr.close();

        
    }
    
    private void computeMax(String [] temp, int ind) {
        
        int A,B,max=0;
        A = Integer.valueOf(temp[0]);
        B = Integer.valueOf(temp[1]);
        
        for (int n=A;n<=B;n++) {
            this.findM(n, B, ind);                             
        }
        
    }

    private void reorder(String s) {
        int len = s.length();
        String ns="";
        GRN.permutation.clear();
        for (int i=1;i<len;i++) {
            ns = s.substring(i).concat(s.substring(0, i));
            if (!ns.equals("") && !GRN.permutation.contains(ns)) {
                GRN.permutation.add(ns);
            }
        }
        
    }
    
    private void findM (int n, int B, int ind) {
        
        String alphabet = String.valueOf(n);       
        this.reorder(alphabet);     
        int m;
        
        for (int i=0;i<GRN.permutation.size();i++) {
            m = Integer.valueOf(GRN.permutation.get(i));
//            if (m <= B && m > n && !GRN.usedperm.contains(alphabet) && !GRN.usedperm.contains(GRN.permutation.get(i))) {
            if (m <= B && m > n ) {
//                GRN.usedperm.add(alphabet);
//                GRN.usedperm.add(GRN.permutation.get(i));
                GRN.result[ind]++;
            }
            
        }                
        
    }
    
    private void output (String outfn) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outfn));
        for (int i=0;i<GRN.result.length;i++) {
            out.println("Case #"+(i+1)+": "+GRN.result[i]);

        }
        out.close();        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        GRN grn = new GRN();
        String infn = args[0];
        String outfn = args[1];
        grn.readInput(infn);
//        String test = "13105";
        
//        grn.reorder(test);

        for (int i=0;i<GRN.result.length;i++) {
            System.out.println(GRN.result[i]);
        }
        
        grn.output(outfn);
                
    }
}
