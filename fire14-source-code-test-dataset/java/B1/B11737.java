

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pair<L,R> {

	  private final L left;
	  private final R right;

	  public Pair(L left, R right) {
	    this.left = left;
	    this.right = right;
	  }

	  public L getLeft() { return left; }
	  public R getRight() { return right; }

	  @Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

	  @Override
	  public boolean equals(Object o) {
	    if (o == null) return false;
	    if (!(o instanceof Pair)) return false;
	    Pair pairo = (Pair) o;
	    return this.left.equals(pairo.getLeft()) &&
	           this.right.equals(pairo.getRight()) || this.left.equals(pairo.getRight()) &&
	           this.right.equals(pairo.getLeft());
	  }

	}


public class Dancing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int numberOfCases = Integer.parseInt(str);
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int j = 0; j < numberOfCases; j++) {
			String str1 = in.readLine();
			String delimiter = " ";
			String[] temp;
			temp = str1.split(delimiter);
			String lowerlimit = temp[0];
			String upperlimit = temp[1];
			int count = recycledInteger(upperlimit, lowerlimit);
			array.add(count);
		}
		for (int i = 0; i < array.size(); i++) {
			System.out.println("Case #"+(i+1)+": "+array.get(i));
		}
		

	}

	public static int recycledInteger(String upperlimit, String lowerlimit) {

		int lower = Integer.parseInt(lowerlimit);
		int upper = Integer.parseInt(upperlimit);
		// String.valueOf(i);
		int counter = 0;
		int temp = lower;
		ArrayList<Pair<Integer, Integer>> arraypairs = new ArrayList<Pair<Integer, Integer>>();
		while (temp <= upper) {
			String string = String.valueOf(temp);
			for (int i = 1; i < string.length(); i++) {
				String recycled = string.substring(i, string.length())
						+ string.substring(0, i);
				if (Integer.parseInt(recycled) >= lower
						&& Integer.parseInt(recycled) <= upper) {
					Pair<Integer, Integer> pair = new Pair<Integer, Integer>(
							Integer.parseInt(recycled), temp);
					if (Integer.parseInt(recycled) != temp) {
						if(!arraypairs.contains(pair)){
							//System.out.println(temp+"   "+recycled);
							counter++;
						}
						arraypairs.add(pair);
					}
				}
			}
			temp++;
		}
		return counter;
	}
}
