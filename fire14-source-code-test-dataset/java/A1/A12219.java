import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Dancing_with_the_Googlers {
	public static void main(String[] args) throws IOException   
	  {  		 
		  FileInputStream fis;
		try {
			fis = new FileInputStream("B-small-attempt0.in");
			InputStreamReader ir = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(ir);
			String s;int i=0;
			br.readLine();
			while (br.ready()) {
				i++;
				s = br.readLine();
				System.out.print("Case #"+i+": ");
				tran(s);
				System.out.print("\r");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  //tran(a);
	  }   
	  static void tran(String a)
	  {
		  String num="";
		  int count=0;int N=0;int S=0;int P=0;
		  int[] score=new int[100];
		  for(int i=0;i<a.length();i++)
		  {
			  if(Character.isDigit(a.charAt(i))&&i!=a.length()-1)
			  {
				  num=num+a.charAt(i);
			  }
			  else if(count==0)
			  {
				  N=Integer.parseInt(num);
				  num="";
				  count++;
			  }
			  else if(count==1)
			  {
				  S=Integer.parseInt(num);
				  num="";
				  count++;
			  }
			  else if(count==2)
			  {
				  P=Integer.parseInt(num);
				  num="";
				  count++;
			  }
			  else if(i==(a.length()-1))
			  {
				  num=num+a.charAt(i);				  
				  score[count-3]=Integer.parseInt(num);
			  }
			  else
			  {
				  score[count-3]=Integer.parseInt(num);
				  num="";
				  count++;
			  }	
		  }
		  //System.out.print(N+" "+S+" "+P+" ");
		  //for(int i=0;i<N;i++){System.out.print(score[i]+" ");}
		  int ans1=0,ans2=0,fin=0;
		  for(int i=0;i<N;i++)
		  {
			  if(score[i]>=P*3-2&&score[i]>=P){ans1++;}
			  else if(score[i]>=P*3-4&&score[i]>=P){ans2++;}			  
		  }
		  if(ans2<=S){fin=ans2+ans1;}
		  else{fin=S+ans1;}
		  System.out.print(fin);
	  }

}
