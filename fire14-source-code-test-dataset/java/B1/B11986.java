import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;


public class qual3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\Users\\zyra\\Desktop\\codejam\\qual3.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			int A;
			int B;
			line = br.readLine();
			int count = Integer.parseInt(line);
			int[] output = new int[count];
			Vector<String> poss = new Vector<String>();
			Vector<String> posses = new Vector<String>();
			for(int hh=0; hh<count; hh++){
				posses.clear();
				line = br.readLine();
				
				String[] split =line.split(" ");
				A = Integer.parseInt(split[0]);
				B = Integer.parseInt(split[1]);
				
				//System.out.println(A+" "+B);
				
				int recycled = 0;
				
				for(int m=A; m<=B; m++){
					String mStr = String.valueOf(m);
					/*
					//no leading zeros
					if(m%10 == 0){
						continue;
					}*/
					//no mirror integers, n and m uniqueness
					
					Boolean valid = false;
					for(int p=0; p<mStr.length(); p++){
						if(mStr.charAt(p) != mStr.charAt((p+(mStr.length()-1))%mStr.length())){
							valid = true;
							break;
						}
					}
					if(valid == false)
						continue;
					
					
					for(int q=1; q<mStr.length(); q++){
						String rev = reverse(mStr, q);
						if(rev.charAt(0) == '0' || mStr.equals(rev)){
							continue;
						}
						int num = Integer.parseInt(rev);
						
						if(num <= B && num>=A && posses.contains(mStr+","+rev)!=true && 
								posses.contains(rev+","+mStr)!=true)
						{
							recycled++;
							posses.add(mStr+","+rev);
							posses.add(rev+","+mStr);
							//System.out.println(m+" "+num);
						}
					}
					
					
				}
				System.out.println("*************");
				poss.add(String.valueOf(recycled));
			}
			fr.close();
			br.close();
			
			
			FileWriter fw = new FileWriter("C:\\Users\\zyra\\Desktop\\codejam\\out1.txt");
			for(int i=0; i<count; i++){
				String out = "Case #"+(i+1)+": "+poss.elementAt(i);
				
				System.out.println(out);
				fw.write(out+"\r\n");
			}
			fw.flush();
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String reverse(String input, int number){
		String toRet = "";
		
		String sub = input.substring(number);
		String sub2 = input.substring(0, number);
		toRet = sub+sub2;
		
		return toRet;
	}
	
}