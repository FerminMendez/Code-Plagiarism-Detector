public class CodeJamUtils {
	/**
	 * Makes sure that the line separator written by BufferedWriter is a single
	 * newline character
	 */
	public static void initLineEndings() {
		System.setProperty("line.separator", "\n");
	}
}
