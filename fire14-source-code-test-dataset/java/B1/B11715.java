import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class CodeJamWriter implements ICounterZeroEvent{
	
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\A-test";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\A-small-attempt0";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\B-test";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\B-small-attempt0";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\B-large";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\C-test";
	public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\C-small-attempt0";
	//public static String inputFile = "C:\\Users\\user\\Desktop\\coejam\\2012-Qualificaton\\C-large";
	
	public int T;
	public Result[] results;

	public static void main(String[] args) {
		CodeJamWriter codeJamWriter = new CodeJamWriter();
		codeJamWriter.readInput();
	}

	private void readInput() {
		Scanner scanner = null;
		File input = new File(inputFile+".in");
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		T = scanner.nextInt();
		scanner.nextLine();
		results = new Result[T+1];
		Counter counter = new Counter(T, this);
		for (int i=1;i<=T;++i)
		{
			results[i] = new Result(i);
			Question q = new QuestionC(results[i], counter);
			q.readInput(scanner);
			q.start();
		}
		scanner.close();	
	}

	private void writeOutput() {
		FileOutputStream fos = null;
		PrintStream printer = null;
		File output = new File(inputFile+".out");
		try {
			fos = new FileOutputStream(output);
			printer = new PrintStream(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=1;i<=T;++i)
		{
			printer.println(results[i]);
		}
		System.out.println("FINISHED!!!");
		
		printer.close();
		
	}

	@Override
	public void fireEvent() {
		writeOutput();		
	}
	
}
