import java.io.*;

public class google3
{

void main()throws IOException
{

 try{
  // Open the file that is the first 
  // command line parameter
  FileInputStream fstream = new FileInputStream("C-small-attempt1.in.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  strLine=br.readLine();
  int a=Integer.parseInt(strLine);//Read File Line By Line
 String b[]=new String[a];
 int i=0;
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
  b[i]=strLine;i++;
  }
  in.close();
  FileOutputStream out = new FileOutputStream(new File("output.txt"));
 
 int g=0;for(int l=0;l<a;l++)
{g=l+1;byte[] s = ("Case #"+g+": "+check(b[l])+"\n").getBytes();
out.write(s);
}
  
  
}
catch(Exception e){}
}
int check(String a){

String[] parts = a.split(" ");
int[] numbers = new int[parts.length];
int count=0;
for(int i = 0; i < parts.length; i++)
   { numbers[i] = Integer.parseInt(parts[i].trim());
    }
    
    for(int i=numbers[0];i<=numbers[1];i++)
    {for(int j=i+1;j<=numbers[1];j++)
    {
       count+=ret(i,j);
    }
    
    }
    return count;
}

int ret(int a,int b)
{
String c=Integer.toString(a);

String d=Integer.toString(b);

for(int i=0;i<c.length();i++)
{
if((c.substring(i,c.length())+c.substring(0,i)).equals(d))
{return 1;}

}
return 0;
}
}



