package google.solver;

import google.loader.ChallengeLoader;
import google.loader.ChallengeReader;

import java.io.FileInputStream;
import java.util.Properties;

public class Solver implements ChallengeConstants{

	private ChallengeReader reader;
	private String inputFileName;
	private String result;
	private final String path;

	public Solver(String aPath) {
		this.path = aPath;
		init();
		solve();
		writeResult();
	}

	private void solve() {
		ChallengeLoader loader = new ChallengeLoader(reader);
		loader.load(inputFileName);
		result = loader.getResult();
	}

	private void init() {
		try{
			String propFileName = path+DELIMITER+CHALLENGE_DEFINITION;
			Properties properties = new Properties();
			properties.load(new FileInputStream(propFileName));
			inputFileName = path+DELIMITER+(String)properties.get("fileName");
			String readerClassName = (String)properties.get("readerClassName");
			reader = (ChallengeReader) Class.forName(readerClassName).newInstance();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public String getResult(){
		return result;
	}


	public void writeResult(){
		String result = getResult();
		write(result);
	}


	private void write(String text) {
		ProblemPackageCreator.write(getResultFileName(), text);
	}
	
	private String getResultFileName() {
		return inputFileName+".result";
	}

	public static void main(String[] args) {
		String problem = CHALLENGE_NAME;
		String path = BASE_DIR+DELIMITER+problem;
		Solver solver = new Solver(path);
		String result = solver.getResult();
		System.out.println(result);
	}
}
