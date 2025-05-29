import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public final class problem1 {
	static int N;
	static int S;
	static int p;


	public static String getResult(int[] input){
		Arrays.sort(input);
		
		int min;
		if(p < 2)
			min = p;
		else
			min = p + (p-2) + (p-2);
			
		int sur = S;
		int total = 0;
		for(int i = 0 ; i < input.length ; i++){
			//System.out.print(input[i] + " " + min);
			//large than min surprise -> will handle this value
			if(input[i] >= min && input[i] <= 28){
				if(input[i] % 3 == 2){ //value like 11
					if(sur > 0){
						int large = input[i] / 3 + 2;
						if(large >= p){
							total++;
							sur--;
						}
					}else{
						int large = input[i] / 3 + 1;
						if(large >= p){
							total++;
						}
					
					}
					
				}else if(input[i] % 3 == 1){//value like 13
					if(sur > 0){
						int large = input[i] / 3 + 1;
						if(large >= p){
							total++;
							sur--;
						}
					}else{
						int large = input[i] / 3 + 1;
						if(large >= p){
							total++;
						}
					
					}
				
				
				}else{ // valeu like 15
					
					if(sur > 0){
						int large = input[i] / 3 + 1;
						if(large >= p){
							total++;
							sur--;
						}
					}else{
						int large = input[i] / 3;
						if(large >= p){
							total++;
						}
					}
				
				}
			
			}else if(input[i] > 28){
				total++;
			}
		
		}
		//System.out.println();
		return Integer.toString(total);
	}
	
	

	public static void main(String[] args){
		try{
			//Scanner sc = new Scanner(new File("yo.txt"));
			Scanner sc = new Scanner(new File("B-small-attempt0.in"));
			FileWriter fw = new FileWriter("small.txt");
		
			String tmp = sc.nextLine();
			int step = Integer.valueOf(tmp);
		
			int counter = 1;
			while(sc.hasNextLine()){

				String s = sc.nextLine();
				Scanner ssc = new Scanner(s);
				N = ssc.nextInt();
				S = ssc.nextInt();
				p = ssc.nextInt();
				
				int[] arr = new int[N];
				for(int i = 0 ; i < N ; i++)
					arr[i] = ssc.nextInt();

				String xx = getResult(arr);
				System.out.println("Case #" + counter + ": " + xx);
				
				
				fw.write("Case #" + counter + ": " + xx);
				fw.write("\n");
				counter++;
				if(step < counter)
					break;
			}
			fw.close();
		}catch(Exception e){}
		
	}
	
}