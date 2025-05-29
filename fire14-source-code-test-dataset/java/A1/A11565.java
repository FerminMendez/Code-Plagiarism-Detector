/**
 *
 * @author amit
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//import java.util.Arrays;
//import java.math.BigInteger;

public class GCJ {

    BufferedReader rin;
    BufferedWriter wout;
    int numCases;


    public String getNextInput() {
        try {
        	String line = rin.readLine();
        	String[] aVars = line.split(" ");
        	long count = 0;
        	long N = Long.parseLong(aVars[0]);
        	long S = Long.parseLong(aVars[1]);
        	long P = Long.parseLong(aVars[2]);
        	ArrayList<Long> gc = new ArrayList<Long>();
        	for (int i=0; i<N; i++) {
        		gc.add(Long.parseLong(aVars[i+3]));
        	}
        	Collections.sort(gc);
        	for (int i=gc.size()-1; i>=0; i--) {
        		long t1 = gc.get(i);
        		System.out.println("\nnum: " + t1);
        		long t2 = (long) Math.ceil((double)t1/3.0); 
        		if (t1 ==1 && P==2) break;
        		if (t1 ==0 && P>0) break;
        		if (P<= t2) {
        			count ++;
        			System.out.println("\nadded without S");
        		}
        		else if (S>0 && P<=t2+1) {
        			count ++;
        			S--;
        			System.out.println("\nadded with S");
        		}
        		else break;
        	}
        		/*
        		long t = Long.parseLong(aVars[i+3]);
        		System.out.println("\nscore" + t);
        		if ((t%3)==2) {
        			System.out.println("mod2");
        			if (P <= t/3+1) {
        				count ++;
        			}
        		}
        		else if ((t%3)==1) {
        			System.out.println("mod1");
        			S--;
        			if (P <= t/3 +1) {
        				count++;
        			}
        		}
        		else {
        			gc.add(t);
        			System.out.println("mod3");
        		}
        	}
        	Collections.sort(gc);
        	if (!(gc.isEmpty())) {
	        	for (int i=gc.size()-1; i>=0; i--) {
	        		//System.out.println("\ni: " + i);
	        		long t1 = gc.get(i);
	        		if (P<=t1/3) {
	        			count ++;
	        		}
	        		else if (P<=t1/3+1) {
	        			count ++;
	        			S--;
	        		}
	        		else if (S>0) {
	        			System.out.println("\nError!");
	        		}
	        		else break;
	        	}
        	}*/
        	return Long.toString(count);
        } catch (IOException e) {
            System.out.println("File Error! Could not read line from file");
        }
        return null;
    }
    
    public void writeNextOutput(String s) {
        try {
            wout.write(s);
            wout.write("\n");
        } catch (IOException e) {
            System.out.println("Error! Could not write to the file!");
        }
    }

    public GCJ(String s1, String s2) {
        try {
            rin = new BufferedReader(
                    new FileReader(s1));
            wout = new BufferedWriter(new FileWriter(s2));
            numCases = Integer.parseInt(rin.readLine());

            for(int i=1; i <= numCases; i++){
                System.out.println("case#" + i);
                String sout = getNextInput();
                sout = "Case #" + Integer.toString(i) + ":" + " " + sout;
                writeNextOutput(sout);
                //System.out.println("case#" + i);
            }
            rin.close();
            wout.close();
        } catch (IOException e) {
            System.out.println("File error");
            System.exit(0);
        }
    }

    public static void main(String[] args) {/*
        if (args.length!=2) {
        System.out.println("Enter input file!");
        System.exit(0);
        }*/
        GCJ a = new GCJ("infile.txt", "out.txt");
    }
}
