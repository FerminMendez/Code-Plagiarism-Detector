import java.util.*;

public class CodeJam2 {

	
	public static void main(String[] args) 
	{
	Scanner input=new Scanner(System.in);
	int types=input.nextInt();
	for(int i=0;i<types;i++)
	{
	int count1=0,count2=0;
	int n=input.nextInt();
	int array2[]=new int[n];
	int surprise=input.nextInt();
	int p=input.nextInt();
	for(int j=0;j<n;j++)
	{
	array2[j]=input.nextInt();
	}		
	int array1[][]=new int[n][3];
	for(int j=0;j<n;j++)
	{
	array1[j][0]=array2[j]/3;
	int t=array2[j]-array1[j][0];
	int c1=t/2;
	int c2=t-c1;
	if(array2[j]!=0)
	{
	if(c1-c2==0)
	{
	if(p-c1==1)
	{
	if(count1<surprise)
	{
	count1++;
	count2++;
	array1[j][1]=c1--;
	array1[j][2]=c2++;
	}
	else
	{
	array1[j][1]=c1;
	array1[j][2]=c2;
	}
	}
	else if (p-c1==0)
	{
	array1[j][2]=c2;
	++count2;
	array1[j][1]=c1;
	}
	else if(p-c1>1)
	{
	array1[j][1]=c1;
	array1[j][2]=c2;
	}
	else if(p-c1<0)
	{
	array1[j][2]=c2;
	++count2;
	array1[j][1]=c1;
	}
	}
				
	else if((c2-c1)==1)
	{
	if(p<=c2)
	{
	array1[j][2]=c2;
	++count2;
	array1[j][1]=c1;
	}
	else 
	{
	array1[j][2]=c2;
	array1[j][1]=c1;
	}
	}
	}
	else{
	if(p==0)
	{
	++count2;
	}
	}
	}
	System.out.println("Case #"+(i+1)+": " +count2);
	}

	}

}
