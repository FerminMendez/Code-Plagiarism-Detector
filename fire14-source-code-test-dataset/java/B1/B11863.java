import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class QualificationQ3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);

		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int T = in.nextInt();
		in.nextLine();
		for (int zz = 1; zz <= T; zz++) {

			String outputLine = process(in);
			output(out,zz,outputLine);
		}
		in.close();
		out.close();
	}

	private static String process(Scanner in) {
		
		int begin = in.nextInt();
		int end = in.nextInt();
		int counter  = 0;
		
		for (int i=begin;i<end;i++){
			ArrayList<Integer> l= generateTheQualifiedList(i,end);
			counter += l.size();
		}
		
		return ""+counter;
	}
	
	private static ArrayList<Integer> generateTheQualifiedList(int num, int end) {

		ArrayList<Integer> qualifiedNumList = new ArrayList<Integer>();
		String sNumber = "" + num;
		int len = sNumber.length();
		ArrayList<Integer> handledNumber = new ArrayList<Integer>();
		for (int i=1;i<len;i++){
			String rNumber = sNumber.substring(i) + sNumber.substring(0,i);
			int iNumber = new Integer(rNumber);
			if (iNumber>num && iNumber<=end){
				//System.out.println(num + " " +iNumber);
				if (!handledNumber.contains(iNumber)){
					handledNumber.add(iNumber);
					qualifiedNumList.add(iNumber);
				}else{
					System.out.println(iNumber);
				}
			}
		}
		
		return qualifiedNumList;
	}

	private static void output(BufferedWriter out, int zz, String formattedString) throws IOException {
		String outputLine = String.format("Case #%d: %s\n", zz,
				formattedString);
		System.out.format(outputLine);
		out.write(outputLine);
	}

}
