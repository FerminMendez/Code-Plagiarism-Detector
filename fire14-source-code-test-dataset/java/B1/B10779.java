import java.util.Scanner;


public class Main {

	
	public static void main(String[] args) {
		int a,b,t;
		
		  Scanner odczyt = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
		  boolean []tab=new boolean [2000000];
		  t = odczyt.nextInt();
		  for (int i=1; i<=t;i++)
		  {
			  a=odczyt.nextInt();
			  b=odczyt.nextInt();
			  String liczba;
			  String zmiana;
			  int nowa;
			  int ile=0;
			  int poprzedni=-1;
			  for (int j=a;j<=b;j++)
			  {
				  tab[j]=true;  
				  
			  }
			  for (int j=a; j<=b;j++)
			  {
				  
					  liczba=Integer.toString(j);
					  for (int k=1;k<liczba.length();k++)					  
					  {
						  zmiana=liczba.substring(k)+liczba.substring(0, k);
						//System.out.print(Integer.parseInt("012")+'\n');
						  nowa=Integer.parseInt(zmiana);
						 
						  if ( nowa>j && nowa>=a && nowa <=b && tab[nowa] && nowa!=poprzedni)
						  {
							  ile++;
							  tab[j]=false;
							 poprzedni=nowa;
							  //System.out.print(j+" "+nowa+"\n");
						  }
						  
						  
					 
					  
					  
					  
					  
					  
				  }				  
			  }
			  
			  
			  
			  
			  System.out.print("Case #"+i+": "+ile+'\n');
			  
		  }

		  
		
	}

}
