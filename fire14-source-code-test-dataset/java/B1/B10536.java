import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Recycle {

	// Method to Solve the Problem
	public void Solve(int c ,String a , String b){
		int first = Integer.parseInt(a);
		int second = Integer.parseInt(b);
		String test="";
		String convert;
		int num;
		int result=0;
		int result2=0;
		//		if(String.valueOf(b).length()==1){
		//			System.out.println("Case #"+c+": 0");
		//		}
		System.out.print("Case #"+c+": ");

		for (int i = first; i <= second; i++) {

			test=String.valueOf(i);
			if(test.length()==2){
				convert = test.charAt(1)+""+test.charAt(0);
				num = Integer.parseInt(convert);
				if(num<=second && num>=i && num!= i)
					result++;
			}	
			if(test.length()==3){
				convert = test.charAt(2)+""+test.charAt(0)+""+test.charAt(1);
				num = Integer.parseInt(convert);
				if(num<=second && num>=i && num!= i)
					result2++;
				convert = test.charAt(1)+""+test.charAt(2)+""+test.charAt(0);
				num = Integer.parseInt(convert);
				if(num<=second && num>=i && num!= i)
					result2++;
			}
		}
		result= (result) + (result2);
		System.out.println(result);
		//System.out.println(result2);

	}

	// Method to read from the file
	public void readFile() throws FileNotFoundException{
		int  iter=0;
		String s;
		try{
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			br.readLine();
			while ((s = br.readLine()) != null)   {
				String [] numbers = s.split(" ");
				Solve(++iter, numbers[0],numbers[1]);
			}
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	public static void main(String[] args) throws Exception {
		Recycle s = new Recycle();
		s.readFile();
	}
}
