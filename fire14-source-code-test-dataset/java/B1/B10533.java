import java.io.*;
import java.lang.*;
import java.util.*;
class GCJ {
    public static void main(String[] args) {
		
		try {
			PrintWriter out = new PrintWriter(new FileWriter("1.txt"));
			
			BufferedReader in = new BufferedReader(new FileReader("1.in")); 
			in.readLine();
			
			int counter = 1;
			while (in.ready()) { 
				String s = in.readLine();
				out.print("Case #" + Integer.toString(counter) + ": ");
				counter++;
				
				String[] n = s.split(" ");

				int A = Integer.parseInt(n[0]);
				int B = Integer.parseInt(n[1]);
				int D = B - ((B - A)/10);
				
				if(Integer.toString(D).length() > 2)
					D = B - (int) Math.pow(10, Integer.toString(D).length() - 2);
				else D = B;
				
				int number = 0;
				//System.out.println(D);
				
				for(int i=A; i<B;i++) {
					String a = Integer.toString(i);
					StringBuffer p = new StringBuffer(a);
					
					if(a.length() == 1 || a.replace(a.charAt(0), ' ').trim().length() <= 0) {
						continue;
					}
					
					List<Integer> list = new ArrayList<Integer>();
					for(int c=1;c<a.length();c++)
					{
						p.append(p.substring(0,1));
						p.delete(0,1);
						if(p.charAt(0) == '0') continue;
						
						int t = Integer.parseInt(p.toString());
						if(t >= A && t <= B && t > i && !list.contains(t)
							) {
							//out.print(i);
							//out.print(",");
							//out.println(t);
							list.add(t);
							number++;
						}
					}
				}

				out.println(Integer.toString(number));
				//System.out.println(Integer.toString(number));
			}

			in.close();
			out.close();
		
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
    }
}