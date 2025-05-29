package googleCodeJam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i;
		
		//System.out.println("size of map: " + map.size());
		try{
			
			FileInputStream fstream = new FileInputStream("/Users/mkay/Documents/input_31.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			int input1, input2;
			String str1, str2;
			int count = 0,j,m,n,num;
			  while ((strLine = br.readLine()) != null)
			  {
				  //System.out.println (strLine);
				  
				  if(count != 0 )
				  {
					  map = new HashMap<Integer, Integer>();
					  input1 = Integer.parseInt(strLine.split(" ")[0]);
					  input2 = Integer.parseInt(strLine.split(" ")[1]);
					  num=0;
					  ArrayList<Integer> arr;
					  
					  for(i=input1;i<input2;i++)
					  {
						 if(i<=99){
							 j=i/10+(i%10)*10;
							 
							 if(j!=i && j>= input1 && j<= input2 && j <= 99 && j > i){
								 num++;
							 }
						 }else{
							 j=i/10+(i%10)*100;
							 //if(i==112)
								// System.out.println("first one : " + j);
							 if(j>= input1 && j<= input2 && j!=i && j >= 100 && j>i){
								 if(i<j)
								 {
									 n=i;m=j;
								 }
								 else{
									 n=j;m=i;
								 }
								 
								 if(!map.containsKey(n)||(map.containsKey(n) && map.get(n) != m)){
									 map.put(n, m);	
									 num++;
									 //System.out.println(n + " : " + m);
								 }
							 }
							 j=j/10+(j%10)*100;
							 //if(i==112)
								// System.out.println("second one : " + j);
							 if(j!=i && j>= input1 && j<= input2 && j>= 100 && j > i){
								 if(i<j)
								 {
									 n=i;m=j;
								 }
								 else{
									 n=j;m=i;
								 }
								 if(!map.containsKey(n)||(map.containsKey(n) && map.get(n) != m)){
									 map.put(n, m);	
									 num++;
									 //System.out.println(n + " : " + m);
								 }
							 }
						 }
					  }
					  //for(Integer k: map.keySet())
						//  System.out.println(k + " : " + map.get(k));
					  //System.out.println("Case #"+ count + ": " + map.size() + " input: " + input1 + " : " + input2 + " num " + num);
					  System.out.println("Case #"+ count + ": " + num);
				  }
				  count++;
				  
			  }			  
			  in.close();
			}catch (IOException e)
		    {
				System.err.println("Error: " + e.getMessage());
		    }		
	}

}