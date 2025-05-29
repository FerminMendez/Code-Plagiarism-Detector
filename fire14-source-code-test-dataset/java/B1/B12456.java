import java.io.*;
import java.util.StringTokenizer;

public class klick
{
    public static void main(String []args)
    {
        try{
            FileInputStream fstream = new FileInputStream("input.in");
              DataInputStream in = new DataInputStream(fstream);
              BufferedReader br = new BufferedReader(new InputStreamReader(in));
              String strLine;
              int n=0;
              int i;
            while ((strLine = br.readLine()) != null)   
            {
                n=n+1;
                if (n==1) i = Integer.parseInt(strLine);
                else System.out.println (parse(strLine,n-1));
            }
  in.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
    }

    private static String parse(String string1,int oo) 
    {
        String str="";
        int count =0;
        long aa = 0;
        long bb = 0; 
        
  	  StringTokenizer stringTokenizer = new  StringTokenizer(string1);
  	  	while(stringTokenizer.hasMoreTokens())
		  {
		  aa = Integer.parseInt(stringTokenizer.nextToken());
		  bb = Integer.parseInt(stringTokenizer.nextToken());
		  }
        
  	  for (long i = aa ;  i < bb;  i = i+1) 
  	  {    
  		  /////////////
  		  if(i<10)
  		  {
  			  count = 0;
  		  }
  		  /////////////////////////
  		  else if(i>=10 && i<100)
  		  {
  			int m = (int) (i/10);
  			int n = (int) (i%10);	
  			int nm = 10*n + m;
  			if(i<nm && nm<= bb)
  			{ count++;}
  			
  		  }
  		  ////////////////////////
  		else if(i>=100 && i<1000)
		  {
  			int mn = (int) (i/10);
  			int z = (int) (i%10);	
  			int zmn = 100*z + mn;
  			if(i<zmn && zmn<= bb)
  			{ count++;}  	
  			
  			
  			int m = (int) (i/100);
  			int nz = (int) (i%100);	
  			int nzm = 10*nz + m;
  			if(i<nzm && nzm<= bb)
  			{ count++;}  			
  			
  			
  			
		  }
  		  //////////////////////////////////////////
  		else if(i>=1000 && i<10000)
		  {
  			int mnz = (int) (i/10);
  			int t = (int) (i%10);	
  			int tmnz = 1000*t + mnz;
  			if(i<tmnz && tmnz<= bb )
  			{ count++;}  	

  			
  			int mn = (int) (i/100);
  			int zt = (int) (i%100);	
  			int ztmn = 100*zt + mn;
  			if(i<ztmn && ztmn<= bb)
  			{ count++;}  			
  	
  			
  			
  			int m = (int) (i/1000);
  			int nzt = (int) (i%1000);	
  			int nztm = 10*nzt + m;
  			if(i<nztm && nztm<= bb && (mn!=zt))
  			{ count++;}  			
  	  			
  			
  			
		  }
  		  ////////////////////////////////////
  		else if(i>=10000 && i<100000)
		  {
  			int mnzt = (int) (i/10);
  			int w = (int) (i%10);	
  			int wmnzt = 10000*w + mnzt;
  			if(i<wmnzt && wmnzt<= bb )
  			{ count++;}  	

  			
  			int mnz = (int) (i/100);
  			int tw = (int) (i%100);	
  			int twmnz = 1000*tw + mnz;
  			if(i<twmnz && twmnz<= bb)
  			{ count++;}  			
 	
  			
  			
  			int mn = (int) (i/1000);
  			int ztw = (int) (i%1000);	
  			int ztwmn = 100*ztw + mn;
  			if(i<ztwmn && ztwmn<= bb )
  			{ count++;}  			
 
  			
  			int m = (int) (i/10000);
  			int nztw = (int) (i%10000);	
  			int nztwm = 10*nztw + m;
  			if(i<nztwm && nztwm<= bb )
  			{ count++;}  			
 			
  			
  			
		  }
  		else if(i>=100000 && i<1000000)
		  {
  			int mnzt = (int) (i/10);
  			int w = (int) (i%10);	
  			int wmnzt = 100000*w + mnzt;
  			if(i<wmnzt && wmnzt<= bb )
  			{ count++;}  	
 
  			
  			int mnz = (int) (i/100);
  			int tw = (int) (i%100);	
  			int twmnz = 10000*tw + mnz;
  			if(i<twmnz && twmnz<= bb)
  			{ count++;}  			
  	  	
  			
  			
  			int mn = (int) (i/1000);
  			int ztw = (int) (i%1000);	
  			int ztwmn = 1000*ztw + mn;
  			if(i<ztwmn && ztwmn<= bb )
  			{ count++;}  			
  	
  			
  			int m = (int) (i/10000);
  			int nztw = (int) (i%10000);	
  			int nztwm = 100*nztw + m;
  			if(i<nztwm && nztwm<= bb &&(mn!=ztw))
  			{ count++;}  			
  		
  			
  			int ml = (int) (i/100000);
  			int nztwx = (int) (i%100000);	
  			int nztwxm = 10*nztwx + ml;
  			if(i<nztwxm && nztwxm<= bb &&(mn!=ztw) )
  			{ count++;}  			
  					
  			
  			
		  }
  		else if(i>=1000000 && i<10000000)
		  {
 			int mnzt = (int) (i/10);
  			int w = (int) (i%10);	
  			int wmnzt = 1000000*w + mnzt;
  			if(i<wmnzt && wmnzt<= bb )
  			{ count++;}  	
 
  			
  			int mnz = (int) (i/100);
  			int tw = (int) (i%100);	
  			int twmnz = 100000*tw + mnz;
  			if(i<twmnz && twmnz<= bb)
  			{ count++;}  			
	
  			
  			
  			int mn = (int) (i/1000);
  			int ztw = (int) (i%1000);	
  			int ztwmn = 10000*ztw + mn;
  			if(i<ztwmn && ztwmn<= bb )
  			{ count++;}  			

  			
  			int m = (int) (i/10000);
  			int nztw = (int) (i%10000);	
  			int nztwm = 1000*nztw + m;
  			if(i<nztwm && nztwm <= bb )
  			{ count++;}  			
  			
  			
  			int ml = (int) (i/100000);
  			int nztwx = (int) (i%100000);	
  			int nztwxm = 100*nztwx + ml;
  			if(i<nztwxm && nztwxm <= bb )
  			{ count++;}  			
  			
  			
  			
  			int a = (int) (i/1000000);
  			int bcdefg = (int) (i%1000000);	
  			int bcdefga = 10*bcdefg + a;
  			if(i<bcdefga && bcdefga<= bb  )
  			{ count++;}  			
  			
  			
		  }
  		else if(i>=10000000 && i<100000000)
		  {}
  		  else
  		  {}
  		  
  		  
  		  //////////////
  		  
  		  
  	    
  	  }

   
        return "Case #"+oo+": "+count;
     }
    
 
    
}

