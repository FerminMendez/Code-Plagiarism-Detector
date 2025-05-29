package gdwg;

import java.io.*;

/**
 *
 * @author alexho
 */
public class GDWG {
    
    private static int [] result;
    
    
    private void readInput (String infn) throws FileNotFoundException, IOException {
        String line = null;        
        int testCases = 0;
        BufferedReader bufRdr = null;      
        String delimiter = " ";
        File file = new File(infn);
        bufRdr = new BufferedReader(new FileReader(file));            

        testCases = Integer.valueOf(bufRdr.readLine());        
        GDWG.result = new int [testCases];
        
        int index=0;
                
        while ( (line = bufRdr.readLine()) != null ) {
                        
            String [] temp;            
            temp = line.split(delimiter);            
            this.computeMax(temp, index);            
            index++;

        }
        bufRdr.close();

        
    }
    
    private void output (String outfn) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(outfn));
        for (int i=0;i<GDWG.result.length;i++) {
            out.println("Case #"+(i+1)+": "+GDWG.result[i]);

        }
        out.close();        
    }
    
    private void computeMax (String [] tempS, int index) {
        
        int N,S,p, max=0,Nti;
        N = Integer.valueOf(tempS[0]);
        S = Integer.valueOf(tempS[1]);
        p = Integer.valueOf(tempS[2]);
        
        for (int i=3;i<tempS.length;i++) {
            Nti = Integer.valueOf(tempS[i]);
            
            // 1st case
            if (p == 0) {
                max++;
            } else if (p > Nti) {
                // do nothing
            } else if (Nti/3 >= p) {
                max++;                
            } else if (p - Nti/3 <=2 && p - Nti/3 > 0 ) {
                if ( 3*p == Nti) {
                        max++;
                    } else if (3*p+1 == Nti) {
                        max++;
                    } else if (3*p-1 == Nti) {
                        max++;
                    } else if (3*p-2 == Nti) {
                        max++;
                    } else if (3*p+2 == Nti) {
                        max++;
                    } else if (3*p-3 == Nti && S > 0) {
                        S--;
                        max++;
                    } else if (3*p+3 == Nti && S > 0) {
                        S--;
                        max++;
                    } else if (3*p-4 == Nti && S > 0) {
                        S--;
                        max++;
                    } else if (3*p+4 == Nti && S > 0) {
                        S--;
                        max++;
                    }
                
            } else {
                
            }
            
            
                                                                           
        }
        GDWG.result[index]=max;
    }
    
    public GDWG () {
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String infn = args[0];
        String outfn = args[1];
        GDWG gdwg = new GDWG();
        gdwg.readInput(infn);
        gdwg.output(outfn);
        for (int i=0;i<GDWG.result.length;i++) {
            System.out.println(GDWG.result[i]);
        }
        
    }
}
