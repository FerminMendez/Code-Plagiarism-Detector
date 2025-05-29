
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

class recyclednumbers {
	public static void main(String args[]){
		try{
	    	BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
	    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));

	    	int noOfCases = Integer.parseInt(br.readLine());

	    	for(int i=0;i<noOfCases;i++){
	    		String tmp[]=br.readLine().split(" ");
	    		long a=Long.parseLong(tmp[0]);
	    		long b=Long.parseLong(tmp[1]);
	    		long pairOfNo=0;
	    		ArrayList<Long> myArray=new ArrayList<Long>();
	    		myArray.add(a);

	    		for(long j=a;j<b+1;j++){
					long charLength=String.valueOf(j).length();
					if(charLength<=1){
						break;
					}
					for(long k=0;k<charLength-1;k++){
						String tmp1=String.valueOf(j).substring(0,(int)k+1);
						String tmp2=String.valueOf(j).substring((int)k+1);
						String newNo=tmp2+tmp1;
						if(Long.parseLong(newNo)<=b){
							if(!(Long.parseLong(newNo)==j)){
								if(!(Long.parseLong(newNo)<=j)){
									boolean isRepeated=true;
									for(long l=0;l<myArray.size();l++){
										if(myArray.get((int)l)==Long.parseLong(newNo)){
											isRepeated=true;
										}else{
											isRepeated=false;
										}
									}
									if(!isRepeated){
										pairOfNo++;
										myArray.add(Long.parseLong(newNo));
									}

								}
							}
						}
					}
	    		}
				out.println("Case #"+(i+1)+": "+pairOfNo);
	    	}



	    	out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	    	System.exit(0);
	}
}
