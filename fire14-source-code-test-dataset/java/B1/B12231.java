import java.io.*;

class Programa
{
	
public static long procesar(String linea)
{
	String vals[]=linea.split(" ");
	int digitos=vals[0].length();
	long a,b;
	a=Long.parseLong(vals[0]);
	b=Long.parseLong(vals[1]);
	long reciclados=0;
	
	int indi,ind = (int)(b-a+1);
	
	int parejas[][]=new int[ind][ind];
	long t=b-a+1;
	long cal;
	long v,resto,pot;
	String resu,resu2;
/*	for (long =0;l<t;l++) { 
		r[(int)l]=0;
		r[(int)l]=0;
	}*/
	for (long l=a;l<=b;l++)
        {
            ind=(int) (l-a);
   
               for (int k=1;k<digitos;k++)
               {		  
                  pot=(long) Math.pow(10,k);  		       
		  resto=l%pot;
		  v=l/pot;
		  resu=""+resto+v;     
		  cal=Long.parseLong(resu);      
   		  indi=(int) (l-a);
                  ind=(int) (cal-a);		       
	          if (cal>=a && cal<=b && cal!=l && parejas[indi][ind]==0  && parejas[ind][indi]==0 )
                  {
	   //         System.out.println(""+l+" "+cal);
		    parejas[indi][ind]=1;
              	    reciclados++;    		      
	         }
		  
            }	      
	}
	return reciclados;
}

	public static void main(String args[])
  {
  try{

  FileInputStream fstream = new FileInputStream(args[0]);
  
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  strLine = br.readLine();
  int casos=Integer.parseInt(strLine);
  int caso=1; 	  
  long respuesta=0;	
  while ((strLine = br.readLine()) != null)   {
              respuesta=procesar(strLine);
	      System.out.println("Case #"+caso+": "+respuesta);
              caso++;
	  }
  //Close the input stream
  in.close();
    }catch (IOException e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  }
}