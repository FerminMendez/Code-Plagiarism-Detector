import java.io.BufferedWriter;
import java.util.ArrayList;

public class Helper {

	public Helper() {
		super();
	}
	
	public String operate(String op) {
		System.out.println(op);
		String result ="";
		int total = 0;
		String[] split = op.split(" ");
		int inter = Integer.valueOf(split[1]);
		int goal = Integer.valueOf(split[2]);
		System.out.println("Interesting:" + inter + " Goal:" + goal);
		goal = goal -1;
		for (int i = 3; i < split.length; i++){
			int score = Integer.valueOf(split[i]);
			int base = score / 3;
			int next = (score - base) / 2;
			int third = score - base - next;
			System.out.println(base + " " + next + " " + third);
			if (third - base < 2 && third > goal) {
					total += 1;
			//Interesting
			} else if (third - base == 2) {
				if (inter > 0 && third > goal) {
					inter -= 1;
					total += 1;
				}
			} else {
				if (third + 1 > goal && next > 0 && inter > 0) {
					if (third - base == 1 && next == base){
						;
					} else {
						inter -= 1;
						total += 1;
					}
				}
			}
		}
		System.out.println("Result: " + result + total);
		return result + total;
	}
	
	public void inputStrings(ArrayList<String> anInput) {
		
	}
	
	public void printResult(BufferedWriter out, String input, int n) {
		String result = "Case #"+ n +": " + operate(input) + "\n";
		//System.out.print(result);
		try {
			out.write(result);
		}catch (Exception e){//Catch exception if any
			System.err.println("here Error: " + e.getMessage());
		}
	}
}
