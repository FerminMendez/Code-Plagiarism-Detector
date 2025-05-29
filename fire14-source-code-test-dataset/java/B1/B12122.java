import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashSet;


public class shift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try{
			FileInputStream infile = new FileInputStream("in");
			DataInputStream datain = new DataInputStream(infile);
			//Reader reader = new InputStreamReader(new FileInputStream(infile));
			FileWriter writer = new FileWriter("out", false);
			String s = datain.readLine();
			Integer k = new Integer(s);
			
			for (int i=1;i<=k;i++){
				s = datain.readLine();
				String [] ABstring = s.split(" ");
				Integer A = new Integer(ABstring[0]);
				Integer B = new Integer(ABstring[1]);				
				int numShift = ABstring[0].length()-1;
				int numRecycledNum = 0;

				for (int n=A;n<B;n++)
				{
					HashSet<String> nSet = new HashSet<String>();
					int roundShift = 1;
					String stringN = Integer.toString(n);
					stringN = stringN.substring(1) + stringN.charAt(0);
					//nSet.add(stringN);
					
					while (roundShift<=numShift){
						Integer shiftedNum = new Integer(stringN);

						if (n<shiftedNum && shiftedNum<=B && !nSet.contains(stringN)){
							nSet.add(stringN);
							numRecycledNum++;
							System.out.println(numRecycledNum+": "+n+","+shiftedNum);
						}
						roundShift++;
						stringN = stringN.substring(1) + stringN.charAt(0);
					}
					
				}
				
				writer.append("Case #"+i+": "+numRecycledNum+"\n");
				
				
				
			}
			infile.close();
			datain.close();
			writer.close();
			
			
/*			System.out.print(i);
			writer.append("Case #1"+": ");
			int k = 2;
			while(datain.available()!=0){
				char c = (char) datain.readByte();
				if (c=='\n' && k<=i){
					writer.append('\n');
					writer.append("Case #"+k+": ");
					k++;
				}else{
					char d = mapChar(c);
					writer.append(d);
					//System.out.print(d);
				}
			}
//			writer.flush();
			infile.close();
			datain.close();
			writer.close();
*/			
			
		}catch(EOFException e){

		}catch (Exception e) {
			//infile.close();
            e.printStackTrace();
        }

	}

}
