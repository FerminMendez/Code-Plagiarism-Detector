import java.util.Scanner;
import java.util.ArrayList;

public class recycled {
	public static void main(String [] args){
		Scanner Keyboard = new Scanner(System.in);
		int first, second;
		int n, m;
		String current = null, temp;
		Character current2;
		int whitespace = 0;
		int testCase;
		int testLength;
		String nString, mString;
		int recycledNumber = 0;
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> recycled = new ArrayList<Integer>();
		ArrayList<String> nArray = new ArrayList<String>();
		ArrayList<String> mArray = new ArrayList<String>();
		boolean multiple = false;

		testCase = Keyboard.nextInt();
		Keyboard.nextLine();

		for (int a = 0; a < testCase; a++){
			input.add(Keyboard.nextLine());
		}

		for (int a = 0; a < testCase; a++){
			for (int i = 0; i < input.get(a).length(); i++){
				if (input.get(a).charAt(i) == ' '){
					whitespace = input.get(a).indexOf(' ');
					break;
				}
				else{
					if (i == 0){
						current2 = input.get(a).charAt(i);
						current = current2.toString();
					}
					else{
						current2 = input.get(a).charAt(i);
						temp = current2.toString();
						current = current.concat(temp);
					}
				}
			}
			first = Integer.parseInt(current);
			for (int i = whitespace+1; i < input.get(a).length(); i++){
				if (i == whitespace+1){
					current2 = input.get(a).charAt(i);
					current = current2.toString();
				}
				else{
					current2 = input.get(a).charAt(i);
					temp = current2.toString();
					current = current.concat(temp);
				}
			}
			second = Integer.parseInt(current);

			for (int i = first; i <= second; i++){
				for (int j = first; j <= second; j++){
					n = i;
					m = j;

					if (m>=n)
						break;

					nString = Integer.toString(n);
					mString = Integer.toString(m);

					testLength = Integer.toString(m).length();

					for (int k = testLength; k > 0; k--){
						current = nString.substring(k-1, testLength).concat(nString.substring(0, k-1));
						if (current.equals(mString)){
							for (int l = 0; l < nArray.size(); l++){
								if (nString.equals(nArray.get(l)) && mString.equals(mArray.get(l)))
									multiple = true;
							}
							nArray.add(nString);
							mArray.add(mString);
							if (!multiple){
								recycledNumber++;
							}
							multiple = false;
						}
					}
				}
			}
			recycled.add(recycledNumber);
			recycledNumber = 0;
			nArray.clear();
			mArray.clear();
		}

		for (int i = 0; i < recycled.size(); i++){
			System.out.println("Case #" + (i+1) + ": " + recycled.get(i));
		}
	}
}
