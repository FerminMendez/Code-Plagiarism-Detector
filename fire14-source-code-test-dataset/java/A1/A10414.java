import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class B {


	public static void main(String[] args){


		String in ="small.txt";
		String out = "output.txt";
		Scanner sc;
		String answers[]=new String[3];
		try {
			sc = new Scanner(new File(in));
			int T = sc.nextInt();
			//System.out.println(sc.nextLine());
			sc.nextLine();
			answers = new String[T];
			for(int zz =0;zz<T;zz++)
			{
				int  N = sc.nextInt();
				int  S = sc.nextInt();
				int  p = sc.nextInt();
				int[] score = new int[N];
				int pMinSurprised,pMinNoSurprised;
				if(p==1){
					pMinSurprised = 1;
					pMinNoSurprised = 1;
				}
				else if(p==0){
					pMinSurprised = 0;
					pMinNoSurprised = 0;
				}
				else{
					pMinSurprised = p * 3 - 4;
					pMinNoSurprised = p * 3 - 2;
				}
				int nbSurprised = 0;
				int googlers = 0;

				for(int i =0;i<N;i++)
				{
					score[i] = sc.nextInt();
					if(score[i]>=pMinNoSurprised)
						googlers++;
					else if(score[i]>=pMinSurprised)
						nbSurprised++;
				}
				if(nbSurprised>S)
					googlers+=S;
				else
					googlers+=nbSurprised;
				int z = zz+1;
				answers[zz]="Case #"+z+": "+googlers+"\n";

			}




		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try
		{
			PrintWriter pw = new PrintWriter(out);
			for(int i=0;i<answers.length;i++)
				pw.println(answers[i]);
			pw.close();	

		}
		catch (Exception e){
			System.out.println(e.toString());
		}



	}

}
