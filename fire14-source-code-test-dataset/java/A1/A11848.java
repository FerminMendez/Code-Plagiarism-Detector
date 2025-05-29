
import java.util.Scanner;

public abstract class ProgrammingProblem
{

	protected static final Scanner sc = new Scanner(System.in);

	protected static boolean DEBUG = false;
	protected abstract void print();

	protected abstract void readInput();

	protected abstract String execute();

	protected static void main(@SuppressWarnings("rawtypes") Class myclass) throws InstantiationException, IllegalAccessException
	{
		int T = sc.nextInt();
	
		for (int i = 0; i < T; i++)
		{
			ProgrammingProblem m = (ProgrammingProblem) myclass.newInstance();
			m.readInput();
			if (DEBUG)
			{
				m.print();				
			}
	
			System.out.println("Case #" + (i+1) + ": " + m.execute());
		}
	
	}

	protected static ProgrammingProblem getTestCase()
	{
		return null;
	}

	public ProgrammingProblem()
	{
		super();
	}

}