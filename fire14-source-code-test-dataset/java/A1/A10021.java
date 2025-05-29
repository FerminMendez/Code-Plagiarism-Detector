import java.util.ArrayList;


public class GCJUtils {
public static Long[] getLongArray(ArrayList<String> lines){
	Long[] arrL = new Long[lines.size()];
	for(int i=0;i<lines.size();i++){
		arrL[i] = Long.parseLong(lines.get(i));
	}
	return arrL;
}
public static Long[] getLongArray(String[] lines){
	Long[] arrL = new Long[lines.length];
	for(int i=0;i<lines.length;i++){
		arrL[i] = Long.parseLong(lines[i]);
	}
	return arrL;
}
}
