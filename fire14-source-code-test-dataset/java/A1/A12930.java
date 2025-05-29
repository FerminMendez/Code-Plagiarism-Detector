package google.loader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ChallengeLoader {

	private List<Challenge> challenges;
	private final ChallengeReader reader;


	public ChallengeLoader(ChallengeReader reader){
		this.reader = reader;
	}


	public List<Challenge> load(String aPath){
		try{
			String input = readFileAsString(aPath);
			readChallenges(input);
			return 	challenges;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
	}


	private String readFileAsString(String filePath) throws java.io.IOException{
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null) try { f.close(); } catch (IOException ignored) { }
		}
		return new String(buffer);
	}


	private void readChallenges(String input) {
		String delimiter;
		if(input.indexOf("\r\n")>0){
			delimiter="\r\n";
		}else{
			delimiter="\n";
		}
		String[] lines = input.split(delimiter);
		challenges = reader.createChallenges(lines);
	}


	public String getResult() {
		StringBuffer res = new StringBuffer();
		for(Challenge challenge : challenges){
			res.append(challenge.getResult());
		}
		return res.toString();
	}

}