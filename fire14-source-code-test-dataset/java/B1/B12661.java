import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public class MainJam2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Jam\\teste.txt"));
		File file = new File("C:\\Jam\\saida.txt");
		FileWriter print = new FileWriter(file);
		
		int i = Integer.parseInt(in.readLine());
		
		int k = i;
		
		while(i > 0){
			
			ArrayList<String> list = new ArrayList<String>();
			
			int resp = 0;
			String integer [] = in.readLine().split(" ");
			
			int ini = Integer.parseInt(integer[0]);
			int end = Integer.parseInt(integer[1]);
			
			for(int j = ini; j <= end; j++){
				
				String reverse = ""+j;
				String ini_reverse = reverse;
				
					do{
						String ini_s = reverse.substring(0, 1);
						reverse = reverse.substring(1, reverse.length()) + ini_s;
								
						int int_reverse = Integer.parseInt(reverse);
						
						if(reverse.equals(ini_reverse))
							break;
						
						if(int_reverse <= end && int_reverse >= ini && !list.contains(reverse)){
							System.out.println((k - i + 1)+" : "+reverse + " " + j);
							list.add(""+j);
							resp++;
						}
						
					}
					while(!reverse.equals(ini_reverse));
				
			}
			
			print.write("Case #"+ (k - i + 1) +": "+resp+System.getProperty("line.separator"));
			
			i--;
		}
		print.close();


	}

}
