package er.dream.codejam.helpers;

import java.io.File;
import java.util.List;

public abstract class ProblemSolver {
	
	protected FileHandler fileHandler = new FileHandler();
	
	protected abstract List<String> handleInput();
	
	public void execute(){
		File[] files = fileHandler.listFiles();
		
		for(File f : files){
			long start = System.currentTimeMillis();
			fileHandler.loadFile(f);
			List<String> results = handleInput();
			fileHandler.writeOutput(results);
			fileHandler.closeConnection();
			long stop = System.currentTimeMillis();
			System.out.println("File "+f.getName()+" took me "+(stop-start)+"ms");
		}
	}

}
