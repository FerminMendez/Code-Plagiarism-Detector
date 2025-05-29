import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class RecycledNumbers {
	public static void main(String[] args) throws Exception
	{
		FileReader fileReader=new FileReader("D://Recylced Numbers/input.in") ;
		PrintWriter printWriter=new PrintWriter("D://Recylced Numbers/output.out");
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		BufferedWriter bufferedWriter=new BufferedWriter(printWriter);
		String s,code;
		int counter=0;
		TestCase[] testCase=null;
		while((s=bufferedReader.readLine())!=null)
		{
			if(counter>0)
			{
				testCase[counter-1]=makeObject(s);
//				System.out.println(testCase[counter-1]);
//				printWriter.println("Case #"+counter+": ");
//				printWriter.flush();
			}
			else
				testCase=new TestCase[Integer.parseInt(s)];
			counter++;
		}
		
		ArrayList arrayList=null;
		
		for(int i=0;i<testCase.length;i++)
		{
			int c=i+1;
			int counter1=solveTestCase(testCase[i]);
			printWriter.println("Case #"+c+": "+counter1);
			printWriter.flush();
			System.out.println(counter1);
		}
		
				
		}

	private static int solveTestCase(TestCase testCase) {
		int counter=0;
		ArrayList arrayList=new ArrayList();
//		System.out.println(testCase.getA()+" "+testCase.getB());
		for(int i=testCase.getA();i<testCase.getB();i++)
		{
			counter=counter+checkRecycle(i,testCase.getB());

		}
//		System.out.println(counter);
		return counter;
	}

	private static int checkRecycle(Integer a, Integer b) {
//		if(a==451)
//			System.out.println("Yes loop is gong upto 451 "+b);
		String a1=""+a;
		String rem="";
		String num=""+a;
		boolean flag=true;
		int counter=0;
		for(int i=0;i<a1.length()-1;i++)
		{
				rem=num.substring(num.length()-1);
				num=num.substring(0,num.length()-1);
			//	System.out.println(rem+" "+num);
				if(num=="0")
					num=rem;
				else
					num=rem+num;
				if(Integer.parseInt(num)>a && Integer.parseInt(num)<=b)
				{
				//	System.out.println(a+" "+num);
					if(repeat(""+a) && flag==true)
					{
//						System.out.println("repeat "+a);
					//	counter++;
						flag=false;
					}
					else
					{
						counter++;
						flag=true;
					}
				}
			
		}
		
		return counter;
	}

	private static boolean repeat(String num) {
		boolean flag=false;
		HashSet hashSet=new HashSet();
		if(num.length()%2==0 && num.length()>2)
		{
			int i=0;
			while(num.length()>0)
			{
				hashSet.add(num.substring(num.length()-2));
				num=num.substring(0, num.length()-2);
				i=i+2;
				
			}
			flag=check(hashSet);
		}
		return flag;
	}
	private static boolean check(HashSet hashSet) {
		if(hashSet.size()>1)
			return false;
		return true;
	}
	

	private static TestCase makeObject(String s) {
		StringTokenizer stringTokenizer=new StringTokenizer(s);
		TestCase testCase=new TestCase();
		testCase.setA(Integer.parseInt(stringTokenizer.nextToken()));
		testCase.setB(Integer.parseInt(stringTokenizer.nextToken()));
		return testCase;
	}
	}
class TestCase {
	Integer a;
	Integer b;
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public TestCase(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}
	public TestCase() {
		
	}
	
	@Override
	public String toString() {
		return this.a+" "+this.b;
	}
	
}