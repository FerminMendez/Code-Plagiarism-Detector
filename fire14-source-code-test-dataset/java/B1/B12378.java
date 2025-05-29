import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Recycled {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	    Scanner s = new Scanner(new File("C:\\Users\\Owner\\Desktop\\a-small.in"));
	    FileOutputStream fos = new FileOutputStream("C:\\Users\\Owner\\Desktop\\a-small.out");
		PrintWriter pw = new PrintWriter(fos);
		
		int testCases = s.nextInt();
		s.nextLine();
		for(int i = 0; i < testCases; ++i){
			int n = s.nextInt();
			int m = s.nextInt();
				
		    int result = 0;
			pw.print("Case #" + (i + 1) +": ");
		
			String nstr ;
			String mstr ;
			String temp;
			for(int k = m; k > n; --k){
				mstr = k + "";
				for(int p = n; p < m && p < k; p++){
					nstr = "" + p;
			        for(int q = 0; q < mstr.length(); ++q){
			        	temp = mstr.substring(0,mstr.length() - 1);
			        	mstr = mstr.charAt(mstr.length() - 1) + temp;
			        	if(mstr.equals(nstr)){
			        		result++;
			        		break;
			        	}
			        }
				}
			}
	
			
			pw.print(result);
		    if(i != testCases - 1) pw.println();
		   
	    }
	    
		pw.close();
		s.close();

	}

}
