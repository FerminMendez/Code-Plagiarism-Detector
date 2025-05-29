import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers {
	public static void main(String[] args) {
		RecycledNumbers recycled = new RecycledNumbers();
		recycled.read_input_file();
		/*if(recycled.check_if_the_number_is_a_recycled_pair("23451", "34512", "12345")) {
			number_of_recycled_pairs ++;
			System.out.println(number_of_recycled_pairs);
		}*/
	}
	
	public boolean check_if_the_number_is_a_recycled_pair(String first_number, String second_number, String original_number) {
		if (original_number.equals(first_number)) {
			return false;
		} else if(first_number.equals(second_number)) {
			return true;
		} else {
			return check_if_the_number_is_a_recycled_pair((first_number.substring(1) + first_number.charAt(0)), second_number, original_number);
		}
	}
	public void read_input_file() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader("C-small-attempt2.in"));
			
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			
			T = Integer.parseInt(rd.readLine());
			System.out.println(T);
			while (true) {
				String A_and_B = rd.readLine();
				System.out.println(A_and_B);
				if (A_and_B == null) {
					break;
				}
				parse_line(A_and_B, out);
				number_of_recycled_pairs = 0;
			}
			out.close();
			rd.close();
		} catch (IOException ex) {
			System.out.println("file not found");
		}
	}
	
	public void parse_line(String A_and_B, BufferedWriter out) {
		String A = A_and_B.substring(0, A_and_B.indexOf(" "));
		String B = A_and_B.substring(A_and_B.indexOf(" ") + 1);
		
		for (Integer i = Integer.parseInt(A); i < Integer.parseInt(B); i++) {
			for (Integer j = i + 1; j <= Integer.parseInt(B); j++) {
				String original_number = i.toString();
				String first_number = original_number.substring(1) + original_number.charAt(0);
				String second_number = j.toString();
				if (check_if_the_number_is_a_recycled_pair(first_number, second_number, original_number)) {
					number_of_recycled_pairs ++;
				}
			}
		}
		Save_line_to_output_file(out);
		
	}
	
	public void Save_line_to_output_file(BufferedWriter out) {
		try{
			  // Create file 
			  out.write("Case #" + (counter + 1) + ": " + number_of_recycled_pairs);
			  out.newLine();
			  counter ++;
			  //Close the output stream
			} catch (Exception e) {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		 }
	}
	int counter = 0;
	int T= 0;
	static int number_of_recycled_pairs = 0;
}
