package Q2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Main {

	private static BufferedReader input;
	private static BufferedWriter output;
	public Main(String inputSetName) throws Exception {
		if(getClass().getResource(".") == null){
			System.err.println("Switch constructors man");
			System.exit(-1);
		}
		String path = getClass().getResource(".").getPath();
		System.out.println(path);
		input = new BufferedReader(new FileReader(path+inputSetName+".in"));
		output = new BufferedWriter(new FileWriter(path+inputSetName+".out"));
	}
	
	public Main(String[] args) throws Exception{
		input = new BufferedReader(new FileReader(args[0]));
		output = new BufferedWriter(new FileWriter(args[1]));
	}

	public void run(Solver model, boolean resultNewLine) throws Exception{
		int cases = Integer.parseInt(input.readLine());
		model.setInput(input);
		for(int i=1;i<=cases;i++){
			System.out.println("Working on case "+i+"...");
			String $ = model.solve();
			if(resultNewLine)
				outputln("Case #"+i+":");
			else
				output("Case #"+i+": ");
			outputln($);
			System.out.println("Case "+i+" finished! Result: "+$);
		}
		input.close();
		output.close();
	}

	public static void outputln(String s){
		try {
			output.write(s);
			output.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void output(String s){
		try {
			output.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
