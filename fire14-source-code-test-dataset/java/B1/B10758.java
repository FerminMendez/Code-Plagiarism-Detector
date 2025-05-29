import java.io.*;
import java.util.*;
import java.lang.*;

public class Recycled {
	public static int cases = 0;
	public static int min[] = new int[50];
	public static int max[] = new int[50];
	public static int answer[] = new int[50];
	public static ArrayList<Integer> results = new ArrayList<Integer>();

	public static void main(String args[]) {
		File input = new File("Input.txt");
		File output = new File("Output.txt");
		loadGame(input);
		for(int i = 0; i < cases; i++){
			answer[i] = 0;
		}
		findAnswer();
		saveGame(output);
	}
	
	public static void findAnswer(){
		for(int i = 0; i < cases; i++){
			for(int j = min[i]; j <= max[i]; j++){
				String number = new Integer(j).toString();
				ArrayList<String> numberArray = new ArrayList<String>();
				for(int m = 0; m < number.length(); m++){
					numberArray.add(Character.toString(number.charAt(m)));
				}
				for(int k = 1; k < number.length(); k++){
					numberArray.add(0, numberArray.remove((number.length()-1)));
					String temp = "";
					ArrayList<String> tempNumberArray = new ArrayList<String>();
					tempNumberArray.addAll(numberArray);
					for(int m = 0; m < number.length(); m++){
						temp += tempNumberArray.remove(0);
					}
					int result = Integer.parseInt(temp);
					if(result >= min[i] && result <= max [i] && result > j){
						if(!results.contains(result)){
						answer[i]++;
						results.add(result);
						}
					}
				}
				results.clear();
			}
		}
	}
	
	public static void loadGame(File input){
		Scanner in;
		try {
			in = new Scanner(input);
			cases = in.nextInt();
			in.nextLine();
			for(int i = 0; i < cases; i++){
				min[i] = in.nextInt();
				max[i] = in.nextInt();
				if(min[i] > max[i]){
					int temp = min[i];
					min[i] = max[i];
					max[i] = temp;
				}
				in.nextLine();
			}
			in.close();
		}
		catch (StringIndexOutOfBoundsException e) { }
		catch (FileNotFoundException e) { }
		catch (NoSuchElementException e) { } 
		catch (NullPointerException e) { }
	}

	public static void saveGame(File name){
		PrintWriter out;
		try {
			out = new PrintWriter(name);
			for(int i = 1; i <= cases; i++){
				out.println("Case #" + i + ": " + answer[(i-1)]);
			}  
			out.close();
		}
		catch (FileNotFoundException e) { }
		catch (NullPointerException e) { }
	}

}