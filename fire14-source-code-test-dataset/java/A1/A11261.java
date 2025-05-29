import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Dancers {
	public static void main (String args[]){
		if (args.length != 1){
			System.out.println ("Gimme the right arguments!");
			return;
		}
		File f = new File(args[0]);
		int testcases, surprise, p, n;
		ArrayList <Integer> scores = new ArrayList <Integer>();




		try{
			BufferedReader in = new BufferedReader (new FileReader(f));
			String s;
			testcases = Integer.parseInt(in.readLine());
			for (int i = 1; i<=testcases; i++){

				scores.clear();
				s = in.readLine();
				String temp [] = s.split(" ");
				n= Integer.parseInt (temp[0]);
				surprise = Integer.parseInt(temp[1]);
				p = Integer.parseInt(temp[2]);
				for (int j =3; j<temp.length; j++){
					scores.add(Integer.parseInt(temp[j]));
				}
				int count = 0;
				int countSpecial =0;
				for (int a : scores){
					boolean sp = true;
					boolean found = false;
					for (int q = p; q<=10; q++){
						int t = a - q;
						if(t >=0){
							int l = t/2;
							int h = t - l;
							if (Math.abs(q - l) <=2 && Math.abs(q - h) <=2){
								//	System.out.println(a + " " + + q + " " + t + " " + l + " " + h) ;
								if (Math.abs(q - l) <2 && (Math.abs(q - h) <2)){
									sp = false;	
									//		System.out.println("reg");
								}
								found = true;

							}
						}
					}

					if (found){
						count ++;
						if (sp){
							countSpecial++;
							//	System.out.println("hi");
						}
					}
				}
				//System.out.println(count + " " + countSpecial);
				if (countSpecial > surprise){
					count -= (countSpecial - surprise);
				}
				System.out.printf ("Case #%d: %d\n", i, count );
			}




		}

		catch (IOException e){

		}
	}

}
