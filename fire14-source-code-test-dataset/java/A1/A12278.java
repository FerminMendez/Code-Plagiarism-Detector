/**
 * 
 */
package GoogleCodeJam2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author MArunkumar
 *
 */
public class DancingWithTheGooglers {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("DancingWithTheGooglersInput.txt"));
		FileWriter fw = new FileWriter("DancingWithTheGooglersOutput.txt");
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++){
			String datas[] = br.readLine().split(" ");
			int N = Integer.parseInt(datas[0]);
			int S = Integer.parseInt(datas[1]);
			int p = Integer.parseInt(datas[2]);
			ArrayList<Dancer> comp = new ArrayList<Dancer>();
			
			for(int j=0; j<N; j++){
				Dancer d = new Dancer(Integer.parseInt(datas[3+j]));
				d.evaluate(p);
				comp.add(d);
			}
			
			int result = 0;
			for(int j=0; j<comp.size(); j++){
				Dancer k = comp.get(j);
				if(k.pass){
					result++;
				}else if(k.passIfSurprised && S>0){
					result++;
					S--;
				}
			}
			
			fw.write("Case #"+i+": "+result+"\n");
		}
		fw.close();
	}

}

class Dancer{
	int ts = 0;
	int s1 = 0;
	int s2 = 0;
	int s3 = 0;
	boolean pass = false;
	boolean passIfSurprised = false;
	
	public Dancer(int ts){
		this.ts = ts;
	}
	
	void evaluate(int p){
		if(ts%3 == 0){
			s1 = s2 = s3 = ts/3;
		}else{
			if(ts%3 == 1){
				s1 = s2 = s3 = ts/3;
				s1++;
			}else{
				s1 = s2 = s3 = ts/3;
				s1++;
				s2++;
			}
		}
		if(s1>=p){
			pass = true;
		}else{
			setPassIfSurprised(p);
		}
	}
	
	void setPassIfSurprised(int p){
		if(s2>0 && s1==s2 &&s1<10){
			s1++;
			s2--;
		}
		if(s1>=p){
			passIfSurprised = true;
		}
	}
}
