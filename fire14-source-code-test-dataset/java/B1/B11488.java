import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Main 
{

public static HashMap<Character,Character> mapp = new HashMap<Character,Character>();

public static void main(String[] args) throws Exception
{
PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
BufferedReader input = new BufferedReader(new FileReader("C-small-attempt0.in"));
int size=Integer.parseInt(input.readLine());
for(int i=0; i<size; i++)
{
Set<String> Sett = new HashSet<String>();
String tokens[] = input.readLine().split(" ");
int Llimit = Integer.parseInt(tokens[0]);
int Hlimit = Integer.parseInt(tokens[1]);
for(int j=Llimit; j<Hlimit; j++)
{
Integer num1 = j;
String str1 = num1.toString();
for(int x=0; x<str1.length(); x++)
{
String temp = (String)str1.subSequence(str1.length()-1-x, str1.length()) + (String)str1.subSequence(0, (str1.length()-1-x));

if(Integer.parseInt(temp)>j && Integer.parseInt(temp)<=Hlimit)
{
Sett.add(str1+temp);
}
}
}
writer.println("Case #"+(i+1)+": "+Sett.size());
}
writer.close();
input.close();
}

}