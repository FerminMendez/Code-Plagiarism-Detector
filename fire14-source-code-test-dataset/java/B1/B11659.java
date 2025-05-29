import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		String filename = "recycled-input.in";
		FileReader reader = new FileReader(new File(filename));
		BufferedReader bufferedReader = new BufferedReader(reader);

		File outputFile = new File("recycled-output.in");
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

		int total = Integer.parseInt(bufferedReader.readLine());
		for( int i = 1; i <= total; i++){
			// processa cada linha
			
			StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
			int a = getNextInteger(tokenizer);
			int b = getNextInteger(tokenizer);

			int recycledPairs = findAllRecycledNumbers(a,b);
			
			String msg = geraOutputMsg(i,recycledPairs);
			System.out.print(msg);
			
			writer.write(msg);
			
		}
		writer.close();

	}

	private static String geraOutputMsg(int i, int recycledPairs) {
		return String.format("Case #%d: %d\n", i, recycledPairs );
	}

	private static Integer getNextInteger(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}

	private static Integer findAllRecycledNumbers(Integer initial, Integer limit) {

		int totalRecycledNumbers = 0;
		for (int i = initial; i <= limit; i++){
			int recycledNumbers = findRecycledNumbers(i, initial, limit);
			totalRecycledNumbers += recycledNumbers;
		}
		
		return totalRecycledNumbers;
	}

	private static int findRecycledNumbers(Integer number, Integer initial, Integer limit) {
		
		String initialString = number.toString();

		int recycledNumbers = 0;
		int length = initialString.length();
		
//		List<String> allPermutations = new ArrayList<String>();
		HashSet<String> recycledList = new HashSet<String>();
		for (int i = 0; i < length-1; i++){

			String movedChars = initialString.substring(0, i+1);
			String strPermutationNumber = initialString.replaceFirst(movedChars, "").concat(movedChars);

//			allPermutations.add(strPermutationNumber);
			
			int permutationNumber = Integer.parseInt(strPermutationNumber);
			if (permutationNumber > number && permutationNumber <= limit && !recycledList.contains(strPermutationNumber)){
				recycledList.add(strPermutationNumber);
				recycledNumbers++;
			}

		}
//		if (recycledNumbers > 0){
//			printRecycledNumbers(number, allPermutations, recycledList);
//			printRecycledNumbers(number, recycledList);
//		}
		return recycledNumbers;
	}

//	private static void printRecycledNumbers(Integer number,
//			List<String> recycledList) {
//		System.out.printf("Número (%d): ", number);
//		printList(allPermutations);
//		System.out.print(" -> ");
//		printList(recycledList);
//		System.out.println();
//	}

//	private static void printList(List<String> list) {
//		System.out.printf("[%s",list.get(0));
//		for (int i = 1; i < list.size(); i++ ){
//			String stringNumber = list.get(i);
//			System.out.printf(",%s",stringNumber);
//		}
//		System.out.print("]");
//	}
}
