import java.io.*;
import java.util.*;

public class Pairing{

	public static void main(String args[]){
		try
		{
  			FileInputStream fstream = new FileInputStream("textfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			FileWriter ffstream = new FileWriter("./output.txt");
		  	BufferedWriter out = new BufferedWriter(ffstream);
			String strLine,result;
			int i=0;
			strLine = br.readLine();
			i=Integer.parseInt(strLine);
			String startS, endS;
			int j=1;
			int val=0;
			int start=0,end=0,tt=0;
			int count=0;
			PairList lista;
			Pair res;
			while (j<=i)   {
				lista = new PairList();
				count=0;
				strLine = br.readLine();
				StringTokenizer token = new StringTokenizer(strLine);
				startS = token.nextToken();

	
				start=Integer.parseInt(startS);
				endS = token.nextToken();
			
	
				end=Integer.parseInt(endS);

				char[] startA = startS.toCharArray();
				char[] endA = endS.toCharArray();
				char[] temp = new char[endA.length];
				char[] newn = new char[endA.length];
				int curr=start;
				boolean adding=false;
				if(startA.length==endA.length && startA.length>1){
					int stop=start+(end-start)/2+1;
					while(curr<=end){
						curr++;

						temp = Integer.toString(curr).toCharArray();
						int k=temp.length-1;
						while(k>0){

							if(temp[k]<=endA[0] && temp[k]>=startA[0]){
								int l = k;
								int m=0;
								while(l<=temp.length-1){
									newn[m]=temp[l];
									l++;
									m++;

								}
								l = 0;
								while (m<temp.length){
									newn[m]=temp[l];
									l++;
									m++;
								}		
								result = new String(newn);
								res = new Pair();
								tt = Integer.parseInt(result);

								if(tt<curr && curr<=end && tt>=start){
									res.first=tt;
									res.second=curr;
									adding = true;
								}
								else if(tt>curr && tt<=end && curr>=start){ 
									res.first=curr;
									res.second=tt;
									adding=true;
								}
								else adding=false;
								
								
								if(adding==true ){
									int place = lista.Find(res,end);
									if(place<end){
										count++;
										lista.addP(place,res);
									}
								}
							}
							k--;
						}
					}
					
					
				}

				out.write("Case #"+Integer.toString(j)+": "+Integer.toString(count)+"\n");
				j++;
			}
			
			in.close();
			out.close();
		}
		catch (Exception e){//Catch exception if any
			e.printStackTrace();
		}
	}

}

