/**
 *
 *
 * @Author      :Yasith Maduranga(Merlin)
 * @version     :1.0
 * @Date        :2012/4/14
 * @Copyright GSharp Lab, All Rights Reserved....
 */
import java.io.*;
import java.util.*;

class dancinwith {
	public static void main(String args[]){
		try{
	    	BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
	    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt0.out")));

	    	int noOfCases = Integer.parseInt(br.readLine());

	    	for(int i=0;i<noOfCases;i++){
				String tmp[]=br.readLine().split(" ");
				int noOfGooglers=Integer.parseInt(tmp[0]);
				int noOfSuprisingScores=Integer.parseInt(tmp[1]);
				int bestResult=Integer.parseInt(tmp[2]);
				int maximumNo=0;

				for(int j=3;j<tmp.length;j++){
					int marks=Integer.parseInt(tmp[j]);
					int mod=marks/3;
					switch(marks%3){
						case 0:{
							if(mod>=bestResult){
								maximumNo++;
							}else{
								if(noOfSuprisingScores>0 && mod>0 && mod+1>=bestResult){
									maximumNo++;
									noOfSuprisingScores--;
								}
							}
							break;
						}
						case 1:{
							if(mod>=bestResult || mod+1>=bestResult ){
								maximumNo++;
							}else{
								if(noOfSuprisingScores>0 && mod+1>=bestResult){
									maximumNo++;
									noOfSuprisingScores--;
								}
							}
							break;
						}
						case 2:{
							if(mod+1>=bestResult || mod>=bestResult){
								maximumNo++;
							}else{
								if(noOfSuprisingScores>0 && mod+2>=bestResult){
									maximumNo++;
									noOfSuprisingScores--;
								}
							}
							break;
						}
					}
				}


				out.println("Case #"+(i+1)+": "+maximumNo);
	    	}



	    	out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	    	System.exit(0);
	}
}
