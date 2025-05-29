import java.io.*;
import java.util.*;

public class dance {

    public static void main(String[] args) throws IOException {
        String filename="sample.txt";
        
        
        
        FileInputStream fstream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(fstream);

       FileWriter fstreamout = new FileWriter("out.txt");
       BufferedWriter out = new BufferedWriter(fstreamout);

       int n= Integer.parseInt(in.readLine());
      // System.out.println(n);
       for(int i=0;i<n;i++){
       
	   String test = in.readLine();
       String [] temp = test.split(" ");
	   int [] array = new int[temp.length-3];
       int num = Integer.parseInt(temp[0]);
       int sur = Integer.parseInt(temp[1]);
       int p = Integer.parseInt(temp[2]);
	   int count =0;
       //System.out.println(num+" "+sur+" "+p);
       for(int j=0;j<temp.length-3;j++){
       array[j]=Integer.parseInt(temp[3+j]);
       //System.out.println(array[j]);
	   }
      //Arrays.sort(array);

		for(int j=num-1;j>=0;j--){
		
			if(array[j]%3 == 0){
			
                if(array[j]/3 >= p) 
				count++;
				
                else if((array[j]+3)/3 >= p && sur>=1 && array[j]>=3)
				{ count++; sur--;}
				
				else ;
			}

           else if(array[j]%3 == 1)
           {
            if(((array[j]+2)/3) >= p && array[j]>=1) count++;
			else ;            

            }

            else 
           {
            if(((array[j]+1)/3) >= p && array[j]>=2) count++;
            else if(((array[j]+4)/3) >= p && sur>=1 && array[j]>=2) {count++; sur--;}
			else ;
            
            }

       }
       //kmkn
       out.write("Case #"+(i+1)+": "+count+"\n");
       }
		in.close();
       out.close();


       }
    }

