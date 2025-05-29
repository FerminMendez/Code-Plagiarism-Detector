import java.util.Scanner;
import java.io.*;
//import java.util.Hashtable;


public final class problem2 {

	//private Hashtable<String, String> recode = new Hashtable<String, String>();
	
	public static String decode(int min, int max){
		int total = 0;
		for(int i = min ; i <= max ; i++){
			
			String n = Integer.toString(i);
			int len = n.length();
			n = n.concat(n);
			//System.out.println(len + " " + n);
			
			for(int j = 1 ; j < len ; j++){
				//System.out.print(n.substring(j, j+len) + " ");
				String tmp = n.substring(j, j+len);
				//System.out.print(tmp + " ");
				
				if(tmp.charAt(0) != '0'){
					int m = Integer.valueOf(tmp);
					
					if(m > i && m <= max){
						//System.out.println(i + " " + m);
						total++;
					}
				}
				
			}
			//System.out.println();
			
			
		}
		return Integer.toString(total);
	}


	
	public static void main(String[] args){

		try{
			Scanner sc = new Scanner(new File("C-small-attempt0.in"));
			FileWriter fw = new FileWriter("final.txt");
		
		
			String tmp = sc.nextLine();
			int step = Integer.valueOf(tmp);
		
			int counter = 1;
			while(sc.hasNextLine()){
				//System.out.print("Case #" + counter + ": "); 
				
				String s = sc.nextLine();
				Scanner ssc = new Scanner(s);
				int A = ssc.nextInt();
				int B = ssc.nextInt();
				
				
				//System.out.println(A + " " + B); 
				String xx = decode(A, B);
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