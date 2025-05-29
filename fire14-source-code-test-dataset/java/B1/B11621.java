import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {
	private static boolean isRecycled(long f,long s){

		String str1 = String.valueOf(f);
		String str2 = String.valueOf(s);
		
		if(str1.length()!=str2.length()){
			return false;
		}
		
		for(int i=1;i<str1.length();i++){
			String tmp = str1.substring(i)+str1.substring(0, i);
			if(tmp.equals(str2)){
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
			try{
				// Get the object of DataInputStream
				//DataInputStream in = new DataInputStream(System.in);
				BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
				FileWriter fstream = new FileWriter("out.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				String strLine;
				
				strLine = br.readLine();
				int T = Integer.valueOf(strLine);
				for(int i=0;i<T;i++){
					long counter = 0;
					strLine = br.readLine();
					String[] list = strLine.split(" ");
					long A = Long.valueOf(list[0]);
					long B = Long.valueOf(list[1]);
					for(long j=A;j<=B;j++){
						for(long k=j+1;k<=B;k++){
							if(isRecycled(j,k)){
								counter++;
							}
						}
					}
										
					out.write("Case #"+(i+1)+": "+counter+"\n");
				}

				//Close the input stream
				br.close();
				out.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}		

		}
}
