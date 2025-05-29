import java.util.Scanner;
import java.io.*;
import java.lang.*;
class recycle
{ 
static int attempts;

public static void main(String args[]) throws IOException
{ int a[]=new int[50],b[]=new int[50],x;
recycle obj=new recycle();
int i,m,n,result[]=new int[50];
Scanner cin=new Scanner(System.in);
int k=cin.nextInt();
for(i=0;i<k;i++)
{ a[i]=cin.nextInt();
b[i]=cin.nextInt();
}
for(i=0;i<k;i++)
{ m=a[i]; result[i]=0;
for(;m<b[i];m++)
{for(n=m+1;n<=b[i];n++)
{
attempts=0;
x=obj.check(m,n);
if(x==1) result[i]++;
}
}}
i=0;
while(i<k) System.out.println("Case #"+(i+1)+": "+result[i++]);
}
public int check(int var1,int var2)
{recycle obj1=new recycle();
String aString = Integer.toString(var1);
String bString = Integer.toString(var2);
int l1=aString.length();
int l2=bString.length();
if(l1==1 && l2==1) return 0;
if(l1==2 && l2==2) return obj1.two(aString,bString);
if(l1==3 && l2==3) return obj1.three(aString,bString);
if(l1==4 && l2==4) return obj1.four(aString,bString);
return 0;
}

public int two(String temp1,String temp2)
{ String temp3 = new StringBuffer(temp2).reverse().toString();
if(temp1.equals(temp3)) return 1;
else return 0;
}

public int three(String temp1,String temp2)
{ attempts++;
if(attempts>3) return 0;
if(temp1.equals(temp2)) return 1;
else { char [] bArray=temp2.toCharArray();
		int l=2,temp;
		  temp=bArray[l];
					while(l>0) {bArray[l]=bArray[l-1];l--;}
		  bArray[0]=(char )temp;
		  String str = new String(bArray);
		  return three(temp1,str);
		 }
}

public int four(String temp1, String temp2)
{ attempts++;
if(attempts>4) return 0;
if(temp1.equals(temp2)) return 1;
else { char [] bArray=temp2.toCharArray();
		int l=3,temp;
		  temp=bArray[l];
					while(l>0) {bArray[l]=bArray[l-1];l--;}
		  bArray[0]=(char)temp;
		  String str = new String(bArray);
		  return four(temp1,str);
		 }
}
	}