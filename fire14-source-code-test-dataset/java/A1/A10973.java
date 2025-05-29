import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class ProblemB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw=null;
		String input=null;
		StringBuffer output = null;
		String [] splInput=null;
		int N=0,thres=0,surpri=0;
		int counter=0;
		int []g=null;
		try{
			br=new BufferedReader(new FileReader(new File("C:/Users/DHAVAL/Downloads/InputY.txt")));
			bw=new BufferedWriter(new FileWriter("outputB.txt"));
			int count=Integer.parseInt(br.readLine());
			for (int i = 0; i < count; i++) {
				input=br.readLine();
				output = new StringBuffer("Case #"+(i+1)+": ");
				splInput=input.split(" ");
				N=Integer.parseInt(splInput[0]);
				thres=Integer.parseInt(splInput[2]);
				surpri=Integer.parseInt(splInput[1]);
				counter=0;
				g=new int[N];
				for (int j = 0; j < splInput.length-3; j++) {
					g[j]=Integer.parseInt(splInput[j+3]);
				}
				for (int k = 0; k < g.length; k++) {
					switch(g[k]%3){
					case 0:
						if(g[k]/3>=thres){
							counter++;
						}else if((g[k]/3+1)>=thres&&(g[k]/3-1)>=0&&surpri!=0){
							surpri--;
							counter++;
						}
						break;
					case 1:
						if((g[k]/3+1)>=thres){
							counter++;
						}
						break;
					case 2:
						if((g[k]/3+1)>=thres){
							counter++;
						}
						else if((g[k]/3+2)>=thres&&surpri!=0){
							surpri--;
							counter++;
						}
						break;
					}
				}
				bw.write(output.toString()+counter);
				bw.newLine();
			}
			bw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
