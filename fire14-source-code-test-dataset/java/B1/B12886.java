import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String fileName = args[0];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter("numbers.out"));
			
			String T = br.readLine();
			//System.out.println(T);
			int numT = Integer.parseInt(T);
			
			
			int countReturn = 0;
			String returnLine;
			String line;
			String[] input;
			int n;
			int m;
			String temp;
			String leading;
			
			for(int i=1; i<=numT; i++){
				line = br.readLine();
				input = line.split(" ");
				n = Integer.parseInt(input[0]);
				m = Integer.parseInt(input[1]);
				//System.out.println("START " + n + " to " + m);
				
				for(int j=n; j<m; j++){
					temp = String.valueOf(j);
					//System.out.println("Begin " + temp);

					//System.out.print(temp + " ");
					for(int k=0; k<temp.length(); k++){
						leading = temp.substring(0, 1);
						temp = temp.substring(1, temp.length());
						temp = temp.concat(leading);
						
						//System.out.println(temp);
						
						int check = Integer.parseInt(temp);
						
						if(check <= m && check > j) {
							//System.out.println(j + " " + check);
							countReturn++;
						}
						
					}
					
				}
				
				//System.out.println(countReturn);
				
				returnLine = "Case #"+i+": "+countReturn;
				System.out.println(returnLine);
				bw.write(returnLine,0,returnLine.length());
				bw.flush();
				bw.newLine();
				countReturn = 0;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
