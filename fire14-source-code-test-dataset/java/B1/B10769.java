import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;


public class RecycledNumbers {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strNumberOfSentences = "";
		InputStreamReader converter = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(converter);
		    
		Integer numberOfSentences = -1;
		MyPair[] sentences = null;
		try {
			strNumberOfSentences = in.readLine();
		
			numberOfSentences = Integer.parseInt(strNumberOfSentences);
			sentences = new MyPair[numberOfSentences];
			
			for ( int i = 0; i < numberOfSentences; ++i) {
				sentences[i] = new MyPair(in.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( numberOfSentences == -1) {
			return;
		}
		
		Vector<MyPair> usedNumbers = new Vector<MyPair>();
		
		for ( int i = 0; i < numberOfSentences; ++i) {
			
			int curr = sentences[i].lowerLimit;
			while (curr < sentences[i].higherLimit) {
				StringBuilder sss = new StringBuilder("");
				
				sss.append(String.valueOf(curr));
				StringBuilder sss2 = new StringBuilder(String.valueOf(curr));
				for (int ii = 0; ii < sss.length()-1; ++ii) {
					
					char temp = sss2.charAt(0);
					sss2.replace(0, 0, String.valueOf(sss2.charAt(sss2.length()-1)));
					sss2.delete(sss2.length()-1, sss2.length());
					
					if (Integer.parseInt(sss2.toString()) <= sentences[i].higherLimit && 
						Integer.parseInt(sss2.toString()) >= sentences[i].lowerLimit &&
						
						Integer.parseInt(sss.toString()) < Integer.parseInt(sss2.toString()) ) {
						MyPair x = new MyPair(Integer.parseInt(sss.toString()),Integer.parseInt(sss2.toString()));
						boolean isFound = false;
						for (int kkk =0; kkk < usedNumbers.size(); ++kkk ){
							if ( usedNumbers.get(kkk).sameAs(x) ) {
								isFound = true;
							}
						}
						if ( !isFound ) {
							usedNumbers.add(x);
							//System.out.println("" + curr + ": " + x.lowerLimit + "," + x.higherLimit );
						}
					}
				}
				curr++;
			}
			
			System.out.println("Case #" + new Integer(i+1).toString() + ": " + usedNumbers.size() );
			SortedSet<Integer> usedNumbers2 = new TreeSet<Integer>();
			for (int kkk =0; kkk < usedNumbers.size(); ++kkk ){
				if ( !usedNumbers2.contains(usedNumbers.get(kkk).lowerLimit) ) {
					usedNumbers2.add(usedNumbers.get(kkk).lowerLimit);	
				}
				if ( !usedNumbers2.contains(usedNumbers.get(kkk).higherLimit) ) {
					usedNumbers2.add(usedNumbers.get(kkk).higherLimit);	
				}
			}
			for (Integer item: usedNumbers2 ){
				//System.out.println("" + item.toString() );	
			}
			
			usedNumbers.clear();
			
			
		}
		
		

	}

}



/*			
			int length = sentences[i].lowerLimit.length();
			
			if ( length == 0 || length == 1) {
				numberOfShits = 0;
			}
			else if ( length == 2) {
				int iii = 
						Character.digit(sentences[i].higherLimit.charAt(0),10) - 
						Character.digit(sentences[i].lowerLimit.charAt(0),10);
				
				numberOfShits *= iii * 2;
			}
			else if ( length > 2) {
				numberOfShits = (int) Math.pow(10, length-2);
				int iii = 
						Character.digit(sentences[i].higherLimit.charAt(0),10) - 
						Character.digit(sentences[i].lowerLimit.charAt(0),10);
				
				numberOfShits *= iii * iii;
				numberOfShits -= iii;
			}
			
			
			*/