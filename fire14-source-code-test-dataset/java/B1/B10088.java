import java.io.*;
public class Recycle
{
int t=0,A=0,B=0;
String output="";
int count=1;
public void readFile(String fn)
{
String data="";
try{
File in=new File(fn);
BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(in)));
data=br.readLine();
t=Integer.parseInt(data);
while(count<=t)
{
data=br.readLine();
String s[]=data.split(" ");
A=Integer.parseInt(s[0]);
B=Integer.parseInt(s[1]);
computeRecycle();
count++;
}

br.close();
  }catch(Exception e){}
}

public static void main(String args[])
{
Recycle rc=new Recycle();
rc.readFile(args[0]);
rc.writeToFile();
}

public void computeRecycle()
{

int sum=0;
for(int i=A;i<=B;i++)
{
  String s=""+i;
  String t=s;
  int nm=0;
  int l=s.length();
  do
  {
  char c[]=t.toCharArray();
  char ch=c[0];
  for(int j=0;j<l-1;j++)
  {
   c[j]=c[j+1];   
  }
  c[l-1]=ch;

  t=new String(c);
  nm=Integer.parseInt(t);
   if(nm!=i && nm>=A && nm<=B)
   {
      sum++;
   }
  }while(nm!=i);
  
    
}

sum=sum/2;
output+="Case #"+count+": "+sum+"\n";

}


public void writeToFile(){
    try {
      File fout= new File("output.in");
      DataOutputStream dos = new DataOutputStream(new FileOutputStream(fout));
      dos.writeBytes(output);
      dos.close();
    } catch (Exception ex) {}

  }


}