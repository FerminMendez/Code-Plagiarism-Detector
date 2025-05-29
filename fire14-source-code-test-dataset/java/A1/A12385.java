import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Solution2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Solution2.calculteBestNum("6 2 8 29 20 8 18 18 21"));
		BufferedReader bReader = null;
		FileWriter fWriter = null;
		try {
			bReader = new BufferedReader(new FileReader(new File("B-small-attempt0.in")));
			fWriter = new FileWriter(new File("Output"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = Integer.parseInt(bReader.readLine());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 1; i < num + 1; i ++){
			String ssString = "";
			try {
				ssString = bReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ssString == null){
				break;
			}
			else if(ssString.trim() == ""){
				 continue;
			}
			try {
				fWriter.write("Case #"+ i +": " + Solution2.calculteBestNum(ssString));
				fWriter.write("\n");
				fWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int calculteBestNum(String scores){
		String[] tmp = scores.split(" ");
		int num = Integer.parseInt(tmp[0].trim());
		int surprising = Integer.parseInt(tmp[1].trim());
		int p = Integer.parseInt(tmp[2].trim());
		int key = 0;
		int finalnum = 0;
		for(int i = 0; i < num; i ++){
			int score = Integer.parseInt(tmp[i + 3].trim());
			if(score > 3 * (p - 1)){
				finalnum++;
			}
			else if(key < surprising){
				if(score >= p && score>= 3*p -4){
					finalnum++;
					key++;
				}
			}
		}
		return finalnum;
	}

}
