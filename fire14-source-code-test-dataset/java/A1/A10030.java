import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GoogleB {

	/**
	 * @param args
	 */
	public String szamol(String input){
		String result="";
		String a=input;
		Integer countgooglers=Integer.parseInt(a.substring(0,a.indexOf(' ')));
		a=a.substring(a.indexOf(' ')+1);
		Integer surprize=Integer.parseInt(a.substring(0,a.indexOf(' ')));
		a=a.substring(a.indexOf(' ')+1);
		
		Integer[] totalscore=new Integer[countgooglers];
		Integer all=0;
		Integer sur=0;
		if (countgooglers>0) {
			Integer minscore=Integer.parseInt(a.substring(0,a.indexOf(' ')));
			a=a.substring(a.indexOf(' ')+1);
			
			for (int i=0; i<countgooglers;i++){
				if (i<countgooglers-1){
					totalscore[i]=Integer.parseInt(a.substring(0,a.indexOf(' ')));
					a=a.substring(a.indexOf(' ')+1);
				}
				else totalscore[i]=Integer.parseInt(a);
			}


			for (int i=0; i<countgooglers;i++){
				int maxscore=(totalscore[i]%3==2)?totalscore[i]/3+2:totalscore[i]/3+1;
				if (totalscore[i]==0) maxscore=0;
				if (totalscore[i]>=27) 
					maxscore=10;
				if (maxscore<minscore) {

				}
				else if (maxscore==minscore) {
					if (totalscore[i]%3==1 || totalscore[i]==0 || totalscore[i]>28) all++;
					else sur++;
				}
				else all++;
			}
		}
		int maxgooglers=all;
		maxgooglers+=(sur<surprize)?sur:surprize;
		result=""+maxgooglers;
		return result;
	}
	
	public static void main(String[] args) {
		GoogleB a=new GoogleB();
		//String filename="input.txt";
		String filename="B-small-attempt1.in";
		String thisLine;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			BufferedWriter bw= new BufferedWriter(new FileWriter(filename+".out"));
			thisLine=br.readLine();
			Integer tnum=Integer.parseInt(thisLine);
		     for(int i=0;i<tnum;i++) { // while loop begins here
		    	 	thisLine=br.readLine();
		           System.out.println(thisLine);
		           System.out.println("Case #"+(i+1)+": "+a.szamol(thisLine)+"\n");
		           bw.write("Case #"+(i+1)+": "+a.szamol(thisLine)+"\n");
		         } // end while 
		        // end try
		     br.close();
		     bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
