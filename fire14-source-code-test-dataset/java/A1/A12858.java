import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Dancing {
	public static void main(String[] args) throws IOException {
BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
String x=reader.readLine();
String result="";
String input="";
long cases=Long.parseLong(x);
int size=0;
int sur=0;
int max=0;
int current=0;
int curmax=0;
int last=0;
int[]array1;
for(int j=0;j<cases;j++){
	input=reader.readLine();
String [] spl=input.split(" ");
 size=Integer.parseInt(spl[0]);
 sur=Integer.parseInt(spl[1]);
 max=Integer.parseInt(spl[2]);
 current=0;
 curmax=0;
 last=0;
int [] array=new int[spl.length-3];
for(int i=3;i<spl.length;i++){
	array[i-3]=Integer.parseInt(spl[i]);
}
Arrays.sort(array);
array1=new int[array.length];
for(int i=0;i<array.length;i++){
	array1[i]=array[array.length-i-1];
}
for(int i=0;i<array1.length;i++){
	current=array1[i];
	if(current/3<max){
	if(current%3==1){
		if((current/3+1)>=max){
			curmax++;
		}
	}else{
		if(current%3==2){
			if(last<sur&&!((current/3+1)>=max)){
				if((current/3+2)>=max){
					curmax++;
				}
				last++;
			}else{
				if((current/3+1)>=max){
					curmax++;
				}
			}
		}else{
			if(last<sur&&((current/3+1)>=max)&&(current/3-1)>=0){
				curmax++;
				last++;
			}
		}
	}
}else{
	curmax++;
}		
}
result+="Case #"+(j+1)+": "+curmax+"\n";
}
System.out.println(result);
	}
}