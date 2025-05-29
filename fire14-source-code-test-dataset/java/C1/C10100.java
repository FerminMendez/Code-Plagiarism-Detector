

//Author KNIGHT0X300 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

 


public class Main {
     public  class point {
            double x,y;
           int zz=1;//1 if not checked; 
        }
    
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
    
       int t=s.nextInt();
     int d1=0;
       for(int i=0;i<t;i++)
       { int posi=0,posj=0;
           
           int tot=0;
           int h=s.nextInt();
           int w=s.nextInt();
           int d=s.nextInt();
           char[][] A=new char[h][w];
          double dl,dr,dt,db;
          String S=s.nextLine();
           for(int j=0;j<h;j++)
           {
           S=s.nextLine();
           for(int k=0;k<w;k++)
           {  A[j][k]=S.charAt(k);
           if(A[j][k]=='X')
           {  posi=j;
               posj=k;}
           
           // System.out.print(" "+A[j][k]);
           
           }
              // System.out.println("");
           }
           dl= (posj-0.5);
           dr= (w-posj-1.5);
           dt= posi-0.5;
           db= h-posi-1.5;
      //    System.out.println("d1 "+dl+" dr "+dr+" dt "+dt+" db "+db);
 //       point[] p = new point[10000];
  int co=4;
  int[][] D=new int [101][101];
//        p[0].x=0;
//    p[0].y=0;
//     p[1].x=0;
//    p[1].y=2*dt;
//     p[2].x=0;
//    p[2].y=-2*db;
//     p[3].x=2*dr;
//    p[3].y=0;
//     p[4].x=-2*dl;
//    p[4].y=0;   
 int row=50,col;
  for(;;)   
  {
  row+=2*dr;//////////
  if(row>100)
      break;
 col=50;
  for(;;)   
  { 
  col+=2*dt;
  if(col>100)
      break;
  D[row][col]=1;
  col+=2*db;
  if(col>100)
      break;
  D[row][col]=1;
  }
  col=50;
  for(;;)   
  { 
  col-=2*db;
  if(col<0)
      break;
  D[row][col]=1;
  col-=2*dt;
  if(col<0)
      break;
  D[row][col]=1;
  }
  /////
  row+=2*dl;
   if(row>100)
      break;
    col=50;
  for(;;)   
  { 
  col+=2*dt;
  if(col>100)
      break;
  D[row][col]=1;
  col+=2*db;
  if(col>100)
      break;
  D[row][col]=1;
  }
  col=50;
  for(;;)   
  { 
  col-=2*db;
  if(col<0)
      break;
  D[row][col]=1;
  col-=2*dt;
  if(col<0)
      break;
  D[row][col]=1;
  }
  }///////////ppppppp
   row=50;
  for(;;)   
  {
  row-=2*dl;//////////
  if(row<0)
      break;
 col=50;
  for(;;)   
  { 
  col+=2*dt;
  if(col>100)
      break;
  D[row][col]=1;
  col+=2*db;
  if(col>100)
      break;
  D[row][col]=1;
  }
  col=50;
  for(;;)   
  { 
  col-=2*db;
  if(col<0)
      break;
  D[row][col]=1;
  col-=2*dt;
  if(col<0)
      break;
  D[row][col]=1;
  }
  /////
  row-=2*dr;
   if(row<0)
      break;
    col=50;
  for(;;)   
  { 
  col+=2*dt;
  if(col>100)
      break;
  D[row][col]=1;
  col+=2*db;
  if(col>100)
      break;
  D[row][col]=1;
  }
  col=50;
  for(;;)   
  { 
  col-=2*db;
  if(col<0)
      break;
  D[row][col]=1;
  col-=2*dt;
  if(col<0)
      break;
  D[row][col]=1;
  }
  }///lko
  TreeSet<Double> ts1 = new TreeSet<Double>();
 TreeSet<Double> ts2 =  new TreeSet<Double>();
//  ts1.add(100000D);ts2.add(100000D);
 for(int u=0;u<101;u++)
 { 
  //   System.out.print(" "+(u-51));
   //  System.out.println("");
     
 for(int y=0;y<51;y++)
 {  // System.out.print(D[u][y]);
     if(D[u][y]==1)
 {
 int xx=u-50,yy=y-50;
 double g=(double)yy/(double)xx;
 if(!ts1.contains(g)){
     double r=(xx*xx+yy*yy);
 if(r<=(float)d*d)
 {
 ts1.add(g);
 tot++;
 }} } 
 }///////////
   //  System.out.print("dsjk");
 for(int y=51;y<101;y++)
 { //  System.out.println("");
  //  System.out.print(D[u][y]);
     if(D[u][y]==1)
 {
 int xx=u-50,yy=y-50;
 double g=(double)yy/(double)xx;
 if(!ts2.contains(g)){
     double r=(xx*xx+yy*yy);
 if(r<=(float)d*d)
 {
 ts2.add(g);
 tot++;
 }} } 
 }
 }
   if(2*dt<=d) 
 tot++; 
   if(2*db<=d) 
 tot++; 
   if(2*dl<=d) 
 tot++; 
   if(2*dr<=d) 
 tot++; 
 //     System.out.println(ts1+" "+ts2);
// if(d>50)
//               System.out.println("fanfajnfiknasnajfjfnkjnfaijkfna ayyo");
//if(tot>d1){d1=tot;
//System.out.println(" maxmax  "+d1);

 System.out.println("Case #"+(i+1)+": "+(tot));
                      
          
       }
       

    }

    

      
    
}
