import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled_Num {

	public static void main(String[] args) {
		//long currentTime = System.currentTimeMillis();
		Scanner input_file = new Scanner(new InputStreamReader(System.in));
		String input_line = null;
		String[] numb_arr;
		int Case_Count = 0;
		int st_num = 0;
		int end_num = 0;
		int pair_count = 0;
		int digitCount = 0;
		StringBuilder recycle_number = new StringBuilder();
		int newNumber = 0;
		String newNumberString;
		HashSet<String> recycle_numbers = new HashSet<String>();
		while (input_file.hasNextLine()) {
			input_line = input_file.nextLine();
			numb_arr = input_line.split(" ");
			if(numb_arr != null && numb_arr.length == 1) {
				/*numberOfTestCases = Integer.parseInt(numb_arr[0]);*/
			} else if (numb_arr != null && numb_arr.length == 2) {
				digitCount = numb_arr[0].length();
				st_num = Integer.parseInt(numb_arr[0]);
				end_num = Integer.parseInt(numb_arr[1]);
				while(st_num <= end_num) {
					newNumberString = "" + st_num;
					for(int i = 1; i < digitCount; i++) {
						recycle_number = recycle_number.append(newNumberString.substring(i) + newNumberString.substring(0, i));
						newNumber = Integer.parseInt(recycle_number.toString());
						if(newNumber > st_num && newNumber <= end_num) {
							recycle_numbers.add(recycle_number.toString());
						}
						recycle_number.delete(0, digitCount);
					}
					pair_count = pair_count + recycle_numbers.size();
					st_num++;
					recycle_numbers.clear();
				}
				System.out.println("Case #" + Case_Count + ": " + pair_count);
			}
			Case_Count++;
			pair_count = 0;
			st_num = 0;
			end_num = 0;
			digitCount = 0;
			newNumber = 0;
			recycle_number.delete(0, digitCount);
		}
		//System.out.println(System.currentTimeMillis() - currentTime);
	}
}
