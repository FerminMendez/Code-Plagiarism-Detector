import java.util.*;
import java.io.*;
import java.math.*;

public class Prac3 {
	public static String shift(String i){
		String num=i;
		String num2=num.substring(num.length()-1,num.length())+num.substring(0,num.length()-1);
		return num2;
	}
	public static boolean rec(Integer a, int b){
		Integer original=a;
		
		
		
		return false;
	}
	public static void main(String[] arg){
		try{
			Scanner in=new Scanner(new File("sample"));
			//BufferedReader br=new BufferedReader(new FileReader("sample"));
			//int numCases=in.nextInt();//br.readLine();br.readLine();
		//	BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
			int numCases=in.nextInt();
			int counter=1;
			//in.nextLine();
			counter=1;
			while (counter!=numCases+1){
				Integer A=in.nextInt();
				Integer B=in.nextInt();
				ArrayList<Integer> track=new ArrayList<Integer>();
				if (B.toString().length()<2){
					System.out.println("Case #"+counter+": "+0);
				}else{
					for (Integer i=A;i<=B;i++){
						Integer original=i;
						String marker=shift(original.toString());
				
						while (!(marker.equals(original.toString()))){
							//System.out.println(marker+ " " +original);
							if (Integer.parseInt(marker)>original 
									&& Integer.parseInt(marker)<=B 
									){//&& !(track.contains(marker))
								track.add(Integer.parseInt(marker));
								track.add(original);
							//	marker=original.toString();
								marker=shift(marker);
							}else{
								marker=shift(marker);
							}
						    //System.out.println(marker==original);
							
						}
					}
					System.out.println("Case #"+counter+": "+track.size()/2);
				}
				
				
				counter++;
			}
		
		}catch (FileNotFoundException e){
			
		}catch (IOException e){
		}
	}
}