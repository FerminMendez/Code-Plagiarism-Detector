import java.io.*;
import java.util.*;


public class PairList{

	public ArrayList<Pair> pairs;

	public PairList(){
		pairs= new ArrayList();
	}
	
	public void addP(int i, Pair pair){
		pairs.add(i,pair);
	}
	
	public int Find (Pair pair,int big){
		int ena=pair.first;
		int dyo=pair.second;
		int length=pairs.size();
		Pair temp;
		int ret=0;
		int k=0;
		if(length==0){
			ret=0;
		}
		else{
			for(k =0; k<length; k++){
				temp=pairs.get(k);
				if (temp.first==pair.first){
					if(temp.second==pair.second)
					ret=big+2;
				}
				else if(temp.first>pair.first){
					ret=k;			
				}
			}
			if(k==length-1)
				ret=k+1;
		}
		return(ret);
	}
}
