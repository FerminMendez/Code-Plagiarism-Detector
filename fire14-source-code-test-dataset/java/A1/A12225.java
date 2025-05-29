import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Read {
	int noOfTestCases;
	
	
int []N;
int []S;
int []p;
int [][]all;
	public void test() throws FileNotFoundException{
		File file = new File("out");
		File file2 = new File("out2");
		Scanner scanner = new Scanner(file);
		Scanner scanner2 = new Scanner(file2);
		while(scanner.hasNext()){
			String l1 = scanner.nextLine();
			String l2 = scanner2.nextLine();
			if(!l2.equals(l1)){
				System.out.println(l1);
				System.out.println(l2);
				System.out.println("wrong");
			}
		}
	}

	public void Read(String name) {
		File file = new File(name);

		try {

			Scanner scanner = new Scanner(file);
			String line = scanner.nextLine();
			noOfTestCases = Integer.parseInt(line);
			N =  new int[noOfTestCases];
			S =  new int[noOfTestCases];
			p = new int[noOfTestCases];
			all = new int[noOfTestCases][];
			int i=0;
			while(i<noOfTestCases){
			int x = scanner.nextInt();
			N[i]=x;
			 x = scanner.nextInt();
			 S[i]=x;
			  x = scanner.nextInt();
			 p[i]=x;
				int []curr= new int[N[i]];
			 for (int j = 0; j < N[i]; j++) {
				curr[j]=scanner.nextInt();
			}
			 all[i]=curr;
			i++;
			}
		} catch (FileNotFoundException e) {

		}

	}
	public void write(String fname,String data)
	{
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter(fname);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(data);
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
public static void main(String[] args) throws FileNotFoundException {
	Read r = new Read();
	r.test();
//	for (int i = 0; i < 50; i++) {
//		System.out.println("1000000 2000000");
//	}
}
}
