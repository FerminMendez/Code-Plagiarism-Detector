import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class DancingWithTheGooglers {

	
	public static void main(String[] args) {
		JFileChooser chooser = new JFileChooser();
		int state = chooser.showOpenDialog(null);
		
		if(state == 0) {
			File file = chooser.getSelectedFile();
			
			try {
				FileInputStream fInputStream = new FileInputStream(file);
				DataInputStream dInputStream = new DataInputStream(fInputStream);
				BufferedReader br = new BufferedReader(new InputStreamReader(dInputStream));
				
				PrintWriter out = new PrintWriter(new FileWriter("output"));
				
				String str = br.readLine();
				int count = 1;
				
				while((str = br.readLine()) != null) {
					out.print("Case #" + count + ": ");
					
					Scanner scan = new Scanner(str);
					
					int numOfGooglers = scan.nextInt();
					int numOfSurprising = scan.nextInt();
					int atLeast = scan.nextInt();
					
					int answer = 0;
					
					Integer[] totalPoints = new Integer[numOfGooglers];
					
					for(int i=0; i<numOfGooglers; i++) {
						totalPoints[i] = scan.nextInt();
					}
					
					Arrays.sort(totalPoints, Collections.reverseOrder());
					
					for(int i=0; i<numOfGooglers; i++) {
						int base = totalPoints[i] / 3;
						int extra = totalPoints[i] % 3;
						
						if(base >= atLeast) {
							answer++;
							continue;
						} else {
							if(extra > 0) {
								if(base+1 >= atLeast) {
									answer++;
									continue;
								}
							}
						}
						
						if(numOfSurprising > 0) {
							if(base == 0) {
								continue;
							}
							
							if(extra == 2) {
								if(base+2 >= atLeast) {
									answer++;
									numOfSurprising--;
									continue;
								}
							} else if(extra == 1) {
								
							} else if(extra == 0) {
								if(base+1 >= atLeast) {
									answer++;
									numOfSurprising--;
									continue;
								}
							}
						}
					}
					
					count++;
					out.println(answer);
				}
				
				out.close();
				dInputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
