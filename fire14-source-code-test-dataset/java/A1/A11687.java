import java.util.Scanner;

public abstract class Question extends Thread{
	
	protected Result result;
	protected Counter counter;
	
	public Question(Result result, Counter counter)
	{
		super();
		this.result = result;
		this.counter = counter;
	}
	
	public abstract void readInput(Scanner scanner);
	
	public void solveTestCase(){
		setResult(solution());
	}
	
	public abstract String solution();

	public String getResult() {
		return result.output;
	}
	
	public void setResult(String output) {
		this.result.output = output;
	}
	
	public void run() {
		solveTestCase();
		//System.out.println(result);
		counter.increase();
	}
}
