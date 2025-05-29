import java.util.ArrayList;
import java.util.HashSet;


public class DancingWithTheGooglers {
private static String inputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Input.txt";
private static String outputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Output.txt";
public static void main(String[] args) {
	InputReader ir = new InputReader(inputFile);
	OutputWriter ow = new OutputWriter(outputFile);
	ArrayList<String> lines = ir.loadLines();	
	for(int i=1;i<lines.size();i++){
		int count = 0;
		Long[] arrL = GCJUtils.getLongArray(lines.get(i).split(" ",lines.get(i).length()));		
		long nst = arrL[1];
		long score = arrL[2]; 
		ArrayList<Long[]> al = new ArrayList<Long[]>();
		for(int j=3;j<arrL.length;j++){		
			Long[] scoresArr = new Long[3];
			long remainder = arrL[j]%3;
			long tmp = arrL[j]/3;			
			scoresArr[0] = scoresArr[1] = scoresArr[2] = tmp;
			for(int k=0;k<remainder;k++){
				scoresArr[k]++;
			}
			if(scoresArr[0] >=score || scoresArr[1] >=score ||scoresArr[2] >=score){
				count++;
			}else if(remainder!=1 ){
				al.add(scoresArr);
			}
		}
		for(int p=0;p<al.size();p++){
			Long[] arrLL = al.get(p);
			if(nst==0)break;
			if(arrLL[0]!=0 && arrLL[0]==(score-1)){
				count++;nst--;
			}
		}
		ow.writeCaseLine(count+"");
	}
	ow.flushAndClose();
}
}
