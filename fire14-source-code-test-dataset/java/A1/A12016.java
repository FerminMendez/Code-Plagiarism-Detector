import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Drugi {

	public static void main (String [] args) throws IOException {
		
		 PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		 Input in= new Input(new FileInputStream(new File("B-small.in")));
		 //BufferedReader in = new BufferedReader(new FileReader("Asmall.in"));
		 
		 
		 int t= in.readInt();
		 int n,s,p,zbroj,irr, m;
		 	
		 for(int i=0; i<t;i++)
		 {	
			n = in.readInt();
			s = in.readInt();
			p = in.readInt();
			zbroj = 0;
			irr = 0;
			for(int j=0; j<n;j++)
			{
				m = in.readInt();
				if(p==0) zbroj++;
				else if(p==1) 
				{
					if(m!=0) zbroj++;
				}
				else if(m>=3*p-2) zbroj++;
				else if(m>=3*p-4) irr++;
			}
			 zbroj += min(irr,s);
			 out2.print("Case #"); 	     
		     out2.print(i+1);
		     out2.print(": ");
		     out2.println(zbroj);
		     out2.flush();
		 }
	}

	private static int min(int irr, int s) {
		if(irr>s) return s;
		return irr;
	}
}
