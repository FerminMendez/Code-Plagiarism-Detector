import java.io.*;
import java.util.*;
public class rfin {
public static void main(String args[]){
	try{
		FileInputStream fstream = new FileInputStream("C-small-attempt2.in");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  FileWriter fstreamo = new FileWriter("out.txt");
		  BufferedWriter out = new BufferedWriter(fstreamo);
		  
		  
		//  System.out.println(g);
		 int t=Integer.parseInt(br.readLine());
		//  System.out.println(t);
		  int u,v,d,dr,rs,p,qs,q,qd,a,b,c,i,j,k,r,n,count;
		  String str;
		  for(i=0;i<t;i++){
			  count=0;
			  d=0;
			  str = br.readLine();
			  System.out.println(str);
			  StringTokenizer st=new StringTokenizer(str);
			  a=Integer.parseInt(st.nextToken());
			  //System.out.println(a);
		   	  b=Integer.parseInt(st.nextToken());
		   	//System.out.println(b);
		   	  n=b-a+1;
		   	  //System.out.println(n);
		   	  c=a;
		   	int[][] m = new int[1001][1001];
		   	for(u=0;u<1001;u++){
		   		for(v=0;v<1001;v++){
		   			if(u==v)m[u][v]=1;
		   			else m[u][v]=0;
		   		}
		   	}
		   	  while(c>0){
		   		  c=c/10;
		   		  d++;
		   	  }
		   	System.out.println(d);
		   	  for(j=a;j<=b;j++){
				   	//System.out.println(j);
		   		  
		   		  for(k=1;k<=d-1;k++){
		   		    	qd=0;dr=0;
		   			  p=(int)Math.pow(10,k);
		  		   //	System.out.println(p);	  
		   		    	q=j/p;
		   			   	//System.out.println(q);
		   		    	qs=q;
		   		    	while(qs>0){
		   		    		qs=qs/10;
		   		    		qd++;
		   		    	}
		   		    	r=q+(j%p)*((int)Math.pow(10,qd));
		   			 
		   			  
		   			   	System.out.println(j);		   	System.out.println(r);
		   			  System.out.println(m[j][r]);		   	System.out.println(m[r][j]);
		   			  rs=r;
		   			  while(rs>0){dr++;
		   			  rs=rs/10;}
		   			System.out.println(dr);
		  		   	System.out.println("++++++++++");
		   		if(m[j][r]!=1&&m[r][j]!=1&&dr==d&&r<=b&&j<r)
		   			  {count++;
		   			System.out.println(count);
		   			  System.out.println("=========");
		   			  m[j][r]=1;
		   			  m[r][j]=1;}
		   		  }
		   	  }
		  System.out.println(count);
		  out.write("Case #"+(i+1)+": "+count);
		  out.newLine();
		  }
		
	out.close();
	in.close();
	//out1.close();
	}
	
	catch(Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
	  }
	
	
}
}
