import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws Exception{
		File inFile=new File("C-small-attempt1.in");
		File outFile=new File(inFile.getName().substring(0,inFile.getName().length()-3)+".out");
		BufferedReader in=new BufferedReader(new FileReader(inFile));
		//BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(in.readLine());
		Recycler r[]=new Recycler[cases];
		ExecutorService executor=Executors.newFixedThreadPool(10);
		for(int i=0;i<cases;i++){
			String temp[]=in.readLine().split(" ");
			int first=Integer.parseInt(temp[0]);
			int second=Integer.parseInt(temp[1]);
			r[i]=new Recycler(first,second);
			executor.execute(r[i]);
		}
		executor.shutdown();
		while(!executor.isTerminated());
		DataOutputStream out=new DataOutputStream(new FileOutputStream(outFile));
		for(int i=0;i<cases;i++){
			out.writeBytes("Case #"+(i+1)+": "+r[i].getCount()+"\n");
			System.out.println("Case #"+(i+1)+": "+r[i].getCount());
		}
	}
}
