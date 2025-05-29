import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecycledNumbers {
	
	public static void main(String args[]){
		RecycledNumbers r= new RecycledNumbers();
		r.convert(args[0]);
	}
	

	public void convert(String filename){
		try{
		File f= new File(filename);
		Scanner scan= new Scanner(f);
	   String firstLine= scan.nextLine();
	   int num= Integer.parseInt(firstLine);
	   int[] answer= new int[num];
	   int[][] testnum= new int[num][2];
	   
	   for(int i=0; i<num;i++){
		   int count= 0;
		String line= scan.nextLine();	
		String[] array = line.split(" ");
		 int[] pair= new int[]{Integer.parseInt(array[0]), Integer.parseInt(array[1])};
		 testnum[i]= pair;
		 
		 for (int k=pair[0];k<=pair[1];k++){
			 String strNum= ""+ k;
			 
			 for(int l= strNum.length()-1;l>0;l=l-1){
				 String pos= strNum.substring(l,strNum.length())+strNum.substring(0,l);
				 int j= Integer.parseInt(pos);
				 if (j<=pair[1] && j>=pair[0] && j>k){
					 count=count+1;
				 }
			 }
		 }
		 answer[i]= count;
		 System.out.println("Case #"+(i+1)+": "+count);
	   }
		}
	   catch(FileNotFoundException e){
		   }	
	   }
	

	}