import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class problemC {
	public static void main (String[] argv) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("test.in")));
		PrintWriter pw = new PrintWriter(new FileOutputStream("result.txt"));
		int number = Integer.parseInt(in.readLine());
		String line = "";
		int cases;
		int base;
		int score;
		int l=1;
		for (int k=0;k<number;k++){
		line=(in.readLine());
		cases=0;
		String[] test=line.split(" ");
		int nbpeople=Integer.parseInt(test[0]);
		int surprise=Integer.parseInt(test[1]);
		int min=Integer.parseInt(test[2]);
		for (int i=3;i<test.length;i++){
			score=Integer.parseInt(test[i]);
			base=score/3;
			switch (score % 3){
			case 0:
				if (base>=min){
					cases++;
				}else{
					if ((surprise > 0)&&(base>0)&& ((base+1)>=min)){
						cases++;
						surprise--;
					}
				}
				break;
			case 1:
				if ((base >= min) || ((base+1) >=min)) {
					cases++;
				}else{
					if ((surprise >0)&&((base+1)>=min)){
						cases++;
						surprise--;
					}
				}
				break;
			case 2:
				if (((base+1)>min)|| (base >=min)){
					cases++;
				}else{
					if ((surprise >0)&& ((base+2)>= min)){
						cases++;
						surprise--;
					}
				}
				break;
			}
		}
		
		pw.append("Case #" + l + ": " + cases+ "\n");
		l++;
		//System.out.println (cases);
		
		}
		pw.flush();
	}
}