import java.io.*;
public class RecycledNo
{
public static void main (String arg[]) throws Exception
{
BufferedReader ob=new BufferedReader (new FileReader("C-small-attempt2.in"));

PrintWriter pw=new PrintWriter ("output.txt");

String temp="";
temp=ob.readLine();
int t=Integer.parseInt(temp);
int a=0,b=0;

for(int l=1;l<=t;l++)
{
 temp=ob.readLine();
 String str="";

 for(int i=0;i<temp.length();i++)
 {
  char ch=temp.charAt(i);
  if(ch==' ')
  {
  a=Integer.parseInt(str);
  str="";
  continue;
  }
  str=str+ch;
 } 
 b=Integer.parseInt(str); 
 int count=0;
 str="";
 for(int k=a;k<=b;k++) 
 {
  str=""+k;
  String s[]=new String[str.length()];
  for(int i=0;i<str.length();i++)
  {
  char ch=str.charAt(i);
  s[i]=""+ch;
  }
  for(int i=1;i<str.length();i++)
  {
  temp=s[0];
  for(int j=0;j<str.length()-1;j++)
  {
  s[j]=s[j+1];
  }
  s[str.length()-1]=temp;
  String R="";
  for(int j=0;j<str.length();j++)
  {
  R=R+s[j];
  }
  int tmp=Integer.parseInt(R);
  if(tmp<=b && tmp>k)
  count++;
  }
 }
 temp="Case #"+l+": "+count;
 pw.println(temp);
}
pw.close();
}
}
