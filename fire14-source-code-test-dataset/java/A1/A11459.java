import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class source {
	
	public static void main(String args[ ]) throws IOException {		
		
		FileInputStream fstream = new FileInputStream("text.txt");
		DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  int c = 1;
		  int f = 0;
		  int sur = 0;
		  boolean b = false;
		  
		  br.readLine();
		  while ((strLine = br.readLine()) != null)   {
			String[] array = strLine.split(" ");
			int[] array2 = new int[array.length];
			
			for (int i = 0; i < array.length; i++) {
				array2[i] = Integer.parseInt(array[i]);
			}
			
			for (int s = 3; s<array2[0]+3; s++) {
				
				for (int  i = 0; i <= 10 && !b; i++) {
					for (int j = 0; j <= 10 && !b; j++) {
						for (int k = 0; k <= 10 && !b; k++) {
							
							if (i+j+k == array2[s]
							      && ((i >= array2[2]) || (j >= array2[2]) || (k >= array2[2]))
							      && ((i-j >= 0) && (i-j <= 1))
							      && ((i-k >= 0) && (i-k <= 1))
							      && ((k-k >= 0) && (j-k <= 1))) {
								b = true;
								//System.out.println(i + " " + j + " " + k);
							}
						}
					}
				}
				
				if (b) {
					f++;
					b=false;
				}
				else {
					b = false;
					for (int  i = 0; i <= 10 && !b; i++) {
						for (int j = 0; j <= 10 && !b; j++) {
							for (int k = 0; k <= 10 && !b; k++) {
								
								if (i+j+k == array2[s]
								      && ((i >= array2[2]) || (j >= array2[2]) || (k >= array2[2]))
								      && ((i-j >= 0) && (i-j <= 2))
								      && ((i-k >= 0) && (i-k <= 2))
								      && ((k-k >= 0) && (j-k <= 2))) {
									b = true;
									//System.out.println(i + " " + j + " " + k);
								}
							}
						}
					}
					if (b) {
						sur++;
						b=false;
					}
				}
			}
			
			if (sur >= array2[1]) {
				System.out.println("Case #" + c + ": " + (f + array2[1]));
			}
			else {
				System.out.println("Case #" + c + ": " + (f + sur));
			}
			f = 0;
			sur = 0;
			c++;
		  }
	}
}
