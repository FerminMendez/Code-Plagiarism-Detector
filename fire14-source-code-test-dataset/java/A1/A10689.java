import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 */

/**
 * @author Manthravadi
 *
 */

class Googler{
	int surpriseValue,nonSurpriseValue;	
	boolean isSurprise;
	
}
public class Triplets {
	
	static int[] nonSurprise=new int[]{0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
	static int[] surprise=new int[]{-1,-1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10,-1,-1};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BufferedReader br = new BufferedReader(new FileReader("B-small-attempt1.in"));
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc=Integer.parseInt(br.readLine());
			int t = 1,len;
			FileChannel rwChannel = new RandomAccessFile("triplets.txt", "rw").getChannel();
			String string = new String();
			
			while(t<=tc){
				int count=0;
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				//System.out.println("t value:"+t);
				int[] myArr = new int[st.countTokens()];
				//System.out.println(myArr.length);
				//myArr[0]=n;myArr[1]=s;myAarr[2]=p;
				//System.out.println("token  value: "+st.countTokens());
				for(int i = 0,j=0;st.hasMoreTokens();i++,j++){
					//System.out.println("iteration: "+j);
					myArr[i]=Integer.parseInt(st.nextToken());
				}
					
				ArrayList<Googler> g = new ArrayList<Googler>();
				int p = myArr[2];
				int myArrLength = myArr.length;
				//System.out.println(myArrLength + "is the length");
				for(int i = 3;i<myArrLength;i++){
					//System.out.println("i is: "+i);
					//System.out.println(myArr[i]);
					//System.out.println(surprise[myArr[i]]);
					int s = surprise[myArr[i]];
					int ns = nonSurprise[myArr[i]];
					Googler ge = new Googler();
					if(p<=s || p<=ns || (s==-1 && p<=ns)){					
						if(p<=ns && p<=s){
							ge.isSurprise=false;
							ge.surpriseValue=s;
							ge.nonSurpriseValue=ns;
						}
						else{
							ge.isSurprise=true;
							ge.surpriseValue=s;
							ge.nonSurpriseValue=ns;
						}
						if(s==-1 && p<=ns){
							ge.isSurprise=false;
							ge.nonSurpriseValue=ns;
							ge.surpriseValue=s;
							
						}
						g.add(ge);
					//	System.out.println("Inserted successfully at: "+i);
						
					}	
					
				//	System.out.println("i value: "+i);
					
				}
				for(Googler ge:g){
					if(ge.isSurprise==false){
						count++;
						//System.out.println(count+"false");
					}
					else{
						if(ge.surpriseValue == -1?(ge.nonSurpriseValue>=p && (myArr[1]-- >0)?true:false):(ge.surpriseValue>=p && (myArr[1]-- >0)?true:false))
							count++;
						//System.out.println(count+"true");
					}
				}
				
				g=null;
				
				if(t!=tc)
					string+="Case #"+t+": "+count+"\n";
				
				else
					string+="Case #"+t+": "+count;
				
				t++;
				count = 0;
			}
			
			len = string.length();		
			byte[] buffer = string.getBytes();
			ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, len);
			wrBuf.put(buffer);
		}
		catch(ArrayIndexOutOfBoundsException aioobe){
			System.out.println(aioobe.getMessage()+" "+aioobe.getCause());
			aioobe.printStackTrace();
		}
		catch(IOException ioe){
			System.out.println("Error : "+ioe.getMessage());
			ioe.printStackTrace();
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
