import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class problem3 {
	public static void main(String[] args){
		try{
			  // Create file 
			  FileWriter fstream1 = new FileWriter("E:/out.txt");
			  BufferedWriter outp = new BufferedWriter(fstream1);
			  try{
				  Scanner sc = new Scanner(new File("E:/C-small-attempt0.in"));
				  int cnt1=sc.nextInt();
				  cnt1=1;
				  while (sc.hasNextInt()) {
					  int low = sc.nextInt();
					  int high = sc.nextInt();
					  int cnt=0;
					  for(int i=low; i<=high;i++){
						  int y=i;
						  String str = new Integer(i).toString();
						  int[] sol = new int[str.length()];
						  int cn = 0;
						  for(int j=0;j<str.length(); j++){
							  while(y%10==0){
								  y=y/10;
								  j++;
							  }	  
							  int x=y%10;
							  y=y/10;
							  y+=x*(int)(Math.pow(10, (str.length()-1)));
							  if(y>i&&y<=high){
								  boolean rep = false;
								  for(int k=0;k<cn;k++){
									  if(y==sol[k])
										  rep = true;
								  }
								  if(rep==false){
									  cnt++;
									  sol[cn]=y;
									  cn++;
								  }
							  }
								  
						  }
						  
					  }
					  outp.write("Case #"+cnt1+": "+cnt+'\n');
					  cnt1++;
				  }
			  }catch(FileNotFoundException e){System.out.println("File not found");}
			  outp.close();
		}catch (Exception e){//Catch exception if any
		System.err.println("Error: " + e.getMessage());
		} 
	}
}
