package fixjava;

public class StringUtils {

	/** Repeat the given string the requested number of times. */
	public static String repeat(String str, int numTimes) {
		StringBuilder buf = new StringBuilder(Math.max(0, str.length() * numTimes));
		for (int i = 0; i < numTimes; i++)
			buf.append(str);
		return buf.toString();
	}

	/**
	 * Pad the left hand side of a field with the given character. Always adds at least one pad character. If the length of str is
	 * greater than numPlaces-1, then the output string will be longer than numPlaces.
	 */
	public static String padLeft(String str, char padChar, int numPlaces) {
		int bufSize = Math.max(numPlaces, str.length() + 1);
		StringBuilder buf = new StringBuilder(Math.max(numPlaces, str.length() + 1));
		buf.append(padChar);
		for (int i = 1, mi = bufSize - str.length(); i < mi; i++)
			buf.append(padChar);
		buf.append(str);
		return buf.toString();
	}

	/**
	 * Pad the right hand side of a field with the given character. Always adds at least one pad character. If the length of str is
	 * greater than numPlaces-1, then the output string will be longer than numPlaces.
	 */
	public static String padRight(String str, char padChar, int numPlaces) {
		int bufSize = Math.max(numPlaces, str.length() + 1);
		StringBuilder buf = new StringBuilder(Math.max(numPlaces, str.length() + 1));
		buf.append(str);
		buf.append(padChar);
		while (buf.length() < bufSize)
			buf.append(padChar);
		return buf.toString();
	}

	/** Intern all strings in an array, skipping null elements. */
	public static String[] intern(String[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i].intern();
		return arr;
	}

	/** Intern a string, ignoring null */
	public static String intern(String str) {
		return str == null ? null : str.intern();
	}

}
