import java.util.ArrayList;
import java.util.HashSet;


public class RecycledNumbers {
private static String inputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Input.txt";
private static String outputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Output.txt";
public static void main(String[] args) {
	
	InputReader ir = new InputReader(inputFile);
	OutputWriter ow = new OutputWriter(outputFile);
	ArrayList<String> lines = ir.loadLines();	
	for(int i=1;i<lines.size();i++){
		HashSet<String> hs = new HashSet<String>();
		String[] sNums = lines.get(i).split(" ",lines.get(i).length());
		Long[] minMaxArr = GCJUtils.getLongArray(sNums);
		for(long l=((minMaxArr[0]<12)?12:minMaxArr[0]);l<=minMaxArr[1];l++){
			String sCurrVal = Long.toString(l);
			for(int j=sCurrVal.length()-1;j>0;j--){
				String sTmp = sCurrVal.substring(j)+ sCurrVal.substring(0,j);
				Long sLong = Long.parseLong(sTmp);
				if(sLong>l && sLong<=minMaxArr[1]){					
					hs.add(sLong+"-"+l);
				}
			}
		}
		ow.writeCaseLine(hs.size()+"");
	}
	ow.flushAndClose();
}
}
