import java.util.Scanner;
import java.util.Vector;


public class ThreadDispatcher{
	
	private static final int CORES = 8;
	private Vector<SolveThread> threads = new Vector<SolveThread>(CORES);
	Scanner scan = new Scanner(System.in);
	private int curCase = 0, T = 0;
	
	public ThreadDispatcher(){
		System.out.println("Paste input for qualification round - problem C");
		T = Integer.parseInt(scan.nextLine());
		for(int i = 1; i <= CORES; i++){
			if(i <= T){
				String line = scan.nextLine();
				curCase++;
				String[] limitsStr = line.split("\\s"); 
				int A = Integer.parseInt(limitsStr[0]);
				int B = Integer.parseInt(limitsStr[1]);
				SolveThread st = new SolveThread(A, B, curCase,this);
				threads.add(st);
				st.run();
			}
		}
	}
	
	public void finish(SolveThread thread){
		System.out.println("Case #" + thread.casenb + ": " + thread.pairs);
		threads.remove(thread);
		if(curCase < T){
			String line = scan.nextLine();
			curCase++;
			String[] limitsStr = line.split("\\s"); 
			int A = Integer.parseInt(limitsStr[0]);
			int B = Integer.parseInt(limitsStr[1]);
			SolveThread st = new SolveThread(A, B, curCase,this);
			threads.add(st);
			st.run();
		}
	}
	
	public static void main(String[] args){
		ThreadDispatcher td = new ThreadDispatcher();
	}
}
