import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class RN
{
	public static Set<Pair<Integer, Integer>> RNPair = new HashSet<Pair<Integer, Integer>>();
	public static class Pair<L,R> {

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
		           this.right.equals(pairo.getRight());
		  }

		}
	public static void main(String[] args)
	{

		Scanner scnr = new Scanner(System.in);
		int T = scnr.nextInt();
		for (int t = 1; t <= T; t++)
		{
			RNPair.removeAll(RNPair);
			Integer first = scnr.nextInt();
			Integer last = scnr.nextInt();

			int ans = 0;
			for (int i = first; i < last; i++)
			{
				ans += check(first, last, i);
			}
			//ans /= 2;

			System.out.println("Case #" + t + ": " +RNPair.size());

		}

	}

	public static int check(Integer start, Integer end, Integer num)
	{
		String numStr = num.toString();
		int l = numStr.length();
		int count = 0;
		for (int i = 0; i < l - 1; i++)
		{
			String rotStr = numStr.substring(l - i - 1) + numStr.substring(0, l - i - 1);

			int rotStrNum = Integer.parseInt(rotStr);
			if (rotStrNum < start || rotStrNum > end)
				continue;
			
			if (rotStrNum <= num)
				continue;

			if (num.toString().length() != Integer.toString(rotStrNum).length())
				continue;
			

			if ((start <= num) && (num < rotStrNum) && (rotStrNum <= end))
			{
				count++;
				Pair<Integer, Integer> p = new Pair<Integer, Integer>(num, rotStrNum);
				RNPair.add(p);
				//System.out.println(num + " " + rotStrNum);
			}

		}
		return count;

	}

}
