import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;


public class RecyclingNumbers {
	private boolean[] m_numArray;
	private int[] chooseArray = {0, 0, 1, 3, 6, 10, 15, 21, 28};
	private int m_low;
	private int m_high;
	
	RecyclingNumbers(int low, int high){
		m_numArray = new boolean[high-low+1];
		Arrays.fill(m_numArray, false);
		m_low = low;
		m_high = high;
	}
	
	public int getPairsCount(){
		
		int m_pairsCount = 0;
		int tempCount = 0;
		
		for(int i=m_low; i<=m_high; i++){
			
			if(m_numArray[i-m_low] == true){
				continue;
			}
			
			String curNumS = String.valueOf(i);
			int intLength = curNumS.length();
			
			if(intLength == 1){
				continue;
			}
			
			for(int j=1; j<intLength; j++){
				String temp = curNumS.substring(intLength-1, intLength);
				String front = curNumS.substring(0, intLength-1);
				curNumS = temp + front; 
				
				int tempInt = Integer.parseInt(curNumS);
				
				if(tempInt>=m_low && tempInt <= m_high && tempInt != i && curNumS.length() == intLength && m_numArray[tempInt-m_low] == false){
					tempCount++;
					m_numArray[tempInt-m_low] = true;
				}
			}
			
			if(tempCount > 0){
				m_numArray[i-m_low] = true;
				m_pairsCount += chooseArray[tempCount+1];
			}
			
			tempCount = 0;
			
		}
		
		return m_pairsCount;
	}
	
	
	public static void main(String[] args) {
		
		try {
			// Code for accessing the file goes here
			FileReader dataFile = new FileReader("/Users/benedictliang/Documents/workspace/CodeJam2012/src/C-small-attempt0.in");
			BufferedReader bufferedDataFile = new BufferedReader(dataFile);
			String num = bufferedDataFile.readLine();
			int numOfLines = Integer.parseInt(num);
			
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/benedictliang/Documents/workspace/CodeJam2012/src/output.txt"));
			
			
			for(int i=1; i<=numOfLines; i++){
				String line = bufferedDataFile.readLine();
				String[] data = line.split(" ");
				int num1 = Integer.parseInt(data[0]);
				int num2 = Integer.parseInt(data[1]);
				
				RecyclingNumbers rn = new RecyclingNumbers(Math.min(num1, num2), Math.max(num1, num2));
				out.write("Case #" + i + ": " + rn.getPairsCount() + "\n");
			}
			
			dataFile.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
