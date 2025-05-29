import java.util.*;
import java.io.*;

public class ProblemC {
	public static void main(String[] args){
		try{
			//Scanner scan = new Scanner(new File("C-small-attempt0.in"));
			Scanner scan = new Scanner(new File("C-small-attempt0.in"));
			int nLines = scan.nextInt();
			scan.nextLine();
			for(int testCase = 1; testCase <= nLines; testCase++){
				int x = scan.nextInt();
				int y = scan.nextInt();
				int recycled = 0;
				for(int a = x; a < y; a++){
					for(int b = a+1; b <= y; b++){
						if(isRecycled(a, b)){
							recycled++;
						}
					}
				}
				System.out.printf("Case #%d: %d\n", testCase, recycled);
			}
		} catch(FileNotFoundException fnfe){
			System.err.println("File Not Found");
		}
	}
	
	public static boolean isRecycled(int a, int b){
		String aStr = "" + a;
		String bStr = "" + b;
		char firstChar = aStr.charAt(0);
		int strLen = aStr.length();
		int startIndex = bStr.indexOf(firstChar);
		while(startIndex >= 0){
			if(testLocation(aStr, bStr, startIndex)){
				return true;
			}
			
			if(startIndex < (strLen-1)){
				int newIndex = bStr.substring(startIndex + 1).indexOf(firstChar);
				if(newIndex >= 0){
					startIndex += newIndex + 1;
				} else {
					break;
				}
			} else {
				startIndex = -1;
			}
		}
		return false;
	}
	
	public static boolean testLocation(String a, String b, int startPos){
		for(int i = 0; i<a.length(); i++){
			if(a.charAt(i) != b.charAt((i + startPos) %  b.length())){
				return false;
			}
		}
		return true;
	}
}