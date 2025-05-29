import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scores {
	private String fileName; 
	private FileReader file;
	private FileWriter fileOutput;
	private PrintWriter pw;
	private BufferedReader br;
	private int NbGog;
	private int NbSurp;
	private int maxScore;
	private int nbTest;
	private boolean verbose;


	public Scores (String[] args){
	
		try{
			 fileName =(args[0]);
			
			   file = new FileReader(fileName);
			    br = new BufferedReader(file);
			    fileOutput=new FileWriter(fileName+"_sol.txt");
	    		pw = new PrintWriter(fileOutput);
		    	
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
		   nbTest=1;
		   verbose=false;
	}

	
	public int readNum(String line, int startPos, int [] endPos) {
		String s="";
		int i=0;
		while(startPos<line.length() && line.charAt(startPos)!=' ')
		{
			s+=line.charAt(startPos);
			startPos++;
			i++;
		}
		if(endPos!=null)
			endPos[0]=startPos+1;
		return Integer.parseInt(s);
		
	}

	
	public void dealWithFile () throws IOException{
		float gogAvg=0;
		int total=0;
		int pos[]=new int [1];
		String line = br.readLine();
		int nbTests= Integer.parseInt(line);
		if(verbose)
			System.out.println("nbTests: " + nbTests );
		
		for(nbTest=1; nbTest<= nbTests; nbTest++)
		{
			total=0;
			line = br.readLine();
			NbGog=readNum(line, 0,pos);
			NbSurp=readNum(line, pos[0],pos);
			maxScore=readNum(line, pos[0],pos);
				
			if(verbose)
				System.out.print("\nNbGog: " + NbGog + " NbSurp: " +NbSurp +" maxScore: " + maxScore +" -> ");
			
			for(int j=0; j<NbGog;j++)
			
			{			
				int num=readNum(line, pos[0],pos);
				gogAvg=(float)num/(float)3;
				int gobAvgInt=(int) gogAvg;
				
				if(verbose)
					System.out.print( num + "("+ gogAvg+ ")");
				
				if(gobAvgInt+2>=maxScore)
				{
					float gogAvgDec= gogAvg-gobAvgInt;
									
					if(gogAvgDec<0.3 && gobAvgInt>=maxScore)  //NO *
					{
						if(verbose)
							System.out.println("eq.0");
						total++;
					}
					else if( gogAvgDec<0.3 &&  gobAvgInt-1>=0 && gobAvgInt+1<=10&& gobAvgInt+1>=maxScore&& NbSurp>0) // *
					{
						if(verbose)
							System.out.println("eq.0_S");
						total++;
						NbSurp--;						
					}
					else if(gogAvgDec>=0.3 && gogAvgDec<0.6 && gobAvgInt+1<=10  && gobAvgInt+1>=maxScore)
					{
						if(verbose)
							System.out.println("eq.33");
						total++;
					}
					else if(gogAvgDec>=0.6 && gobAvgInt+1>=maxScore && gobAvgInt+1<=10)
					{
						if(verbose)
							System.out.println("eq.66");
						total++;
					}
					else if(gogAvgDec>=0.6 && gobAvgInt+2>=maxScore && gobAvgInt+2<=10 && NbSurp>0)
					{
						if(verbose)
							System.out.println("eq.66_S");
						total++;
						NbSurp--;
						
					}
					else if(verbose)
						
						System.out.println("NO");
			
				}
			}
			//if(verbose)
				 System.out.println("Case #"+nbTest+": " +total);
				 pw.println("Case #"+nbTest+": " +total);
		
		}

	}
	
	public static void main(String[] args) throws IOException  {
				
		if(args.length!=1)
		{
			System.out.println("Usage: java AlphabetSoup.java <instanceFileName>");
			System.exit(0);
		}
		 Scores scores= new  Scores(args);
		 scores.dealWithFile();
		 if(scores.verbose)
			 System.out.println("End");

		 scores.file.close();
		 scores.fileOutput.close();

	}
}