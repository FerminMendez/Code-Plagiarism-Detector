import java.io.*;

public class Recycled{
public static void main(String args[])
{
try{
File myFile = new File("C-small-attempt0.in");
FileReader fileReader = new FileReader(myFile);

BufferedReader reader = new BufferedReader(fileReader);
FileWriter fileWriter = new FileWriter("C-small-attempt0.out");
BufferedWriter writer = new BufferedWriter(fileWriter);
String line = null;
line = reader.readLine();
int numLines = Integer.parseInt(line);
//writer.write("hello");
for(int i=0;i<numLines;i++)
{
int recyclecount = 0;
line = reader.readLine();
String AB[] = line.split(" ");

int a = Integer.parseInt(AB[0]);
int b = Integer.parseInt(AB[1]);
int length = AB[0].length();

//the initial value of n

for(int n=a;n<b;n++)
{
System.out.println("N: " + n);
//writer.write("N " + n+"\r\n");
//recycle the value by taking the last digit forward and check with the range,and then the last two digits,etc
for(int j=1;j<length;j++){
if(length!=1){
int tail = n%(int)Math.pow(10,j);
int head = n/(int)Math.pow(10,j);
//concatenate the head and tail and form a new number
int newNumber = Integer.parseInt(tail +""+head);

if((newNumber+"").length() == length){
System.out.println(newNumber);
//writer.write("new " + newNumber+"\r\n");
//compare with the range n<m<=B

if(newNumber<=b && newNumber>n)
{
recyclecount++;
System.out.println("RC " + recyclecount);
//writer.write("RC " + recyclecount+"\r\n");

}

}
}
}
}
String out = "Case #" + (i+1) +": "+recyclecount+"\r\n";
writer.write(out);
System.out.println(out);


}
reader.close();
writer.close();

}catch(Exception ex){
ex.printStackTrace();
}
}
}