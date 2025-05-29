import java.util.Scanner;
import java.io.*;
class dance
{
  public static void main (String[] args) throws IOException
  { 
    File    inputData = new File("B-small-attempt0.in");
	File 	outputData= new File("Boutput.txt");
    Scanner scan = new Scanner( inputData );
	PrintStream print= new PrintStream(outputData);
    
	int t;
	int n,s,p,pi;
	t= scan.nextInt();
	for(int i=1;i<=t;i++)
	{
	n=scan.nextInt();	s=scan.nextInt();	p=scan.nextInt();
	int supTrip=0, notsupTrip=0;
	
	for(int j=0;j<n;j++)
	{
		pi=scan.nextInt();
		if(pi>(3*p-3))
		notsupTrip++;
		else if((pi>=(3*p-4))&&(pi<=(3*p-3))&&(pi>p))
		supTrip++;
	}
	
	if(s<=supTrip)
	notsupTrip=notsupTrip+s;
	else if(s>supTrip)
	notsupTrip= notsupTrip+supTrip;
	print.println("Case #"+i+": "+notsupTrip);
	}
  }
}