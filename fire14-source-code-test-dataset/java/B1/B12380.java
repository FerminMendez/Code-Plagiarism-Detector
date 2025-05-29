package trupti;


import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ok2 
{
    public static void main(String[] args) 
	{
		int cn=0;
        
        try 
		{
            
			FileOutputStream out=new FileOutputStream("out9.out");
            Scanner scanner = new Scanner(new FileReader("C-small-attempt6.in"));
			int n=scanner.nextInt();
		//	scanner.nextLine();
            while (n!=cn) {
				cn++;
				int q=0;
				int a=scanner.nextInt();
				int b=scanner.nextInt();
				int no=0;
				for(int r=a;r<=b;r++)
				{ 
					String str=r+"";
				//	System.out.println("str"+str);
					do{
						char c=str.charAt(0);
						String str1=str.substring(1, str.length()); 
						str=str1+c;
					//	System.out.println(str);
						no=Integer.parseInt(str);
					//	System.out.println("no"+no);
						if((no<r)&(a<=no)&(no<=b))
						{//System.out.println("no:"+no+"  r:  "+r);
							q++;
						}
						
					}while(no!=r);
				}


				out.write(("Case #"+cn+": "+q+"\n").getBytes());
				
				// out.write(("\n").getBytes());
				 System.out.println("Case #"+cn+": "+q);
				 //System.out.println();
            }
        } catch (Exception e) {}
                
	}
}