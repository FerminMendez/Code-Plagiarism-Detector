public class Main {
	public static void main(String[] args) throws java.io.FileNotFoundException,java.io.IOException{
		java.io.BufferedReader bRead=new java.io.BufferedReader(new java.io.FileReader("F:\\B-small-attempt3.in"));
		java.io.BufferedWriter bWrite=new java.io.BufferedWriter(new java.io.FileWriter("F:\\B-small-attempt3.out"));
		StringBuffer output=new StringBuffer();
		int noCases=Integer.parseInt(bRead.readLine());
		for(int i=0;i<noCases;i++){
			String[] curLine=bRead.readLine().split(" ");
			int s=Integer.parseInt(curLine[1]),p=Integer.parseInt(curLine[2]),baseVal=3*p-2,maxGooglers=0;
			for(int j=3;j<curLine.length;j++){
				int cur=Integer.parseInt(curLine[j]);
				if(cur>=baseVal)maxGooglers++;
				else if((s>0)&&(cur>=p)&&(cur>=(3*p-4))){
					maxGooglers++;s--;					
				}
			}
			output.append("Case #"+(i+1)+": "+maxGooglers+"\n");
		}
		bWrite.write(output.toString());
		bWrite.close();bRead.close();
	}
}
