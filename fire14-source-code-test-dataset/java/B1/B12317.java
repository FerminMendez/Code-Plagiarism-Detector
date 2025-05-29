import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class problem3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 FileInputStream fstream = new FileInputStream("C:\\Profiles\\sys4qa\\Desktop\\C-small-attempt0.in.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;	
		  Integer T= 0;
		 
		  Integer i1,i2;
		  ArrayList inputPair =new ArrayList();
			ArrayList input= new ArrayList<ArrayList>();
		  while ((strLine = br.readLine()) != null)   {
			  
			 
			  if (T==0)
			  {
				  T= Integer.parseInt(strLine);
			  }
			  else
			  {
				  String s[]=strLine.split(" ");
				  inputPair =new ArrayList();
				  inputPair.add( Integer.parseInt(s[0]));
					
				  inputPair.add( Integer.parseInt(s[1]));
					 input.add(inputPair);
			  }
			  
			  }
			  //Close the input stream
			  in.close();
		
			  FileWriter fstream1 = new FileWriter("C:\\Profiles\\sys4qa\\Desktop\\out.txt");
			  BufferedWriter out = new BufferedWriter(fstream1);
			 
			  
		
int id=0;
		Iterator iter=input.iterator();
		while (iter.hasNext()) {
			ArrayList ip= (ArrayList) iter.next();
			int A = (Integer)ip.get(0);
			int B= (Integer) ip.get(1);
			int cunt=execute(A,B);
			id++; 
			
			 out.write("Case #"+id+": "+cunt+"\n");
		}
		//Close the output stream
		  out.close();

	}

	static int execute(int A, int B) {

		int count = 0;

		for (int i = A; i <= B; i++) {
			Set j = listOfReoderedNumbers(i);

			int k = 0;
			Iterator iter = j.iterator();
			while (iter.hasNext()) {
				k = (Integer) iter.next();
				if ((k > i) && (k <= B) && (k >= A)) {

					count++;

				}
			}

		}
		return (count);

	}

	static Set listOfReoderedNumbers(int i) {
		Set d = new HashSet();
		d.add(i);
		int res = i;
		int t = (i + "").length();
		for (int cnt = 0; cnt < t - 1; cnt++) {
			if (((res + "").length() == t)) {
				int num = res;
				Integer s = Integer.parseInt((num + "").charAt(0) + "");
				int temp = (int) (num - (int) (s * (Math.pow(10, t - 1))));
				res = (temp) * 10 + s;
				if ((res + "").length() == t)
					d.add(res);
			} else {
				res = res * 10;
				d.add(res);
			}

		}

		return d;

	}
}
