
public class Hehe {

	/**
	 * @param args
	 */
	public static int n(int A, int B){
		
		// TODO Auto-generated method stub
		int start=A;
		int end=B;
		int count=0;
		MyNumbers myNumbers = new MyNumbers();
		MyNumbers myCheck = new MyNumbers();
		for( int k = start; k<=end; k++)
		{
			int a =k;
			
			
			String s = Integer.valueOf(a).toString();
			for(int i=0; i<s.length(); i++)
			{
				CharSequence c = s.subSequence(0, i);
				String s2 = s.concat(c.toString());
				s2 = s2.substring(i);
				
				int n = Integer.parseInt(s2);

				if(n<=end && n>=start  && a!=n && !myCheck.numbers.contains(n))
				{
					//System.out.println(s+"  "+s2);
					myNumbers.add(n);
					myCheck.add(a);
					count++;
				}
				
			}
			//myNumbers.numbers.removeAll(myCheck.numbers);
			
		}
		
		System.out.println(myNumbers.numbers.size()+"  count: "+count);
		return count;

	}

}
