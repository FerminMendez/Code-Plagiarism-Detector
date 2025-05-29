import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class Case1 extends Question{
	public Case1(String in, String out) {
		super(in, out);
	}
	class Unit{
		int c;
		int i;
		ArrayList<Integer> items;
		ArrayList<Integer> items_old;
		public Unit(int c,int i,ArrayList<Integer> items){
			this.c=c;
			this.i=i;
			this.items=items;
			items_old=new ArrayList<Integer>();
			items_old.addAll(items);
		}
		public String solve(){
			int st=0;
			int ed=items.size()-1;
			Collections.sort(items);
			while(true){
				int small=items.get(st);
				int large=items.get(ed);
				int sum=small+large;
				if(sum>c) ed--;
				else if(sum<c) st++;
				else break;
			}
			boolean small_found=false;
			boolean large_found=false;
			ArrayList<Integer> rr=new ArrayList<Integer>();
			for(int k=0;k<items.size();k++){
				if(!small_found&&items_old.get(k)==items.get(st)){
					rr.add(k+1);
				}else if(!large_found&&items_old.get(k)==items.get(ed)){
					rr.add(k+1);
				}			}
			return rr.get(0)+" "+rr.get(1);
		}
	}
	public void solve(){
		ArrayList<Unit> units=new ArrayList<Unit>();
		ArrayList<String> rst=new ArrayList<String>();
		int n=pInt(0);
		int i=1;
		while(i<data.size()){
			int c=pInt(i++);
			int i_n=pInt(i++);
			ArrayList<Integer> arr=splitInt(i++," ");
			units.add(new Unit(c,i,arr));
		}
		for(int j=0;j<units.size();j++){
			String r="Case #"+(j+1)+": "+units.get(j).solve();
			rst.add(r);
		}
		try {
			write(file_out,rst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Case2 extends Question{
	Map<Character,Integer> rate=new HashMap<Character,Integer>();
	Map<Character,Character> change=new HashMap<Character,Character>();
	public Case2(String in, String out) {
		super(in, out);
	}
	public void solve(){
		ArrayList<String> graph=new ArrayList<String>();
		ArrayList<String> rst=new ArrayList<String>();
		change.put('a','y');
		change.put('b','h');
		change.put('c','e');
		change.put('d','s');
		change.put('e','o');
		change.put('f','c');
		change.put('g','v');
		change.put('h','x');
		change.put('i','d');
		change.put('j','u');
		change.put('k','i');
		change.put('l','g');
		change.put('m','l');
		change.put('n','b');
		change.put('o','k');
		change.put('p','r');
		change.put('q','z');
		change.put('r','t');
		change.put('s','n');
		change.put('t','w');
		change.put('u','j');
		change.put('v','p');
		change.put('w','f');
		change.put('x','m');
		change.put('y','a');
		change.put('z','q');
		int count=0;
		for(String s:data){
			String n="";
			for(int i=0;i<s.length();i++){
				char c=s.charAt(i);
				if(rate.containsKey(c)){
					rate.put(c,rate.get(c)+1);
				}else{
					rate.put(c,1);
				}
				if(change.containsKey(c)){
					c=change.get(c);
				}
				n=n+c;
			}
			if(count!=0)
				rst.add("Case #"+count+": "+n);
			count++;
		}
		Map<String,Integer> word_map=new HashMap<String,Integer>();
		for(String s:data){
			ArrayList<String> words=splitString(s," ");
			for(String w:words){
				if(word_map.containsKey(w)){
					word_map.put(w,word_map.get(w)+1);
				}else{
					word_map.put(w,1);
				}
			}
		}
		Set<String> key_word=word_map.keySet();
		for(String w:key_word){
			if(word_map.get(w)>2){
				if(w.length()<=2)
					System.out.println(w+":"+word_map.get(w));
			}
		}
		for(String w:key_word){
			if(word_map.get(w)>2){
				if(w.length()==3)
					System.out.println(w+":"+word_map.get(w));
			}
		}		
		for(String w:key_word){
			if(word_map.get(w)>2){
				if(w.length()==4)
					System.out.println(w+":"+word_map.get(w));
			}
		}		
		
		Set<Character> keys=rate.keySet();
		for(char key='a';key<='z';key++){
			System.out.println(key+":"+rate.get(key));
		}
		try {
			write(file_out,rst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Dancer extends Question{

	public Dancer(String in, String out) {
		super(in, out);
		// TODO Auto-generated constructor stub
	}
	public void solve(){
		try {
			data=read(file_in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cases=pInt(0);
		data.remove(0);
		ArrayList<String> rst=new ArrayList<String>();
		int count=1;
		for(String s:data){
			ArrayList<Integer> arr=splitInt(s," ");
			int num=arr.remove(0);
			int sp=arr.remove(0);
			int cut=arr.remove(0);
			int cut_normal=cut*3-2;
			int cut_sp=cut==1?1:cut*3-4;
			int besters=0;
			for(int i:arr){
				if(i>=cut_normal)
					besters++;
				else if(i>=cut_sp){
					if(sp>0){
						besters++;
						sp--;
					}
				}

			}
			String add="Case #"+count+": "+besters;
			rst.add(add);
			count++;
		}
		try {
			write(file_out,rst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

public class Test {
	public static void main(String[] args){
		
		Question a=new Dancer("B-small-attempt0.in","rst.txt");
		a.solve();
		
	}
	

}
