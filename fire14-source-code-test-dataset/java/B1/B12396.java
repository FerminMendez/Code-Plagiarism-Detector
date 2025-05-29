import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Recycled {

	private static String fileNameSmall = "/Users/ogokal/Downloads/C-small-attempt0.in";
	private static String outputFilePath = null;
	
	private static void AppendCase(int caseId,String message, BufferedWriter bw) throws IOException{
		bw.write("Case #"+caseId+": "+message+"\n");
	}
	
	private static String OutputFile(String inputFilePath){
		int dotIdx = inputFilePath.lastIndexOf('.');
		return inputFilePath.substring(0, dotIdx)+".out";
	}
	
	private static int Count(int low,int current, int high,int currentIdx, int total,Set<String> counterSet){
		if (currentIdx >= Integer.toString(low).length()) {
			return total;
		}
		String currentStr = Integer.toString(current);
		String begin = currentStr.substring(0,currentIdx);
		String end = currentStr.substring(currentIdx);
		int currentInt = Integer.parseInt(end+begin);
		if (current != currentInt) {
			int min = Math.min(current, currentInt);
			int max = Math.max(current, currentInt);
			if (currentInt >= low && currentInt <= high && !counterSet.contains(min+" "+max)) {
				counterSet.add(min+" "+max);
				++total;
			}
		}
		return Count(low,current,high,currentIdx+1,total,counterSet);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(new File(fileNameSmall));
		BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFile(fileNameSmall)));
		int totalCaseCount = scanner.nextInt();
		scanner.nextLine();
		int caseCount = 0;
		while(caseCount < totalCaseCount){
			StringBuffer sb = new StringBuffer();
			int low = scanner.nextInt();
			int high = scanner.nextInt();
			int t = 0;
			Set<String> counterSet = new HashSet<String>();
			for (int i = low; i <= high; i++) {
				t = Count(low,i,high,1,t,counterSet);
			}
			sb.append(t);
			caseCount++;
			System.out.println(sb.toString());
			AppendCase(caseCount,sb.toString(),bw);
			scanner.nextLine();
		}
		bw.flush();
		bw.close();
		
	}

}
