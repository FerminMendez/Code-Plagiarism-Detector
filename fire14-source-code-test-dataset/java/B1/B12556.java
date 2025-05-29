import java.io.*;
public class Main {
	public static void main(String[] args) {
		try{
			FileReader in = new FileReader("input.txt");
			BufferedReader inFile = new BufferedReader(in);
			FileWriter outFile = new FileWriter("output.txt");
			int test = Integer.parseInt(inFile.readLine());
			for(int i=1;i<=test;i++){
				String line = inFile.readLine();
				String values[]=line.split(" ");
				int A = Integer.parseInt(values[0]);
				int B = Integer.parseInt(values[1]);
				int count = 0;
				for(int j=A;j<B;j++){
					for(int k=j+1;k<=B;k++){
						String temp = (new Integer(j)).toString();
						temp=(temp+temp);
						if(temp.contains((new Integer(k)).toString())) count++;
					}
				}
				outFile.write("Case #" + i + ": " + count + "\n");
			}
			inFile.close();
			outFile.close();
			
		}catch(Exception exp){
			exp.printStackTrace();
		}
	}
}
