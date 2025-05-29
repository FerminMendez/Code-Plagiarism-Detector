import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CodeJam {
static String [][] mapping = new String [6][];
 static String f,s,t,ff,ss,tt;
public static  void map(){
	f = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
	s = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
	t = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
	ff="our language is impossible to understand";
	ss="there are twenty six factorial possibilities";
	tt="so it is okay if you want to just give up";
	mapping[0] = f.split(" ");
	mapping[1] = ff.split(" ");
	mapping[2] = s.split(" ");
	mapping[3] = ss.split(" ");
	mapping[4] = t.split(" ");
	mapping[5] = tt.split(" ");
}
public static String returnLetter(String l){
	if(l.equals("q")) return "z";
	if(l.equals("z")) return "q";
	for(int i=0;i<6;i+=2){
		for(int j=0;j<mapping[i].length;j++){
			int n;
			if((n=mapping[i][j].indexOf(l))!=-1){
				return mapping [i+1][j].charAt(n)+"";
			}
		}
	}
	return "***";
}
public static boolean isRecycled(String p1, String p2){
	if(p1.length()!=p2.length()) return false;
	for(int i=0;i<p1.length();i++){
		String s = p1.substring((p1.length()-i-1));
		if(p2.indexOf(s)==0 && p2.substring(s.length()).equals(p1.substring(0, (p1.length()-i-1)))) {return true;}
	}
	return false;
}
public static String decode(String sen){
	String res = "";
	for(int i=0;i<sen.length();i++){
		if((sen.charAt(i)+"").equals(" ")) {res+=" ";continue;}
		res = res + returnLetter(sen.charAt(i)+"");
	}return res;
}
public static int enumerate(int low,int high){
	int c=0;
	for(int i=low;i<high;i++){
		for(int j=i+1;j<=high;j++){
		 if(isRecycled(i+"", j+"")) c++;
		}
	}
	return c;
}
public static void main(String [] areg) throws IOException{
	map();
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(bf.readLine());
	for(int i=0;i<n;i++){
		String sen = bf.readLine();
		String [] r = sen.split(" ");
		System.out.println("Case #"+((int)(i+1))+": "+enumerate(Integer.parseInt(r[0]), Integer.parseInt(r[1])));
		
	}
//	String s = bf.readLine();
//	String ss = bf.readLine();
//	System.out.println(enumerate(Integer.parseInt(s), Integer.parseInt(ss)));
	
}



}
