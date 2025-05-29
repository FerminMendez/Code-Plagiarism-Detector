import java.io.*;
import java.math.BigInteger;
import java.util.*;

import org.jfree.data.function.PowerFunction2D;

public class r2a
{

	Map numMap = new HashMap();
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
            	int begin=0,end = 0;
                i++;
                if (i == 1)
                    continue;
                mk.numMap = new HashMap();
                StringTokenizer strTok = new StringTokenizer(str, " ");
                while (strTok.hasMoreTokens()) {
                	begin =  Integer.parseInt(((String) strTok.nextToken()));
                    end = Integer.parseInt(((String) strTok.nextToken()));
                }

                mk.evaluate(i, begin, end);

            }
            in.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }

    }

    private void evaluate(int rowNum, int begin, int end)
    {
    	output=0;
    	for (int i = begin; i<= end; i++) {
    		if(numMap.containsKey(Integer.valueOf(i)))
    			continue;
    		List l = getPairElems(i);
    		if (l.size() > 0) {
    			Iterator itr = l.iterator();
    			int ctr = 0;
    			ArrayList tempList = new ArrayList();
    			while (itr.hasNext()) {
    				int next = ((Integer)itr.next()).intValue();
    				if (next <= end && next > i) {
    					numMap.put(Integer.valueOf(next), i);
    					tempList.add(next);
    					ctr++;
    				}
    			}
    			ctr = getCounter(ctr+1,2);
/*    			if (tempList.size() > 0 || ctr > 0)
    				System.out.println("DD: " + i + ": " + tempList +" ; ctr = " + ctr);*/
    			output = output + ctr;
    		}
    		
    	}

        String outputStr = "Case #" + (rowNum -1) + ": " + output;
        
        System.out.println(outputStr);
    }

	private int getCounter(int n, int r) {
		int ret = 1;
		int nfactorial =1;
		for (int i = 2; i<=n; i++) {
			nfactorial = i*nfactorial;
		}
		int nrfact =1;
		for (int i = 2; i<=n-r; i++) {
			nrfact = i*nrfact;
		}
		
		return nfactorial/(2*nrfact);
	}

	private ArrayList getPairElems(int num) {
		ArrayList retList = new ArrayList();
		int temp = num;
		if (num/10 == 0)
			return retList;
		
		String str = String.valueOf(num);
		
		int arr[] = new int[str.length()];
		int x = str.length();
		while (temp/10 > 0) {
			arr[x-1] = temp%10;
			temp=temp/10;
			x--;
		}
		arr[0]=temp;
		
		int size = arr.length;
		for (int pos = size -1; pos >0; pos--) {
			if(arr[pos] == 0)
				continue;
			int pairNum = 0;
			int multiplier =1;
			for (int c=0; c < size-1; c++) {
				multiplier = multiplier*10;
			}
			pairNum = pairNum + (arr[pos]*multiplier);
			for(int ctr = pos+1, i=1; i < size; i++,ctr++) {
				if (ctr == size)
					ctr=0;
				if (multiplier!=1)
					multiplier=multiplier/10;
				pairNum = pairNum + (arr[ctr]*multiplier);
			}
			if (pairNum != num)
				retList.add(Integer.valueOf(pairNum));			
		}
		
		return retList;
	}
}
