public class Main {
	public static void main(String[] args) throws java.io.FileNotFoundException,java.io.IOException{
		java.io.BufferedReader bRead=new java.io.BufferedReader(new java.io.FileReader("F:\\C-small-attempt0.in"));
		java.io.BufferedWriter bWrite=new java.io.BufferedWriter(new java.io.FileWriter("F:\\C-small-attempt0.out"));
		java.util.HashMap<Integer,Integer> mVals=new java.util.HashMap<Integer,Integer>();
		StringBuffer output=new StringBuffer();		
		int noCases=Integer.parseInt(bRead.readLine());
		for(int i=0;i<noCases;i++){	
			String[] curLine=bRead.readLine().split(" ");
			int A=Integer.parseInt(curLine[0]),B=Integer.parseInt(curLine[1]),dig=curLine[0].length(),n=A,noPairs=0;
			while(n<B){
				int m;mVals.clear();
				for(int j=1;j<dig;j++){
					m=((n%(int)Math.pow(10,dig-j))*(int)Math.pow(10,j))+n/((int)Math.pow(10,dig-j));
					if(m>n&&m<=B&&!mVals.containsKey(m)){noPairs++;mVals.put(m,0);}
				}
				n++;
			}
			output.append("Case #"+(i+1)+": "+noPairs+"\n");
		}
		bWrite.write(output.toString());
		bWrite.close();bRead.close();
	}
}
