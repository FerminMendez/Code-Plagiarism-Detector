import java.io.*;
class Main
{
public static int dance(int ll,int spp,int maxx,int g[])
{

int c=0;
int l=ll;
long result[][]=new long[l][4];
int max=maxx;
//int g[]={15,13,11};
int s=0;
int i=0;
int sum=0;
int flag=0;
int t=2;
int presp=spp;
int special=0;
int sp=0;
int sol=0;int maxsol=0;int row=0;
int sum2=0;
boolean yes=true;
for(int loop=0;loop<l;loop++)
{
i=0;
while(i<=10 && flag==0)
{
for(int j=i;j<=i+t && flag==0;j++)
{
for(int k=i;k<=i+t && flag==0;k++)
{
sum=i+j+k;
if(sum==g[loop])
{
sum2=sum;
sol++;
if(j==i+2 || k==i+2)
{
sp++;
special++;
}
//System.out.println(sum+"  ... "+g[loop]);
if(i>=max || j>=max ||k>=max)
{
maxsol++;
//System.out.println(i+ "  "+j+"  "+k);
c++;
flag=0;
}
}

}
}
i++;


/*if(special==presp)
{
t=1;
special=0;
}*/
}
result[row][0]=sum2;
result[row][1]=sol;
result[row][3]=sp;
result[row][2]=maxsol;
row++;
flag=0;
sol=0;
maxsol=0;
sp=0;
}
//System.out.println("ans :"+c);
//System.out.println("special :"+special);
int ans=0;
sort(result,l);
for(int rr=0;rr<l;rr++)
{
if(result[rr][2]>0)
{
presp=rr+presp;
break;
}
}
//System.out.println("presp ="+presp);
for(int rr=0;rr<l;rr++)
{

if(result[rr][2]>0 )
{
if(rr>(presp-1))
{
if(result[rr][3]>=result[rr][2])
{
yes=false;
}
}

if(yes)
ans++;

yes=true;
}
/*
for(int cc=0;cc<4;cc++)
{
//System.out.print(result[rr][cc]+" |  ");
}
System.out.println();*/
}
//System.out.println("ans right:"+ans);
return ans;

}
public static void sort(long a[][],int l)
{
long cell1=0,cell2=0,cell3=0,cell4=0;
for(int i=0;i<l;i++)
{
for(int j=i+1;j<l;j++)
{
if(a[i][2]>a[j][2])
{
cell1=a[i][0];
cell2=a[i][1];
cell3=a[i][2];
cell4=a[i][3];

a[i][0]=a[j][0];
a[i][1]=a[j][1];
a[i][2]=a[j][2];
a[i][3]=a[j][3];

a[j][0]=cell1;
a[j][1]=cell2;
a[j][2]=cell3;
a[j][3]=cell4;

}

}
}
}
public static void main(String ar[]) throws IOException
{
FileReader in=new FileReader("hello.txt");
FileWriter ot=new FileWriter("check.txt",true);

BufferedReader ds=new BufferedReader(in);
BufferedWriter out=new BufferedWriter(ot);

//System.out.println("check332wefsd");
int loop=Integer.parseInt(ds.readLine());
String i[]=new String[loop];
int ll,maxx,sp;
int rs[];
int ans;
for(int ii=1;ii<=loop;ii++)
{
i=ds.readLine().split(" ");
ll=Integer.parseInt(i[0]);
sp=Integer.parseInt(i[1]);
maxx=Integer.parseInt(i[2]);
rs=new int[ll];
for(int j=3;j<ll+3;j++)
{
rs[j-3]=Integer.parseInt(i[j]);
}
ans=dance(ll,sp,maxx,rs);
out.write("Case #"+String.valueOf(ii)+": "+String.valueOf(ans));
out.newLine();

}
in.close();
out.close();

}
}