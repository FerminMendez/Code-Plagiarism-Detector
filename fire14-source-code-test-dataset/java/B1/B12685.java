import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class jam {

	public static void main(String args[])
	{
		ArrayList<String> inp=read_fil("D:\\google_Jam\\C-small-attempt0.in");
		//		ArrayList<String> inp=read_fil("D:\\google_Jam\\A-large-practice.in");
		int lin_num=0;
		int T=Integer.valueOf(inp.get(lin_num));
		lin_num++;

		for(int kk=0;kk<T;kk++){

			String lin=inp.get(lin_num);
			lin_num++;
			String[] lins=lin.split(" ");
			int A=Integer.valueOf(lins[0]);
			int B=Integer.valueOf(lins[1]);
			int y=0;
			for(int i=A;i<=B;i++){
				ArrayList<String> array=new ArrayList<String>();
				String the_i=String.valueOf(i);
				for(int j=0;j<the_i.length()-1;j++){
					String new_i=shift(the_i);
					String temp=new_i;
					
					int dds=Integer.valueOf(new_i);
					new_i=String.valueOf(dds);
					
					if(!new_i.equals(the_i) && new_i.length()==the_i.length()){
						int i_new=Integer.valueOf(new_i);
						if((i_new>=A) && (i_new<=B) && i_new>i && !array.contains(the_i+"-"+new_i)){
							y++;
							array.add(the_i+"-"+new_i);
						}
					}
					the_i=temp;
				}
			}



			writeFile("Case #"+(kk+1)+": "+y);


		}


	}

	public static String shift(String old){
		String las_char=old.substring(old.length()-1);	
		String new_txt=las_char+old.substring(0, old.length()-1);
		return new_txt;

	}

	public static ArrayList<String> read_fil(String file){  
		ArrayList<String> arr=new ArrayList<String>(); 
		try{

			FileInputStream fstream = new FileInputStream(file);

			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null)   {
				arr.add(strLine);
			}

			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return arr;
	}

	public static void writeFile2(String ss) {
		String fileName = "D:\\google_Jam\\Output_test.txt";

		try {
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(ss);
			writer.write('\n');
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void writeFile(String ss) {
		String fileName = "D:\\google_Jam\\Output.txt";

		try {
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(ss);
			writer.write('\n');
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}