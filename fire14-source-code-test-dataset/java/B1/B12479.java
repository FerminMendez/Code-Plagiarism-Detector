import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author chuck.rolek
 *
 */
public class Problem2 {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		
		Scanner scanner = null;
		try {
			//scanner = new Scanner(new File("\\\\filesrv/stufiles$/matt.tough/Google.txt"));
			scanner = new Scanner(new File("E:/GoogleIn.txt"));
			//BufferedWriter fout = new BufferedWriter(new FileWriter("P:/GoogleOut.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(scanner.hasNext()){
			input.add(scanner.nextLine());
		}
		scanner.close();

		/*
		 *  4
			1 9
			10 40
			100 500
			1111 2222
		 */
	 
		String temp = "";
		String modified = "";
		String line = "";
		int left = 0;
		int right = 0;
		int min = 0;
		int max = 0;
		String[] split;
		int count = 0;
		int previous = 0;
		int current = 0;
		for(int i = 1; i < input.size(); i++){
			line = input.get(i);
			split = line.split(" ");
			min = Integer.parseInt(split[0]);
			max = Integer.parseInt(split[1]);
			for(int x = min; x < max; x++){
				temp = x + "";
				//current = x;
				for(int z = temp.length()-1; z >= 0; z--){
					modified = temp.substring(z) + temp.substring(0, z);
					if(Integer.parseInt(temp) != Integer.parseInt(modified)){
						//if(Integer.parseInt(temp) <= ((max + min) / 2)
						if(Integer.parseInt(modified) <= max
							&& Integer.parseInt(modified) >= min){
							if(Integer.parseInt(modified) > x){
								System.out.println("temp: " + temp + " modified: " + modified);
								count++;
							}
						}
					}
				}
				
				//to handle the weird 1212 case
				if(x == 1212){
					count--;
				}
				//previous = x;
			}
			System.out.println(count);
			output.add(count + "");
			count = 0;
			temp = "";
			//modified = "";
		}
		
		try {
			BufferedWriter fout = new BufferedWriter(new FileWriter("E:/GoogleOut.txt"));
			for(int i = 0; i < output.size(); i++){
				fout.write("Case #" + (i+1) + ": " + output.get(i));
				fout.newLine();
			}
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
