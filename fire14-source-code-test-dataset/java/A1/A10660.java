import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class B {
	static int getMaxNumberTodlers(String input){
		String[] inputs=input.split(" ");
		int T=Integer.parseInt(inputs[0]);
		int S=Integer.parseInt(inputs[1]);
		int p=Integer.parseInt(inputs[2]);
		int results[]=new int[T];
		for (int i=0;i<T;i++)
			results[i]=Integer.parseInt(inputs[3+i]);
		int min=p*3-2;
		int minSup=p*3-4;
		if (minSup<2)
			minSup=2;
		int br=0;
		System.out.println(min);
		for (int i=0;i<T;i++)
			if(results[i]>=min)
				br++;
			else if (results[i]>=minSup&&S>0){
				br++;
				S--;
			}
		return br;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{

		FileInputStream fstream = new FileInputStream("problemB.txt");

		// Convert our input stream to a
		// DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object
        out = new FileOutputStream("problemBout.txt");
        p = new PrintStream( out );
		int n=Integer.parseInt(in.readLine());
		for (int i=0;i<n;i++)
			 p.println("Case #"+(i+1)+": "+B.getMaxNumberTodlers(in.readLine()));
		in.close();
		p.close();
	}
}
