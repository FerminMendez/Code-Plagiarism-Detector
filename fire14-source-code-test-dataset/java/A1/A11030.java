package fixjava;

import java.util.ArrayList;

/**
 * String splitter, this fixes the problem that String.split() has of losing the last token if it's empty. It also uses
 * CharSequences rather than allocating new String objects.
 */
public class Split {

	/**
	 * String splitter, this fixes the problem that String.split() has of losing the last token if it's empty. It also uses
	 * CharSequences rather than allocating new String objects.
	 */
	public static ArrayList<CharSequence> splitAsList(String str, String sep) {
		int strLen = str.length();
		int sepLen = sep.length();
		assert sepLen > 0;

		ArrayList<CharSequence> parts = new ArrayList<CharSequence>();
		for (int curr = 0; curr <= strLen;) {
			// Look for next token
			int next = str.indexOf(sep, curr);
			// Read to end if none
			if (next < 0)
				next = strLen;
			// Add next token
			parts.add(str.subSequence(curr, next));
			// Move to end of separator, or past end of string if we're at the end
			// (by stopping when curr <= strLen rather than when curr < strLen,
			// we avoid the problem inherent in the Java standard libraries of
			// dropping the last field if it's empty; fortunately
			// str.indexOf(sep, curr) still works when curr == str.length()
			// without throwing an index out of range exception).
			curr = next + sepLen;
		}
		return parts;
	}

	public static CharSequence[] splitAsArray(String str, String sep) {
		ArrayList<CharSequence> list = splitAsList(str, sep);
		CharSequence[] arr = new CharSequence[list.size()];
		list.toArray(arr);
		return arr;
	}

	public static ArrayList<String> splitAsListOfString(String str, String sep) {
		ArrayList<CharSequence> list = splitAsList(str, sep);
		ArrayList<String> listOfString = new ArrayList<String>(list.size());
		for (CharSequence cs : list)
			listOfString.add(cs.toString());
		return listOfString;
	}

	/** For compatibility only, slower because it creates new String objects for each CharSequence */
	public static String[] split(String str, String sep) {
		ArrayList<CharSequence> list = splitAsList(str, sep);
		String[] arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i).toString();
		return arr;
	}

	//	public static void main(String[] args) {
	//		System.out.println(splitAsList("", "\t"));
	//		System.out.println(splitAsList("\t", "\t"));
	//		System.out.println(splitAsList("a\t", "\t"));
	//		System.out.println(splitAsList("\ta", "\t"));
	//		System.out.println(splitAsList("\ta\t", "\t"));
	//		System.out.println(splitAsList("a\tb", "\t"));
	//		System.out.println(splitAsList("a\tb\t", "\t"));
	//		System.out.println(splitAsList("\ta\tb", "\t"));
	//		System.out.println(splitAsList("", "SEP"));
	//		System.out.println(splitAsList("SEP", "SEP"));
	//		System.out.println(splitAsList("aSEP", "SEP"));
	//		System.out.println(splitAsList("SEPaSEPb", "SEP"));
	//		System.out.println(splitAsList("aSEPbSEP", "SEP"));
	//	}

}
