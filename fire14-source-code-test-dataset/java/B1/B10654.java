import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
import static java.lang.System.*;  

import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
public class goog {
        
 
    public static void main(String[] args) throws IOException {
   Scanner file = new Scanner(new File("C-small-attempt0.in."));
     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prob1.out")));
     int times = file.nextInt();
       file.nextLine();
       
       for(int i = 0;i<times;i++) {
       ArrayList<String> answers = new ArrayList<String>();
       out.print("Case #"+(i+1)+": ");
       int a =file.nextInt();
       int b= file.nextInt();
      
       int answer =0;
       int random =0;
       for(int d = a; d<b+1;d++) {
       	for(int e =d+1;e<b+1;e++) {
       		if(e<=9||d<=9) continue;
       		else if(answers.contains("" + d + e)) {
       		    // dont know what to do, randomly adddeed
       		    random++;
       		}
       		else {
       			//set string first number
       			String g = "" + d;
       			//set string to second number
       			String h = "" + e;
       			//set temp string to second thing
       			String change = h;
       				// rotate it to see if rotation verison works
       			h = h.substring(h.length()-1) + h.substring(0,h.length()-1);
       			while(!(h.equals(change))) {
       				// if rotated isnt the same
       				if(h.equals(g)) {
       					// if rotated is the same as the one
       					answer++;
       					answers.add("" + d + e);
       						   break;
       				}
       				// rotate it again
       				h = h.substring(h.length()-1) + h.substring(0,h.length()-1);
       			}
       			
       		}
       	}
       }
       out.println(answer);
       System.out.println(answer);
       }
      out.close();
      System.exit(0);
    }
}
