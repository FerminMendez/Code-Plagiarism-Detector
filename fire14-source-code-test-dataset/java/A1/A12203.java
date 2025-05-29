import java.io.*;

class Programa
{
static boolean alcanza2(int a,int b)
{
  int j1=0,j2=0,j3=0;
  for (int i=0;i<=30;i++)
  {
     if (i+(i+2)+(i+2)==a)
     {
        j1=i;
	j2=i+2;
	j3=i+2;
     }	     
     if (i+i+(i+2)==a)
     {
        j1=i;
	j2=i+2;
        j3=i;	     
     }	     
     if (i+(i+1)+(i+2)==a)
     {
        j1=i;
	j2=i+2;
        j3=i+1;	     
     }	     
  // System.out.println(" "+a+" -> "+j1+" "+j2+" "+j3);
  }	  
  	
 if (j2>=b) 
	 return true;
 else
	return false;
	
}
	static boolean alcanza(int a,int b)
{
  int j1=0,j2=0,j3=0;
  for (int i=0;i<=30;i++)
  {
     if (i+(i+1)+(i+1)==a)
     {
        j1=i;
	     j2=i+1;
	     j3=i+1;
     }	     
     if (i+i+i==a)
     {
         j1=i;
	j2=i;
	     j3=i;
     }	     
     if (i+i+(i+1)==a)
     {
        j1=i;
	j2=i+1;
        j3=i;	     
     }	     
  }	  
   //System.out.println(" "+a+" -> "+j1+" "+j2+" "+j3);
 	
 if (j2>=b) 
	 return true;
 else
	return false;
	
}
public static int procesar(String linea)
{
	String vals[]=linea.split(" ");
	int n,s,p;
	int usados=0;
	int puntajes[];
	n=Integer.parseInt(vals[0]);
	s=Integer.parseInt(vals[1]);
	p=Integer.parseInt(vals[2]);
	puntajes=new int[n];
	for (int i=0;i<n;i++)
	  puntajes[i]=Integer.parseInt(vals[3+i]);
	
	int resultado=0;
	for (int i=0;i<n;i++)
	{
	  if (alcanza(puntajes[i],p))
		   resultado++;
	   else
	   {
	          if (alcanza2(puntajes[i],p) && usados<s)
		  {
		      usados++;
		      resultado++;
			  }
		  
		   }
	}		
	return resultado;
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
  int respuesta;
	  
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