import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NumberMagic {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.small"));
		int cases = Integer.parseInt(in.readLine());
		String [] tests = new String[cases];
		Set set = new HashSet<String>();
		for(int i=0;i<cases;i++){
			set.clear();
			tests[i] = in.readLine();
			int A = Integer.parseInt(tests[i].split(" ")[0]);
			int B = Integer.parseInt(tests[i].split(" ")[1]);
			
			for(int j=A;j<=B;j++){
                 for(int k=j+1;k<=B;k++){
                	 String s1 = Integer.toString(j);
                	 String s2 = Integer.toString(k);
                	 if(s2.length()!=s1.length() && s1.equalsIgnoreCase(s2)){
                		 continue;
                	 }
              		 if((s1 = s1.concat(s1)).contains(s2)){
                        set.add(s1+" "+s2);
              		 }                		    
                 }
			}
			System.out.println("Case #"+(i+1)+": "+set.size());
		}
	}

}
