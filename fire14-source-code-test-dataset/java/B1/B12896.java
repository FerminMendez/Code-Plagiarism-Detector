import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;



public class Recycled_Numbers {
	public static void main(String[] args) throws IOException {
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
String x=reader.readLine();
long cases=Long.parseLong(x);
Hashtable <Long,Long>hash=new Hashtable<Long, Long>();
String input="";
long a=0;
String result="";
long b=0;
long i=a;
String temp="";
String ctemp="";
long counter=0;
String []array;
for(int j=0;j<cases;j++){
	input=reader.readLine();
	array=input.split(" ");
	a=Long.parseLong(array[0]);
	b=Long.parseLong(array[1]);
	i=a;
	 temp="";
	ctemp="";
	counter=0;
while(i<=b){
temp=i+"";
hash.clear();
for(int k=1;k<temp.length();k++){
ctemp=temp.substring(k,temp.length())+temp.substring(0,k);	
if((i<Long.parseLong(ctemp))&&(Long.parseLong(ctemp)<=b)){
	if(hash.get(Long.parseLong(ctemp))==null){
	hash.put(Long.parseLong(ctemp), Long.parseLong(ctemp));
	counter++;
	}
}
}
i++;
}
result+="Case #"+(j+1)+": "+counter+"\n";
}
System.out.println(result);
}
}