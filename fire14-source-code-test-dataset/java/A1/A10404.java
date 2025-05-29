package codejam;
import java.util.Hashtable;
public class RecycledNumbers {
	@SuppressWarnings("unchecked")
	Hashtable h1; 
	@SuppressWarnings("unchecked")
	RecycledNumbers(){
		h1 = new Hashtable();
	}
	@SuppressWarnings("unchecked")
	long noOfPairs(long min, long max, long num){
		String sMin = ""+min;
		String sMax = ""+max;
		String sNum = ""+num;
		
		long countPairs = 0;
		
		int nod = sMin.length();
		int i = 0;
		char fd = sNum.charAt(0);
		for( i = 1; i < nod ; i++){
			
			String block = sNum.substring(i);
			if( block.charAt(0)=='0' || (block.charAt(0)> sMax.charAt(0)) || block.charAt(0)<fd)
				continue;
			else if( block.charAt(0)== sMax.charAt(0)){
				int j = 2;
				boolean can = true;
				for( ; j<= block.length() ;j++){
					String sTemp = block.substring(0,j);
					long temp = Long.parseLong(sTemp);
					temp *= (long)Math.pow(10, nod - j);
					if( temp > max){
						can = false;
						break;
					}
				}
				if( !can ){
					continue;
				}
			}
			
			String sPair = block + sNum.substring(0,i);					
			long pair = Long.parseLong(sPair);
			boolean contains = h1.containsKey(sNum+" "+sPair);
			if( pair > num && pair<=max && !contains){
				h1.put(sNum+" "+sPair, countPairs);
				countPairs ++;
			}
			
		}
		return countPairs;
	}	
	public static void main(String[]args){
		long i = 0;
		long count = 0;
		RecycledNumbers r1 = new RecycledNumbers();
		
		FileRead fr = new FileRead("C-small-attempt0.in");
		FileWrite fw = new FileWrite("C-small-ouput.txt");
		//FileRead fr = new FileRead("C-large-attempt0.in");
		//FileWrite fw = new FileWrite("C-large-ouput.txt");
		
		int t = fr.readNextInt();
		int j = 0;
		long A,B;
		
		for( ; j< t; j++){
			count = 0;
			String nextLine = fr.readNextLine();
			A = Long.parseLong(nextLine.split(" ")[0]);
			B = Long.parseLong(nextLine.split(" ")[1]);
			for( i = A; i < B; i++){
				count += r1.noOfPairs(A,B,i);				
			}
			fw.writeLine("Case #"+(j+1)+": "+count);
		}		
		fr.close();
		fw.close();
	}
	
}
