import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class Recycled {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
		{
			Scanner scanner = new Scanner(new File("./data/inRecycled"));
			PrintWriter writer = new PrintWriter(new File("./data/outRecycled"));
			int t = scanner.nextInt();
			scanner.nextLine();
			for(int i = 0; i < t; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				int res = 0;
				
				String check = "" + a;
				if(check.length() != 1)
				{
					
					for(int j = a; j <= b; j++){
						
						if(check.length() == 2)
						{
							String temp = "" + j;
							String other1 = temp.charAt(1) + "" + temp.charAt(0);
							int ot = Integer.valueOf(other1);
							if( ot <= b && j < ot){
								res++;
							}
						}
						else if(check.length() == 3)
						{
							String temp = "" + j;
							String other1 = "" + temp.charAt(2) + temp.charAt(0) + temp.charAt(1);
							String other2 = "" + temp.charAt(1) + temp.charAt(2) + temp.charAt(0);
							
							int ot1 = Integer.valueOf(other1);
							int ot2 = Integer.valueOf(other2);
							
							if ( ot1 <= b && j < ot1) {
								res++;
							}
							if ( ot2 <= b && j < ot2) {
								res++;
							}
						}
					}
				}
				writer.println("Case #" + (i+1) + ": " + res);

			}
			writer.close();
			scanner.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
