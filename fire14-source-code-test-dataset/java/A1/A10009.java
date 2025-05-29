import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class r2a
{

	int surprises = 0;
	int p = 0;
	int elems[] = new int[100];
    int output = 0;

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        r2a mk = new r2a();
        try {
            FileInputStream fstream = new FileInputStream("d:/cjinput.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str;
            int i = 0;
            while ((str = br.readLine()) != null) {
            	int numOfElems = 0;
            	mk.output = 0;
                i++;
                if (i == 1)
                    continue;
                StringTokenizer strTok = new StringTokenizer(str, " ");
                while (strTok.hasMoreTokens()) {
                	numOfElems =  Integer.parseInt(((String) strTok.nextToken()));
                    mk.surprises = Integer.parseInt(((String) strTok.nextToken()));
                    mk.p = Integer.parseInt(((String) strTok.nextToken()));
                    for (int x = 0; x < numOfElems; x++) {
                        mk.elems[x] = Integer.parseInt(((String) strTok.nextToken()));
                    }
                }

                mk.evaluate(i,numOfElems);

            }
            in.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }

    }

    private void evaluate(int rowNum, int numOfElems)
    {
    	
    	for (int i = 0; i< numOfElems; i++) {
    		if (isValidTotal(elems[i])) 
    			output++;
    		
    	}

        String outputStr = "Case #" + (rowNum -1) + ": " + output;
        System.out.println(outputStr);
    }

	private boolean isValidTotal(int num) {
		
		if (p==0)
			return true;
		if (num != 0) {
			int maxVal = 3*p;
			if (num >= maxVal-2)
				return true;
			if (num >= maxVal-4 && surprises > 0) {
				surprises--;
				return true;
			}
		}
		return false;
	}
}
