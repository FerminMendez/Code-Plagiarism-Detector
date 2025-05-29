import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;


public class bsp2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String inFile = "B-small-attempt0.in";
		String outFile = inFile + ".out";
		
		LineNumberReader lin = new LineNumberReader(new InputStreamReader(new FileInputStream(inFile)));
		PrintWriter out = new PrintWriter(new File(outFile));
		int NCASE = Integer.parseInt(lin.readLine());
		String line="";
		int erg=0;
		for(int CASE = 1; CASE <= NCASE; CASE++) {
			String [] ch=lin.readLine().split(" ");
			int googlers=Integer.parseInt(ch[0]);
			int sTriplets=Integer.parseInt(ch[1]);
			int bResult=Integer.parseInt(ch[2]);
			//System.out.println("Case #"+CASE);
			//System.out.println(googlers);
			//System.out.println(sTriplets);
			//System.out.println(bResult);
			for(int SCORE=3;SCORE<ch.length;SCORE++){
				//System.out.print(ch[SCORE]);
				int base=Integer.parseInt(ch[SCORE])/3;
				switch(Integer.parseInt(ch[SCORE])%3){
					case 0:
						if(base >=bResult) erg++;
						else{
							if(sTriplets>0 && base>0 && base+1 >=bResult){
								erg++;
								sTriplets--;
							}
						}
						break;
					case 1:
						if(base>=bResult||base+1>=bResult) erg++;
						else{
							if(sTriplets>0 && base>0 && base+1 >=bResult){
								erg++;
								sTriplets--;
							}
						}
						break;
					case 2:
						if(base+1>=bResult||base>=bResult) erg++;
						else{
							if(sTriplets>0 && base>0 && base+2 >=bResult){
								erg++;
								sTriplets--;
							}
						}
						break;
				}
			}
			out.println("Case #" + CASE + ": "+erg);
			erg=0;
		}
		
		lin.close();
		out.close();
	}

}
