import java.util.ArrayList;


public class SpeakingInToungues {
private static String inputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Input.txt";
private static String outputFile = "C:\\PERSONAL-WORKSPACE\\GCJ-2012\\src\\input-output\\Output.txt";
public static void main(String[] args) {
	InputReader ir = new InputReader(inputFile);
	OutputWriter ow = new OutputWriter(outputFile);
	ArrayList<String> lines = ir.loadLines();
	//Given examples cover 25 chars and the one left out is q which is ideally mapped to the unused char z.
	String normalText = 	"aozq our language is impossible to understand there are twenty six factorial possibilities so it is okay if you want to just give up";
	String googlereseText = "yeqz ejp mysljylc kd kxveddknmc re jsicpdrysi rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd de kr kd eoya kw aej tysr re ujdr lkgc jv";
	StringBuffer sb = null;
	for(int i=1;i<lines.size();i++){
		sb = new StringBuffer();
		char[] charArray = lines.get(i).toCharArray();
		for(int j=0;j<charArray.length;j++){
			sb.append(normalText.charAt(googlereseText.indexOf(charArray[j])));
		}
		ow.writeCaseLine(sb.toString());
	}
	ow.flushAndClose();
}
}
