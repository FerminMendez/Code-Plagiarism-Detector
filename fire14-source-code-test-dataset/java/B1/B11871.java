import java.io.*;
import java.util.Scanner;
import java.util.*;

public class B {
	public static int reverse(int a, int b) {
		Vector vec = new Vector();
		Vector vec2 = new Vector();
		int result = 0;
		if(a > 9) {
			for(int i=a; i <= b; i++) {
				String x=i+"";
				for(int j = 1; j < x.length();j++) {
					int status = 0;
					String p =(x.substring(j,x.length()))+x.substring(0,j);
					int num2 = Integer.parseInt(p);
					if(i!=num2 && num2 <= b && num2 >=a) {
						//System.out.println("P VALUE >> " + p);
						//System.out.println("INDEX OF"+x+" : "+vec.indexOf(x));
						for(int k = 0; k < vec.size(); k++) {
							String tmp = (String) vec.elementAt(k);
							String tmp2 = (String) vec2.elementAt(k);
							int c = Integer.parseInt(tmp);
							int d = Integer.parseInt(tmp2);
							if((c == num2 && i == d) || (c==i && d == num2)) {
								status = 1; break;
							}
						}
						if(status == 0) {
							vec.add(x);
							vec2.add(p);
							//System.out.println(">>>"+x+" "+p);
							result++;
						}
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		File fFile = new File("B.in");
		Scanner scanner = null;
    	try {
    		scanner = new Scanner(new FileReader(fFile));
      		//first use a Scanner to get each line
      		int line = 1;
      		while ( scanner.hasNextLine() ){
        		String name = scanner.nextLine();
        		String []x = name.split(" ");
        		int p1 = Integer.parseInt(x[0]);
        		int p2 = Integer.parseInt(x[1]);
        		System.out.println("Case #"+line+": "+reverse(p1,p2));
        		line++;
      		}
    	}
    	catch(Exception ex) {
    	}
    	finally {
      		scanner.close();
    	}
	}
}