import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


public class Jam {
	
	private static String in = "in";
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		parse(args);
		Parser parser = new Parser(in);
		
		//Map<Thread, Case> tasks = new HashMap<Thread, Case>();
		
		while (parser.hasNext()) {
			Case c = parser.nextCase();
			//Thread task = new Thread(c);
			//task.start();
			//tasks.put(task, c);
			c.run();
			System.out.println(c);
		}
		
		/*for (Thread task : tasks.keySet()) {
			Case c = tasks.get(task);
			task.join();
			System.out.println(c);
		}*/
	}

	private static void parse(String[] args) {
		if (args.length > 0)
			in = args[0];
	}
	
}