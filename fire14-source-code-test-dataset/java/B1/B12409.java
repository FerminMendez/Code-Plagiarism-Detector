package ggpackage;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class GgClass {


	private static String[] txt;
	private static String newtxt="";
	private static String oldtxt="";
	private static String[] oldtxt2;

	private static int numberC;


	public static void main(String[] args) throws FileNotFoundException {

		try{
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				oldtxt+=strLine+"\n";
			}
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		oldtxt2=oldtxt.split("\n");
		numberC = Integer.parseInt(oldtxt2[0]);
		ArrayList dub = new ArrayList();
		for(int L=1;L<=numberC;L++){
			int A = Integer.parseInt(oldtxt2[L].split(" ")[0]);
			int B = Integer.parseInt(oldtxt2[L].split(" ")[1]);
			int count = 0;
			//loop from A to mid point
			if(B<10){}else{
				for(int i=A;i<=B;i++){

					txt = String.valueOf(i).split("");
					//check for possible combination of an integer
					for(int k=2;k<txt.length;k++){
						newtxt+=txt[k];
						for(int j=1;j<txt.length-1;j++){
							if(j+k>txt.length-1){
								newtxt+=txt[j+k-(txt.length-1)];
							}else{
								newtxt+=txt[j+k];
							}
						}

						while(newtxt.startsWith("0")==true){
							newtxt=newtxt.substring(1);
							//System.out.print(newtxt+"\n");
							//count if an integer is recyclable
						}

						if(newtxt.isEmpty()){}else{
							if(Integer.parseInt(newtxt)>i){
								//System.out.print(newtxt+"\n");
								if(Integer.parseInt(newtxt)<=B){
									count++;
									dub.add(newtxt);
								}


							}
							newtxt="";
						}
						if(dub.size()==0){}else{
							
						for(int z=0;z<=dub.size()-1;z++){
							for(int y=z+1;y<=dub.size()-1;y++){
								if(dub.get(z).toString().contentEquals((dub.get(y).toString()))){
									count=count-1;
									
								}
							}
						}
						}

						
						
					}
					
					dub.clear();
				}
				
			}
			System.out.print("Case #"+L+": "+count+"\n");
		}
	}
}
