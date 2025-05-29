import java.io.*;
class RNumber
{
 public static void main(String args[])throws Exception
 { 
    String[] output;
    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	FileOutputStream fo=new FileOutputStream("probB.out");
	int T=Integer.parseInt(in.readLine());
	output=new String[T];
	int[][] inp=new int[T][];
	String temp="";
	for(int i=0;i<T;i++){
	temp=in.readLine();
	inp[i]=new int[]{Integer.parseInt(temp.split(" ")[0]),Integer.parseInt(temp.split(" ")[1])};
	}
	
	for(int i=0;i<T;i++){
	
	 int n=inp[i][0],m=inp[i][1],inc=0;
	 for(int nn=n;nn<=m;nn++){
		for(int mm=n;mm<=m;mm++){
		if(!(mm==nn)){
		 String nS=Integer.toString(nn);
		 String mS=Integer.toString(mm);
		 if(nS.length()==mS.length()){
		  int len=nS.length();
		  for(int ee=0;ee<len;ee++){
		   if(nS.equals(mS)){
		    inc++;
			break;
		   }else{
		    char exp=nS.charAt(0);
			String sa="";
			for(int yy=1;yy<len;yy++){
			sa+=nS.charAt(yy);
			}
			sa+=exp;
			nS=sa;
		   }
		   
		  }
		 }
		}
		}
	  }
	  output[i]="Case #"+(i+1)+": "+(inc/2);
	}
	
	   for(int d=0;d<output.length;d++){
    System.out.println(output[d]);
	if(d==output.length-1){
    fo.write((output[d]).getBytes());}
	else
	fo.write((output[d]+'\n').getBytes());
   }
 }
}