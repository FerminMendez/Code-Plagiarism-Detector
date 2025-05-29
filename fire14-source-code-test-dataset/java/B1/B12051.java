import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



class Recycle extends Question{

	public Recycle(String in, String out) {
		super(in, out);
	}
	public void solve(){
		ArrayList<String> rst=new ArrayList<String>();
		try {
			data=read(file_in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cases=pInt(0);
		data.remove(0);
		
		int count=1;
		for(String s:data){
			int tot=0;
			ArrayList<Integer> arr=splitInt(s," ");
			int min=arr.get(0);
			int max=arr.get(1);
			for(int i=min;i<=max;i++){
				tot+=cycles(i,min,max);
			}
			tot=tot/2;
			rst.add("Case #"+count+": "+tot);
			count++;
		}
		try {
			write(file_out,rst);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int cycles(int val,int min,int max){
		String s=val+"";
		Set<Integer> ints=new HashSet<Integer>();
		for(int i=0;i<s.length();i++){
			s=shift(s);
			if(s.charAt(0)!='0'){
				int val2=pInt(s);
				if(val2>=min&&val2<=max){
					ints.add(val2);
				}
			}
		}
		
		return ints.size()-1;
	}
	public String shift(String s){
		return s.substring(1)+s.substring(0,1);
	}
	
	
}

class Question{
	String file_in;
	String file_out;
	ArrayList<String> data;
	
	public Question(String in,String out){
		file_in=in;
		file_out=out;
		try {
			data=read(file_in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void solve(){}
	public int pInt(int index){
		return Integer.parseInt(data.get(index));
	}
	public int pInt(String s){
		return Integer.parseInt(s);
	}
	public ArrayList<String> splitString(String s,String sep){
		ArrayList<String> arr=new ArrayList<String>();
		String[] ss=s.split(sep);
		for(int i=0;i<ss.length;i++){
			arr.add(ss[i]);
		}
		return arr;
	}
	public ArrayList<Integer> splitInt(String s,String sep){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		String[] ss=s.split(sep);
		for(int i=0;i<ss.length;i++){
			arr.add(Integer.parseInt(ss[i]));
		}
		return arr;
	}
	public ArrayList<String> splitString(int index,String sep){
		return splitString(data.get(index), sep);
	}
	public ArrayList<Integer> splitInt(int index,String sep){
		return splitInt(data.get(index), sep);
	}
	public ArrayList<String> read(String filename)
	throws IOException{
		ArrayList<String> arr=new ArrayList<String>();
		BufferedReader br=null;
		br=new BufferedReader(new FileReader(filename));
		String l=null;
		while((l=br.readLine())!=null){
			arr.add(l);
		}
		br.close();
		return arr;
	}
	public void write(String filename,ArrayList<String> data)
	throws IOException{
		PrintWriter pw=new PrintWriter(filename);
		for(String s:data){
			pw.println(s);
		}
		pw.close();
	}

}

public class Answer3 {
	public static void main(String[] args){
		
		Question a=new Recycle("C-small-attempt0.in","rst.txt");
		a.solve();
		
	}
	

}
