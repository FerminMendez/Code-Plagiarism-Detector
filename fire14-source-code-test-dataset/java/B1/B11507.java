import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Recycled {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BufferedReader bf=null;
			try {
				int T;
				bf = new BufferedReader(new FileReader("src/com/codejam/input/C-small-attempt0.in"));
				T = Integer.parseInt(bf.readLine());
				for(int i=0;i<T;i++){
					String line = bf.readLine();
					String[] numbers = line.split(" ");
					int A = Integer.parseInt(numbers[0]);
					int B = Integer.parseInt(numbers[1]);
					int seq = A;
					int count=0;
					
					while(seq<B){
						count += checkRecycle(String.valueOf(seq), numbers[0], numbers[1]);
						seq++;
					}
					
					System.out.println("Case #"+(i+1)+": "+count);
					
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} finally{
				bf.close();
			}
	
			
		}catch(IOException e){
			e.printStackTrace();
		}

	}
	
	public static int checkRecycle(String N,String min,String max){
	
		int mNum,nNum,maxNum;
		Set<String> uniqueNum = new HashSet<String>();
		
		for(int i=N.length()-1;i>0;i--){
			if( Character.getNumericValue(N.charAt(i)) > Character.getNumericValue(max.charAt(0)) ) continue;
			
			String M;
			M=N.substring(0, i);
			M=N.substring(i,N.length())+M;
		    mNum = Integer.parseInt(M);
			nNum = Integer.parseInt(N);
			maxNum = Integer.parseInt(max);
			if(mNum>nNum && mNum<=maxNum){
				uniqueNum.add(M);
			}
		}
		
		return uniqueNum.size();
	}

}
