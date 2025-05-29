import java.util.ArrayList;
import java.util.Scanner;


public class RecycleNumber {

	/**
	 * @param args
	 */
	int NoOfTestCase = 0;
	int A = 0;
	int B = 0;
	ArrayList<Integer> knownList = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		RecycleNumber rn = new RecycleNumber();
		Scanner sc = new Scanner(System.in);
		rn.NoOfTestCase = Integer.parseInt(sc.nextLine());
		for(int i=0;i<rn.NoOfTestCase;i++)
		{
			String input = sc.nextLine();
			String[] inputArr = input.split(" ");
			rn.A = Integer.parseInt(inputArr[0]);
			rn.B = Integer.parseInt(inputArr[1]);
			System.out.println("Case #"+(i+1)+": "+rn.solve());
		}
	}
	private int solve()
	{
		int result = 0;
		Integer currInt = 0;
		Integer newInt = 0;
		Integer temp = 0;
		String resultStr = "";
		boolean firstTime = true;
		for(int i=A;i<=B;i++)
		{
			currInt = i;
			if(true)
			{
				newInt = currInt;
				resultStr = newInt.toString();
				firstTime = true;
				while((newInt.compareTo(currInt)!=0) || firstTime)
				{
					temp = newInt;
					resultStr = rotate(resultStr);
					newInt = Integer.parseInt(resultStr);
					if(A>=newInt)
					{
						while(newInt>A)
						{
							newInt = temp;
							resultStr = rotate(resultStr);
							newInt = Integer.parseInt(resultStr);
						}
					}
					if(newInt>currInt)
					{
						if(A< newInt && B >= newInt)
						{
							knownList.add(newInt);
							result++;
						}
					}
					firstTime = false;
				}
			}
		}
		return result;
	}
	private String rotate(String s){
		String[] str = s.split("");
		String last = str[str.length-1];
		for(int i=str.length-1;i>1;i--)
		{
			str[i] = str[i-1];
		}
		str[1] = last;
		String result = "";
		for(int i=1;i<str.length;i++)
			result = result+str[i];
		return result;
	}

}
