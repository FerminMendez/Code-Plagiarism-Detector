package dancing_with_googlers;

import java.io.IOException;
import java.util.ArrayList;

public class FindNumber {
	
	public static Integer start (String casus) {
        
        String[] splitInput = casus.split(" ");
        
        ArrayList<Integer> intinput = new ArrayList<Integer>();
        for (String s: splitInput) {
        	intinput.add(Integer.parseInt(s));
        	System.out.print(s + " ");
        }
        System.out.println();
        
        int nr=0;
        
        int googlers = intinput.get(0);
        int surprise = intinput.get(1);
        int p = intinput.get(2);
        
        for(int i=0; i<3; i++) {
        	intinput.remove(0);
        }
        
        for(int i=0; i<googlers; i++) {
        	boolean passtest = false;
        	System.out.println("Working on digit " + intinput.get(i) + " with surprise " + surprise + " and test " + p);
        	
        	if (p==0) {
        		passtest = true;
        		System.out.println("test was set to 0");
        	} else if (intinput.get(i)>0) {
        		if ((intinput.get(i)/3)>=p) {
        			passtest=true;
        			System.out.println("Integer " + intinput.get(i) + " was devided by three and the result was bigger or equal to " + p);
        		}
        		else if (((intinput.get(i)-p)/2)>=(p-1)){
        			passtest=true;
        			System.out.println("Integer " + intinput.get(i) + " was deminished by " + p + " and the result was devided by two. The result of this was bigger or equal to " + (p-1));
        		}
        		else if (((intinput.get(i)-p)/2)>=(p-2)&&surprise>0) {
        			passtest=true;
        			surprise--;
        			System.out.println("Integer " + intinput.get(i) + " was deminished by " + p + " and the result was devided by two. The result of this was bigger or equal to " + (p-2) + " and we still had some surprises left.");
        		}
        	}
        	if (passtest) nr++;
    		System.out.println(" nr is now set to " + nr);
        }
        
		return nr;
	}
}
