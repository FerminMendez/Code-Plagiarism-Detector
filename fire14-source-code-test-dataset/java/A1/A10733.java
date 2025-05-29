import java.io.*;
import java.util.*;


public class Blank {
	public static int cases = 0;

	public static void main(String args[]) {
		File input = new File("Input.txt");
		File output = new File("Output.txt");
		saveGame(output, convertString(loadGame(input)));
	}

	public static String[] loadGame(File input){
		Scanner in;
		try {
			in = new Scanner(input);
			String[] output = new String[30];
			cases = in.nextInt();
			in.nextLine();
			for(int i = 0; i < cases; i++){
				output[i] = in.nextLine().toLowerCase();
			}
			in.close();
			return output;
		}
		catch (StringIndexOutOfBoundsException e) { 
		}
		catch (FileNotFoundException e) { 
		}
		catch (NoSuchElementException e) { 
		} 
		catch (NullPointerException e) { }
		return null;
	}

	public static void saveGame(File name, String[] output){
		PrintWriter out;
		try {
			out = new PrintWriter(name);
			for(int i = 1; i <= cases; i++){
				out.println("Case #" + i + ": " + output[(i-1)]);
			}  
			out.close();
		}
		catch (FileNotFoundException e) {

		}
		catch (NullPointerException e) {

		}
	}

	public static String[] convertString(String[] output){
		String[] returnString = new String[30];
		for(int i = 0; i < cases; i++){
			returnString[i] = Character.toString(convert(output[i].charAt(0)));
			for(int j = 1; j < output[i].length(); j++){
				returnString[i] += convert(output[i].charAt(j));
			}
		}
		return returnString;
	}

	public static char convert(char letter){
		char returnLetter;
		switch (letter) {
		case 'a':  returnLetter = 'y';
		break;
		case 'b':  returnLetter = 'h';
		break;
		case 'c':  returnLetter = 'e';
		break;
		case 'd':  returnLetter = 's';
		break;
		case 'e':  returnLetter = 'o';
		break;
		case 'f':  returnLetter = 'c';
		break;
		case 'g':  returnLetter = 'v';
		break;
		case 'h':  returnLetter = 'x';
		break;
		case 'i':  returnLetter = 'd';
		break;
		case 'j':  returnLetter = 'u';
		break;
		case 'k':  returnLetter = 'i';
		break;
		case 'l':  returnLetter = 'g';
		break;
		case 'm':  returnLetter = 'l';
		break;
		case 'n':  returnLetter = 'b';
		break;
		case 'o':  returnLetter = 'k';
		break;
		case 'p':  returnLetter = 'r';
		break;
		case 'q':  returnLetter = 'z';
		break;
		case 'r':  returnLetter = 't';
		break;
		case 's':  returnLetter = 'n';
		break;
		case 't':  returnLetter = 'w';
		break;
		case 'u':  returnLetter = 'j';
		break;
		case 'v':  returnLetter = 'p';
		break;
		case 'w':  returnLetter = 'f';
		break;
		case 'x':  returnLetter = 'm';
		break;
		case 'y':  returnLetter = 'a';
		break;
		case 'z':  returnLetter = 'q';
		break;
		default: returnLetter = ' ';
		break;
		}
		return returnLetter;
	}

}
