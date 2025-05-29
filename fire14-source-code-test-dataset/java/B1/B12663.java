import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Recycled{
public static void main(String[] args) throws java.io.IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(br.readLine());
for(int i=0;i<t;i++){
String[] input = br.readLine().split(" ");
int n = Integer.parseInt(input[0]);
int m = Integer.parseInt(input[1]);
int tm = m;
int tn = n;
int count = 0;
while(tm>n)
{
for(int j=n;j<tm;j++)
{
if(isRecycledPair(j,tm))
count++;
}
tm--;
}
System.out.println("Case #" + (i+1) + ": " + count);
}
}
private static boolean isRecycledPair(int n, int m){
String sn = Integer.toString(n);
String sm = Integer.toString(m);
int len = sn.length();
for(int i=0;i<len-1;i++)
{
sn = sn.charAt(len-1) + sn.substring(0,len-1);
if(sn.equals(sm))
return true;
}
return false;
}
}