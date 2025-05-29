import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Vector;


public class dance {
	
	static Vector <String>surprise = new Vector<String>();
	static Vector <String>notSurprise = new Vector<String>();
	static int sur =0;
	

	
	public static void set(int mark,int p){
		
		int total =0;
		Vector <String>v = new Vector<String>();
		
		for(int x=0;x<=10;x++){
			for(int y=0;y<=10;y++){
				for(int z=0;z<=10;z++){
					//System.out.println(x+","+y+","+z);
					total=x+y+z;
					if(total==mark){
						if((x-y)>-3 && (x-y)<3){
							if((y-z)>-3 && (y-z)<3){
								if((z-x)>-3 && (z-x)<3){
									
									if(x>=y && y>=z){
										if((x-z)==2){
											v.add("y,"+mark+","+z+","+y+","+x);
										}else{
											v.add("n,"+mark+","+z+","+y+","+x);
										}
																			
									
									}else if(x>=z && z>=y){
										if((x-y)==2){
											v.add("y,"+mark+","+y+","+z+","+x);
										}else{
											v.add("n,"+mark+","+y+","+z+","+x);
										}
										
										
									}else if(y>=z && z>=x){
										if((y-x)==2){
											v.add("y,"+mark+","+x+","+z+","+y);
										}else{
											v.add("n,"+mark+","+x+","+z+","+y);
										}
										
										
									}else if(y>=x && x>=z){
										if((y-z)==2){
											v.add("y,"+mark+","+z+","+x+","+y);
										}else{
											v.add("n,"+mark+","+z+","+x+","+y);
										}	
										
										
									}else if(z>=y && y>=x){
										if((z-x)==2){
											v.add("y,"+mark+","+x+","+y+","+z);
										}else{
											v.add("n,"+mark+","+x+","+y+","+z);
										}
										
										
									}else if(z>=x && x>=y){
										if((z-y)==2){
											v.add("y,"+mark+","+y+","+x+","+z);
										}else{
											v.add("n,"+mark+","+y+","+x+","+z);
										}	
										//System.out.println(y+","+x+","+z);
									}
									
									
								}
							}
						}
						
					}
				}
			}
		}
		
		for(int i=0;i<v.size();i++){
			//System.out.println(v.get(i));
			for(int j=i;j<v.size();j++){
				if(v.get(i).equals(v.get(j)) && i!=j){
					v.remove(j);
					j=i-1;
				}
			}
		}
		
	
		
		for(int k=0;k<v.size();k++){
			String []split = v.get(k).split(",");
			if(split[0].equals("y")){
				if(Integer.valueOf(split[split.length-1])>=p){
					//selected.add(v.get(k));
					surprise.add(v.get(k));
				}
				
			}else{
				if(Integer.valueOf(split[split.length-1])>=p){
					//selected.add(v.get(k));
					notSurprise.add(v.get(k));
				}
				
			}
			
		}	
	}
	
	public static void main(String args[])
	 {
		int result=0;
		
		Vector <String>finalList = new Vector<String>();
		  String line;
	  int i=0;
	  try{
	  FileInputStream fstream1 = new FileInputStream("tB.txt");
	  DataInputStream in1 = new DataInputStream(fstream1);
	  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
	  FileWriter fw = new FileWriter("oB.txt");
	  BufferedWriter out = new BufferedWriter(fw);
	 
	  	  while ((line = br1.readLine()) != null)   {  
	  		

	  		if(i!=0){
	  			String outpt = "Case #"+i+": ";
	  			String brkline[]=line.split(" ");
	  			sur = Integer.valueOf(brkline[1]);
	  			int p = Integer.valueOf(brkline[2]);
	  			
	  			for(int j=3;j<brkline.length;j++){
	  				set(Integer.valueOf(brkline[j]),p);	  				
	  			}
	  			
	  			Vector <String>selected = (Vector) surprise.clone();
	  			
	  			
	  			for(int k=0;k<notSurprise.size();k++){	
	  				String linei[] = notSurprise.get(k).split(",");
	  				for(int m=0;m<selected.size();m++){
	  					String linej[] = selected.get(m).split(",");
	  					if(linei[1].equals(linej[1])){
	  						selected.remove(m);
	  						break;
	  					}
	  				}			
	  			}
	  			
	  			
	  			if(sur==0){
	  				result = notSurprise.size();
	  				outpt = outpt+result;
	  			
	  			}else{
	  				for(int x=0;x<selected.size() && finalList.size() < sur;x++){
	  					finalList.add(selected.get(x));				
	  				}
	  				if(sur>finalList.size()){
	  					for(int y=0;y<surprise.size() && finalList.size() < sur;y++){
	  						finalList.add(surprise.get(y));	
	  						String line1[] = surprise.get(y).split(",");
	  						for(int z=0;z<notSurprise.size();z++){
	  							String line2[] = notSurprise.get(z).split(",");
	  							if(line1[1].equals(line2[1])){
	  								notSurprise.remove(z);
	  								break;
	  							}
	  						}
	  					}
	  				}
	  				for(int x=0;x<notSurprise.size();x++){
	  					finalList.add(notSurprise.get(x));				
	  				}
	  				
	  				result = finalList.size();
	  				outpt = outpt+result;
	  				
	  			}
	  			out.write(outpt+"\n");
	  			System.out.println(outpt);
	  			}
	  		surprise.clear();
	  		notSurprise.clear();
	  		finalList.clear();
	  		i++;
	  	  }
	  
	  //Close the input stream
	  in1.close();
	  //Close the output stream
	  out.close();
	    }catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e);
	  }
		
		
	  }
	
}
