package B;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws IOException {
		Scanner sc;
		try {
			sc = new Scanner(new File("B"));
			FileWriter writer = null;
			try {
				writer = new FileWriter(new File("output"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			int nbLines = Integer.parseInt(sc.nextLine());
			int currentLine = 1;
			
			int nbGooglers;
			int surprising;
			int p;
			String line ="";
			
			int currentGoogler;
			
			int g;
			
			int quotient;
			int reste;
			
			int res;
			while (currentLine <= nbLines) {
				writer.write("Case #"+currentLine+": ");
				res=0;
				currentGoogler = 1;
				line = sc.nextLine();
				Scanner scan = new Scanner(line);
				nbGooglers=scan.nextInt();
				surprising = scan.nextInt();
				p=scan.nextInt();
				while (currentGoogler <= nbGooglers) {
					g = scan.nextInt();
					quotient = g/3;
					reste = g % 3;
					System.out.println(g + " " +quotient + " " + p);
					if (g == 0 && p > 0)
						;
					else if (quotient >= p)
						res++;
					else {
						if ((quotient == (p - 1)) && (reste >= 1))
							res++;
						else if (quotient == (p - 2) && (reste == 2) && (surprising != 0)) {
							surprising --;
							res++;
						}
						else if (quotient == (p - 1) && (reste == 0) && (surprising != 0)) {
							surprising --;
							res++;
						}
							
					}
					currentGoogler++;
				}
				writer.write(res + "\n");
				currentLine++;
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
