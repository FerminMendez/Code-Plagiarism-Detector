import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author ysan
 *
 */

public class Problem_B_small {
	

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt2.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("B-small-output2.txt"));
		
		int cases = Integer.parseInt(in.readLine());
		
		 for (int i = 1; i <= cases; i++) {
			 String text = in.readLine().trim();
			 
			 String[] val = text.split(" ");
			 
			 int count = 0;
			 int n = Integer.parseInt(val[0]);
			 int s = Integer.parseInt(val[1]);
			 int p = Integer.parseInt(val[2]);
			 int j;
			 
			
			 
			 for(int h=3; h<val.length;h++)
			 {
				 int target = Integer.parseInt(val[h]);

				 int ro = target / 3;
				 int l =target % 3;
				 int r[] = new int[3];
					 r[0] = ro;
					 r[1] = ro;
					 r[2] = ro;
					 
					 while(l>0)
					 {
						 if(l>0)
							 {r[0] = r[0] + 1;l--;}
						 if(l>0)
							{r[1] = r[1] + 1;l--;}
						 if(l>0)
							{r[2] = r[2] + 1;l--;}
					 }

				 boolean flag = false;

				 for(int c =0; c<3; c++)
					if(r[c] >= p){count++;flag=true;break;}
				 
				 if(!flag && s > 0)
				 {
					 int t = (target - p);
					 ro =  t/2;
					 l = t%2;
					 int r2[] = new int[3];
					 if(target > p){

						 r2[0] = p;
						 r2[1] = ro;
						 r2[2] = ro;
						 while(l>0)
						 {
							 if(l>0)
								{r2[1] = r2[1] + 1;l--;}
							 if(l>0)
								{r2[2] = r2[2] + 1;l--;}
						 }
						 if(r2[0] - r2[1]<=2 && r2[0] - r2[2]<=2)
						 {
							 r[0] = r2[0];
							 r[1] = r2[1];
							 r[2] = r2[2];
							 s--;
						 }
					 }
					 
					 for(int c =0; c<3; c++)
							if(r[c] >= p){count++;break;}
				 }
			 }
			 
			 
			 
			 out.write("Case #"+ i +": " + count);
			 out.newLine(); 
			 
		 }
		

		
		
		
		
		
		
		
		 
		
		in.close();
		out.close();
		
		

	}
	
	static void makeCombinations(int n, int p)
    {
        int sum,x,y,z;
        
        for(x=p ; x>=0 ; x--)
        {
        	 for(y=x ; y>=0 ; y--)
             {
        		 sum =x+y;
        		 if(sum==n)
        		 {
        			 continue;
        		 }
        		 else
        		 {
        			 for(z=p ; z>=0 ;  z--)
                     {
        				 sum=sum+z;
        				 if(sum<n)
                             continue;
                         else
                             break;
                     }
        		 }
             }
        }
        
        
        for(x=0 ; x<=10 ; x++)
        {
            for(y=x ; y<=10 ; y++)
            {
                sum =x+y;
                if(sum==n)
                    System.out.println(x + "  +  " + y);
                for(z=0 ; z<=10 ;  z++)
                {
                    sum=sum+z;
                    if(sum<n)
                        continue;
                    else
                        break;
                }//for ends
                 if(sum==n)
                {
                   System.out.print(x + "  +  " + y);
                   for(p=0 ; p<=z ; p++)
                           System.out.print("  +  " + p);
                   System.out.println();
 }//if ends
            }//for ends
        }//for ends
    }//method ends
		
}
