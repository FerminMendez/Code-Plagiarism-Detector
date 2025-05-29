import java.util.*;
import java.io.*;

public class Recycler{

	//Vector<int> possibilities = new Vector<int>(0,0);
	private static int[] slider;
	private static String numString;
	private static int rotCounter;
	private static int pairCount;
	private static String elements, toPrint;
	private static int testNum;
	private static Stack stack = new Stack();
	
	
	
	public static void main(String args[]){
		int testCounter = 1;
		System.out.println("working .....");
		try{
		BufferedReader bf = new BufferedReader(new FileReader(args[0]));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out")), true);
		testNum = Integer.parseInt(bf.readLine());
		while((elements=bf.readLine()) != null){
		pairCount = 0;
		int end = Integer.parseInt(elements.split(" ")[1]);
		int start = Integer.parseInt(elements.split(" ")[0]);
		
		START : for (int i = start; i<=end;i++){
			if(Integer.toString(i).length() < 2) continue;
			for(int j=i+1; j<=end; j++){
				stackDigits(j);
				if(stack.search(i%10) == -1){
					stack = new Stack();
					continue;
				}else{
					//System.out.println(i+" "+j+" - "+stack.search(i%10));
					stack = new Stack();
				}
				
				for(int a : rotations(j)){
					if(a == i) pairCount++; //System.out.println("We've got a pair heuston "+i+" "+j);
					}
				
			}
		}
		toPrint = "Case #"+testCounter+": "+pairCount;
		pw.println(toPrint);
		testCounter++;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Done!");
	}
	
	private static void stackDigits(int num){
		if(num/10 > 0) stackDigits(num/10);
		stack.push(num%10);
	}
	private static int[] rotations(int num){
		//possibilities.clear();
		numString = Integer.toString(num);
		rotCounter = 0;
		slider = new int[numString.length()];
		
		numString = numString.charAt(numString.length()-1)+numString.substring(0, numString.length()-1);
		slider[rotCounter] = Integer.parseInt(numString);
		
		while(num != slider[rotCounter]){
			rotCounter++;
			numString = numString.charAt(numString.length()-1)+numString.substring(0, numString.length()-1);
			slider[rotCounter] = Integer.parseInt(numString);
		}
		
		return slider;
	}

}