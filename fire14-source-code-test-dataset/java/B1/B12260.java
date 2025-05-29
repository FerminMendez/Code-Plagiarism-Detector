package shakti;


import java.io.*;
import java.util.Scanner;

public class recycle 
{
    public static void main(String[] args) 
	{
		int cn=0;
        
        try 
		{
            
        	File file = new File("C-small-attempt0.in");
			FileOutputStream out=new FileOutputStream("output.out");
			Scanner in=new Scanner(new FileReader(file) );
			int n=in.nextInt();
		    while (n!=cn) {
				cn++;
				int count=0;
				int a=in.nextInt();
				int b=in.nextInt();
				int number=0;
				for(int i=a;i<=b;i++)
				{ 
					String str=i+"";
				
					do{
						char c=str.charAt(0);
						String newstr=str.substring(1, str.length()); 
						str=newstr+c;
					
						number=Integer.parseInt(str);
					
						if((number<i)&(a<=number)&(number<=b))
						{
							count++;
						}
						
					}while(number!=i);
				}


				out.write(("Case #"+cn+": "+count+"\n").getBytes());
				System.out.println("Case #"+cn+": "+count);
				
            }
        } catch (Exception e) {}
                
	}
}