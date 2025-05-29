import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Recycle {

	public static void main(String[] args) {
		new Recycle().readFile();
	}

	private void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"input.txt"));
			maxCases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= maxCases; i++) {
				String singleCase = reader.readLine();
				solve(singleCase);
				System.out.println("Case #" + i + ": " + (counter-sym));
				clear();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clear() {
		counter =sym=0;
	}

	private int maxCases;
	int counter, min, max,sym;

	private void solve(String singleCase) {
		String vals[] = singleCase.split(" ");
		min = Integer.parseInt(vals[0]);
		max = Integer.parseInt(vals[1]);
		for (int i = min; i <= max; i++) {
			for (int j = 1; j < (i + "").length(); j++) {
				int rev = permuteNumber(i + "", j);
				if (rev <= max && rev >= i && checkRev(i) && i!=rev) {
					if(checkSymmetry(i))
						sym++;
					counter++;
				}
			}
		}
		sym = sym/2;
	}

	private boolean checkRev(int i) {
		char ch[] = (i + "").toCharArray();
		for (char c : ch) {
			if (ch[0] == c) {
				continue;
			} else {
				return true;
			}
		}
		return false;
	}

	public int permuteNumber(String st, int pos) {
		String s = st.substring(st.length() - pos)
				+ st.substring(0, st.length() - pos);
		return Integer.parseInt(s);
	}
	private boolean checkSymmetry(int i){
		String s =(i+"");
		if(s.substring(0,s.length()/2).equals(s.substring(s.length()/2))){
			return true;
		} else{
			return false;
		}
	}
}
