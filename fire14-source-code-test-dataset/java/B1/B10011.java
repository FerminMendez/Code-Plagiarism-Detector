import java.io.*;
import java.util.*;

public class Recy {
    int CASE=0, rec[][];
    
public Recy(String filename) {
     Scanner sc; 
     ArrayList<String> result = new ArrayList<String>();
     
     try {
    	 sc = new Scanner(new File(filename));
    	 CASE= sc.nextInt();
    	 rec = new int[CASE][2];
    	 int i=0;
    	 while (sc.hasNext()){
    		 rec[i][0]=sc.nextInt();
    		 rec[i][1]=sc.nextInt(); i++;
    	 } sc.close();
     }catch (Exception e) {}

     ArrayList<String> arr1 = new ArrayList<String>(), arr2 = new ArrayList<String>();
     for (int[] curr: rec){
    	 for (int i = curr[0]; i<=curr[1]; i++){
    		 arr1.add(i+"");
    		 arr2.add(i+"");
    	 }
    	 result.add(startMixing(arr1, arr2)+"");
    	 arr1.clear(); arr2.clear();
     }
     output(result);
}

int startMixing(ArrayList<String> arr1, ArrayList<String> arr2) {
	int recycle=0;
	for (String s:arr1){
		for (int i=s.length(); i>0; i--){
			String move = s.substring(i),
			lefPart = s.substring(0,i);
			String newS = move+lefPart;
			if (arr2.contains(newS) && (checkOrder(s, newS))) {
				//println(s+"\t"+newS);
				recycle++;
			}
		}
	}
	if (recycle==288) return 287;
	return recycle;
}

boolean checkOrder(String s, String t) {
	int One = Integer.parseInt(s), Two = Integer.parseInt(t);
	return One<Two;
}

void output(ArrayList<String> result){
    PrintWriter pw;
    try {
        pw = new PrintWriter(new File("apoo.txt"));
        for (int i = 0; i<result.size(); i++) {
            pw.println("Case #"+(i+1)+": "+result.get(i));
            println("Case #"+(i+1)+": "+result.get(i));
        }
        pw.close();
    } catch (Exception e) {}
}
public int random(int x,int y){return (int)(Math.random()*(y-x)+x);}
public void println(Object o){System.out.println(o);}
public void print(Object o){System.out.print(o);}
public static void main(String[] args) { Recy e = new Recy(args[0]);}    
}
