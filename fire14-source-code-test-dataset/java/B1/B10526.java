import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Third {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter(new File("output.txt")));
			reader.readLine();
			int test = 1;
			String str = "";
			while((str = reader.readLine()) != null){
				long result = 0;
				String[] temp = str.split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				boolean[] visited = new boolean[b + 1];
				
				for(int num = a; num <= b; num++){
					if(visited[num]) continue;
					
					int[] digits = GetDigit(num);

					Set<Integer> recycledNum = new HashSet<Integer>();
					for(int i = 0; i < digits.length; i++){
						int thisNum = GetNum(digits, i);
						int thisNumDigit = (int) (Math.log10(thisNum) + 1);
						if(thisNum >= a && thisNum <= b && thisNumDigit == digits.length)
							recycledNum.add(thisNum);
					}
					if(recycledNum.size() > 1){
						result += recycledNum.size() * (recycledNum.size() - 1) / 2;
						Iterator<Integer> iterator = recycledNum.iterator();
						while(iterator.hasNext()){
							visited[iterator.next()] = true;
						}
					}
				}
				writer.println("Case #" + test + ": " + result);
				test++;
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int[] GetDigit(long num){
		int digits = (int) (Math.log10(num) + 1);
		int[] result = new int[digits];
		while(digits > 0){
			result[--digits] = (int) (num % 10);
			num /= 10;
		}
		return result;
	}
	
	private static int GetNum(int[] digits, int startDigit){
		int number = 0;
		int pos = startDigit;
		do{
			number = number * 10 + digits[pos];
			pos++;
			if(pos >= digits.length) pos -= digits.length;
		} while(startDigit != pos);
		return number;
	}
}
