import java.util.*;

public class RecycledNumbers
{
	static class Number implements Comparable<Number> {
		int[] digits;
		public Number(String str) {
			digits = new int[str.length()];
			for(int i=0;i<digits.length;i++)
				digits[i] = str.charAt(i) - '0';
		}
		public Number(Number old, int shift) {
			digits = new int[old.digits.length];
			for(int i=0;i+shift < digits.length;i++)
				digits[i] = old.digits[i+shift];
			for(int i=0;i<shift;i++)
				digits[digits.length - shift + i] = old.digits[i];
		}
		boolean isValid() {
			return digits[0] != 0;
		}
		public int compareTo(Number other) {
			if (digits.length != other.digits.length)
				return digits.length - other.digits.length;
			for (int i=0;i<digits.length;i++) {
				if (digits[i] != other.digits[i])
					return digits[i] - other.digits[i];
			}
			return 0;
		}
	}
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		int T = sc.nextInt();
		for(int i=1;i<=T;i++)
		{
			System.out.println("Case #"+i+": "+solveCase());
		}
	}
	static String solveCase()
	{
		int lower = sc.nextInt(); Number lowerNum = new Number(""+lower);
		int upper = sc.nextInt(); Number upperNum = new Number(""+upper);
		int res = 0;
		for(int i=lower; i<= upper; i++) {
			Number num = new Number(""+i);
			for(int j=1;j<num.digits.length;j++) {
				Number shift = new Number(num, j);
				if (num.compareTo(shift) == 0)
					break;
				if (num.compareTo(shift) < 0 && shift.compareTo(upperNum) <= 0) {
					res++;
				}
			}
		}
		return "" + res;
	}
}
