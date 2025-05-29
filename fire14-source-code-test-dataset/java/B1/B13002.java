package mgg.problems;

import java.util.List;

import mgg.utils.CorrespondenceUtils;
import mgg.utils.FileUtil;
import mgg.utils.StringUtils;

/**
 * @author manolo
 * @date 14/04/12
 */
public class ProblemA {

	public final static String EXAMPLE_IN = "A-example.in";
	public final static String EXAMPLE_OUT = "A-example.out";

	public final static String A_SMALL_IN = "A-small-attempt1.in";
	public final static String A_SMALL_OUT = "A-small-attempt1.out";

	public final static String delim = " ";

	public static String solve(FileUtil util) {

		String line;
		List<Character> listOfCharacters;

		line = util.getLine();			

		listOfCharacters = StringUtils.allCharactersToList(line);

		char englishTranslation;
		StringBuilder solutionBuilder = new StringBuilder();

		for (char c : listOfCharacters){

			System.out.print("char: " + c);
			englishTranslation = CorrespondenceUtils.getGooglereseCorrespondence(c);
			System.out.println("(" + englishTranslation + ")");

			solutionBuilder.append(englishTranslation);

		}

		return solutionBuilder.toString();
	}
}