/**

 E-Mail : dibakar.nandi@gmail.com
 Short Name : dibakar

 **/


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import sun.security.util.BigInt;

public class QC {
  
    public static void main(String[] args) {
       new QC().read();
    }
    public void read()
    {
    	String dirName="D:\\CodeJam\\";
    	//String fileName="A-test";
    	//String fileName="qcp";
    	String fileName="C-small-attempt1";//C-small-attempt0";
        String inputPath=dirName+fileName+".in";
        String outputPath=dirName+fileName+".out";
       
        try{
             FileInputStream fstream = new FileInputStream(inputPath);
             DataInputStream in = new DataInputStream(fstream);
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
             String strLine;
             String output="";
             String caseOutPut="";
            String inputs[];
            int caseCount=0;
            String answer;
            //Reading Input
             if((strLine = br.readLine()) != null){
                while ((strLine = br.readLine()) != null)   {
                     
                	int[] input = parseIntInput(strLine," ");
        
                	if("".equals(caseOutPut))
                   	  caseOutPut="Case #"+(++caseCount)+": "+solve(input[0],input[1]);
                     else
                   	  caseOutPut="\n"+"Case #"+(++caseCount)+": "+solve(input[0],input[1]);
                    output+=caseOutPut;
                 }
             }
             
             System.out.println(output);
             FileWriter fw = new FileWriter(outputPath);
             fw.write(output);
             fw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
       
    }
    public  String solve(int a,int b){
    	System.out.println("a ="+a);
    	System.out.println("b ="+b);
    	int count=0;
    	HashMap mymap=new HashMap();	
    	for(int i=a;i<b;i++)
    	{
            String num=""+i;
           // System.out.println("num ="+num);
           if(num.length()>1)
            for(int j=1;j<num.length();j++){
            	//System.out.println("num 1="+num.substring(0,0+j));
            	//System.out.println("num 2="+num.substring(j));
            	int newnum=Integer.valueOf(num.substring(j)+num.substring(0,0+j));
            	//System.out.println("get "+newnum);
            	if(a<=Integer.valueOf(num) && Integer.valueOf(num)<newnum && newnum<=b)
            	{
            	 //   System.out.println(num+","+newnum);

            		mymap.put(Integer.valueOf(num+newnum), num);
//            		
            	//	if(mymap.get(num)!=null && mymap.get(newnum)!=null && mymap.get(num).equals(mymap.get(newnum))))
            		//if(mymap.get(Integer.valueOf(num))!=null )
            		//{
            			//System.out.println((++count)+","+num+","+newnum);
            		//}
            		
            	}
            }
            
    	}
    	return ""+mymap.size();
    }
    public String[] parseStrInput(String data){
    	
    	
    	String dataList[]= new String[data.length()];
    	for(int i=0;i<data.length();i++)
    		    dataList[i]=""+data.charAt(i);
        
       
        return dataList;
    }

    public int[] parseIntInput(String data,String divider){
    	StringTokenizer st = new StringTokenizer(data,divider);
    	int dataList[]= new int[st.countTokens()];
        
        String token;
        int count=0;
        while(st.hasMoreTokens()) {
            token = st.nextToken();
            dataList[count++]=Integer.valueOf(token);
        
        } 
        return dataList;
    }
    public String[] parseStringInput(String data,String divider){
    	   
   	    StringTokenizer st = new StringTokenizer(data,divider);
   	
   	   String dataList[]= new String[st.countTokens()];
      
       String token;
       int count=0;
       while(st.hasMoreTokens()) {
           token = st.nextToken();
           dataList[count++]=token;
       
       } 
       return dataList;
  }
    
    
}
