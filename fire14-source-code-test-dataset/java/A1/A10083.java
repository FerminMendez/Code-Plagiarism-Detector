// no.of users
// no. of sets
// minimum best
// scores 

import java.io.*;
import java.util.Scanner;
public class Goggler
{
public static void main(String args[])
{
 try{
  FileWriter fstream = new FileWriter("outB.out");
FileInputStream fstream1=new FileInputStream("B-small-attempt0.in");
DataInputStream in=new DataInputStream(fstream1);
BufferedReader input=new BufferedReader(new InputStreamReader(in));
BufferedWriter out = new BufferedWriter(fstream);

String strLine;
strLine=input.readLine();
int T=Integer.parseInt(strLine);
int j=1;					
while(j<=T)
{
int N,S,P;
strLine=input.readLine();
String[] numbers=strLine.split(" ");
int nums[]=new int[numbers.length];
N=Integer.parseInt(numbers[0]);
S=Integer.parseInt(numbers[1]);
P=Integer.parseInt(numbers[2]);
int Score[]=new int[N];
int i=0;
for( i=0;i<N;i++){
				
Score[i]=Integer.parseInt(numbers[i+3]);
}

int Flag=0;

int avg;
int rem=0;
for(i=0;i<N;i++)
{
avg=Score[i]/3;
//System.out.print(avg);
rem=Score[i]%3;
//System.out.print(rem);
switch(rem)
{
case 0:
{
if(P<=avg)
Flag=Flag+1;
else if(P==avg+1&&S>0&&avg!=0)
{
S=S-1;
Flag=Flag+1;}
break;
}
case 1:
{
if(P<=avg+1)
Flag=Flag+1;
break;
}
case 2:
{
if(P<=avg+1)
Flag=Flag+1;
if(P==avg+2&&S>0)
{
S=S-1;
Flag=Flag+1;
}
break;
}

} //switch close
//System.out.println(Flag); 
}
//System.out.println(Flag);
out.write("Case #"+j+": "+Flag+"\r\n");
j=j+1;
}

out.close();
input.close();}catch (Exception e){//Catch exception if any
   System.err.println("Error: " + e.getMessage());
   }
}
}
