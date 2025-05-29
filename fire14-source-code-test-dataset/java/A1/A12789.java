import java.io.*;
import java.util.*;
public class tr
{
 public static void main(String args[])throws FileNotFoundException,IOException
  {
      RandomAccessFile in=new RandomAccessFile("B-small-attempt3.in","r");
      FileOutputStream out= new  FileOutputStream("out.txt");
     int o=Integer.parseInt(in.readLine());
     int j=0;     
      int res[]=new int[o];
      String str[]=new String[o+1];
     while((str[j]=in.readLine())!=null)
     {
      String []cas=str[j].split(" ");
       int no=Integer.parseInt(cas[0]);
       int sur=Integer.parseInt(cas[1]);
       int min=Integer.parseInt(cas[2]);
       int da[]=new int[no];
	   int mark[]=new int[no];
       int [][]trip=new int[no][3];
       int cursur=0;
       String map;
       String []mchar=new String[3];
       for(int i=0;i<no;i++) { da[i]=Integer.parseInt(cas[3+i]);}
       da=setnos(da,no);
       for(int i=0;i<no;i++)
       {
	    mark[i]=0;
           if(da[i]==1||da[i]==29||da[i]==30||da[i]==0||cursur==sur||check(da[i],min)==false)
               {			   
                
                				
                map=normalsplit(da[i]); 
                 mchar=map.split(" ");
                 trip[i][0]=Integer.parseInt(mchar[0]);
                 trip[i][1]=Integer.parseInt(mchar[1]);
                 trip[i][2]=Integer.parseInt(mchar[2]);
			     System.out.println(trip[i][0]+" "+trip[i][1]+" "+trip[i][2]);
				 
               }
            else        
           {
		     mark[i]=1;
              map=sursplit(da[i]); 
                 mchar=map.split(" ");
                 trip[i][0]=Integer.parseInt(mchar[0]);
                 trip[i][1]=Integer.parseInt(mchar[1]);
                 trip[i][2]=Integer.parseInt(mchar[2]);
				  cursur++;
				  System.out.println(trip[i][0]+" "+trip[i][1]+" "+trip[i][2]);
				  
           }
            
         }
		 for(int i=0;i<no;i++)
        {
		   if((mark[i]==0)&&(da[i]!=1||da[i]!=29||da[i]!=30))
		    cursur++;
		}
        for(int i=0;i<no;i++)
        {
               for(int k=0;k<3;k++)
                { 
                      if(trip[i][k]>=min)
                      { 
                            res[j]++;
                            break;
                      }
                 }
         }
        if(cursur<sur)res[j]=0;
      j++;
     }
   for(int i=0;i<o;i++)
    {
     out.write(("Case #"+(i+1)+": "+res[i]+"\n").getBytes());
    }  
    
   }
  static int []setnos(int []da,int no)
  {
       int temp;
     for(int i=0;i<no;i++)
       { 
           for(int j=i+1;j<no;j++)
           { 
             if(da[i]>da[j])
               { 
                  temp=da[i];
                  da[i]=da[j];
                  da[j]=temp;
                }
           }
       }
     return da;       
  }
 
  static boolean check(int d,int min)
  {
   String map;
       String []mchar=new String[3];
   map=sursplit(d); 
                 mchar=map.split(" ");
                 int a=Integer.parseInt(mchar[0]);
                 int b=Integer.parseInt(mchar[1]);
                 int c=Integer.parseInt(mchar[2]);  
				 if(a>=min||b>=min||c>=min)return true;
				 return false;
  }
 
  static String normalsplit(int da)
  {
     switch(da)
        {
		    case 0:return 0+" "+0+" "+0;
            case 1:return 1+" "+0+" "+0;
            case 2:return 1+" "+1+" "+0;
            case 3:return 1+" "+1+" "+1;
            case 4:return 2+" "+1+" "+1;
            case 5:return 2+" "+2+" "+1;
            case 6:return 2+" "+2+" "+2;
            case 7:return 2+" "+2+" "+3;
            case 8:return 2+" "+3+" "+3;
            case 9:return 3+" "+3+" "+3;
            case 10:return 3+" "+3+" "+4;
            case 11:return 3+" "+4+" "+4;
            case 12:return 4+" "+4+" "+4;
            case 13:return 4+" "+4+" "+5;
            case 14:return 4+" "+5+" "+5;
            case 15:return 5+" "+5+" "+5;
            case 16:return 5+" "+5+" "+6;
            case 17:return 5+" "+6+" "+6;
            case 18:return 6+" "+6+" "+6;
            case 19:return 6+" "+6+" "+7;
            case 20:return 6+" "+7+" "+7;
            case 21:return 7+" "+7+" "+7;
            case 22:return 7+" "+7+" "+8;
            case 23:return 7+" "+8+" "+8;
            case 24:return 8+" "+8+" "+8;
            case 25:return 8+" "+8+" "+9;
            case 26:return 8+" "+9+" "+9;
            case 27:return 9+" "+9+" "+9;
            case 28:return 9+" "+9+" "+10;
            case 29:return 9+" "+10+" "+10;
            case 30:return 10+" "+10+" "+10;
         }  
      return "";   
   }

  static String sursplit(int da)
  {
     switch(da)
        {
            case 2:return 2+" "+0+" "+0;
            case 3:return 2+" "+1+" "+0;
            case 4:return 2+" "+2+" "+0;
            case 5:return 2+" "+2+" "+1;
            case 6:return 1+" "+2+" "+3;
            case 7:return 1+" "+3+" "+3;
            case 8:return 2+" "+2+" "+4;
            case 9:return 3+" "+2+" "+4;
            case 10:return 2+" "+4+" "+4;
            case 11:return 3+" "+3+" "+5;
            case 12:return 4+" "+3+" "+5;
            case 13:return 3+" "+5+" "+5;
            case 14:return 4+" "+4+" "+6;
            case 15:return 5+" "+4+" "+6;
            case 16:return 4+" "+6+" "+6;
            case 17:return 5+" "+5+" "+7;
            case 18:return 6+" "+5+" "+7;
            case 19:return 5+" "+7+" "+7;
            case 20:return 6+" "+6+" "+8;
            case 21:return 7+" "+6+" "+8;
            case 22:return 6+" "+8+" "+8;
            case 23:return 7+" "+7+" "+9;
            case 24:return 8+" "+7+" "+9;
            case 25:return 7+" "+9+" "+9;
            case 26:return 8+" "+8+" "+10;
            case 27:return 9+" "+8+" "+10;
            case 28:return 8+" "+10+" "+10;
         }  
      return "";   
   }
}