package google.solver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ProblemPackageCreator  implements ChallengeConstants{

	private final String packageName;
	private String directoryName;
	private String challengeDef;
	private String readerName;
	private String challengeName;
	private String packagePath;


	ProblemPackageCreator(String packageName){
		this.packageName = packageName;
		packagePath = "google.contest."+packageName;
		directoryName = BASE_DIR+DELIMITER+packageName;
		challengeDef = BASE_DIR+DELIMITER+packageName+DELIMITER+CHALLENGE_DEFINITION;
		readerName = packageName.substring(0,1).toUpperCase()+packageName.substring(1)+"Reader";
		challengeName = packageName.substring(0,1).toUpperCase()+packageName.substring(1)+"Challenge";
	}

	private void create() {
		try{
			createDirectory();
			createTestIn();
			createChallengeDefinition2();
			createReader();
			createChallenge();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	private void createTestIn() {
		writeToPath(TEST_IN, "");
		
	}

	private void createChallenge() {
		String def ="package "+packagePath+";\n\n"+
				"import google.loader.Challenge;\n"+
				"import google.problems.AbstractChallenge;\n\n"+
				"public class "+challengeName+" extends AbstractChallenge implements Challenge {\n\n"+
				"public "+challengeName+"(int number) {\n"+
				"super(number);\n"+
				"setResult(\"\");\n"+
				"}\n"+
				"}\n";
		writeJava(challengeName, def);
	}

	private void createReader() {
		String def = "package "+packagePath+";\n\n"+
				"import google.loader.Challenge;\n"+
				"import google.problems.AbstractReader;\n\n"+
				"public class "+readerName+" extends AbstractReader {\n \n"+
				"@Override\n"+
				"protected Challenge createChallenge(int number) {\n"+
				"int theLine = getActualLine();\n"+
				"String[] lines = getLines();\n"+
				"int value = Integer.parseInt(getLines()[theLine]);\n"+
				challengeName+" chal = new "+challengeName+"(number);\n"+
				"setActualLine(theLine+1);\n"+
				"return chal;\n"+
				"}\n"+
				"\n"+
				"}\n";

		writeJava(readerName, def);
	}
	
	private void writeToPath(String fileName, String text){
		write(directoryName+DELIMITER+fileName, text);
	}

	private void writeJava(String baseName, String text) {
		writeToPath(baseName+".java", text);
	}

	private void createChallengeDefinition() {
		String def = "fileName="+TEST_IN+"\n"+
				"# fileName=A-small-practice.in\n"+
				"# fileName=A-large-practice.in\n"+
				"# fileName=B-small-practice.in\n"+
				"# fileName=B-large-practice.in\n"+
				"# fileName=C-small-practice.in\n"+
				"# fileName=C-large-practice.in\n"+
				"readerClassName="+packagePath+"."+readerName;
		write(challengeDef, def);
	}

	private void createChallengeDefinition2() {
		String def = "fileName="+TEST_IN+"\n"+
				"# fileName="+packageName+"-small-practice.in\n"+
				"# fileName="+packageName+"-large-practice.in\n"+
				"readerClassName="+packagePath+"."+readerName;
		write(challengeDef, def);
	}
	
	private void createDirectory() throws Exception{
		File file = new File(directoryName);
		if(! file.exists()){
			file.mkdir();
		}else{
			throw new RuntimeException("alreadyExisting");
		}
	}

	public static void main(String[] args) {
		String packageName =CHALLENGE_NAME;
		ProblemPackageCreator creator = new ProblemPackageCreator("A");
		creator.create();
		creator = new ProblemPackageCreator("B");
		creator.create();
		creator = new ProblemPackageCreator("C");
		creator.create();
	}

	public static void write(String aFileName, String text) {
		try{
			FileWriter fstream = new FileWriter(aFileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(text);
			out.close();
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}


}
