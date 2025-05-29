import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dancing_With_the_Googlers {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
			BufferedWriter out = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
			Dancing_With_the_Googlers x = new Dancing_With_the_Googlers();
			String str;
			in.readLine();
			while ((str = in.readLine()) != null) {
				String res = x.convert(str);
				out.write(res+"\n");
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			}
	}
	int count=1;
	String convert(String in)
	{
		String op[] = in.split(" ");
	    int no_of_googlers = Integer.parseInt(op[0]);
	    int suprisingTriplets = Integer.parseInt(op[1]);
	    int bestresult = Integer.parseInt(op[2]);
		int current_googler_score = 0;
		int valid_score  = 0;
		int min_best_score = bestresult+2*(bestresult-1);
		if (min_best_score == 0){ valid_score = no_of_googlers;return "Case #"+(count++)+": "+valid_score;}
		int sup =0;
		for (int i=0; i<no_of_googlers; i++){
		current_googler_score = Integer.parseInt(op[3+i]);
			System.out.println("count"+count+"employee"+i);
			System.out.println("min_best_score"+min_best_score);
			System.out.println("current_googler_score"+current_googler_score);
		
		
			if ( current_googler_score >= min_best_score) {
			valid_score++;
			System.out.println("count"+count);
			System.out.println("valid_score"+valid_score);
			}
			else if ( current_googler_score == min_best_score-1 || current_googler_score == min_best_score-2 ){
			if ( current_googler_score != 0){
			sup++;
			System.out.println("count"+count);
			System.out.println("sup"+sup);
			}
			}
		}
		if( suprisingTriplets <= sup ){
		valid_score = valid_score + suprisingTriplets;
		System.out.println("count"+count);
		System.out.println("valid_score1"+valid_score);
		}
		else {
		valid_score = valid_score + sup;
 		System.out.println("count"+count);
		System.out.println("valid_score2"+valid_score);
		}
		return "Case #"+(count++)+": "+valid_score;
	}
	
}
