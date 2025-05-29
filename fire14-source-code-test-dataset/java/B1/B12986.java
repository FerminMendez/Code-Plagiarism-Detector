import static java.lang.System.*;
import java.util.*;
import java.io.*;
public class jellyfish {
	public static void one()throws IOException{
		TreeMap<String,String>t=new TreeMap<String,String>();
		Scanner keyb=new Scanner(new File("A-small-attempt2.in"));
		t.put("a","y");
		t.put("o","e");
		t.put("z","q");
		t.put("q","z");
		t.put("i","k");
		String a="ejp mysljylc kd kxveddknmc re jsicpdrysirbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcdde kr kd eoya kw aej tysr re ujdr lkgc jv";
		String b="our language is impossible to understandthere are twenty six factorial possibilitiesso it is okay if you want to just give up";
		String c[]=a.split("");
		String d[]=b.split("");
		for(int x=1;x<c.length;x++){
			t.put(c[x],d[x]);
		}
		int f=Integer.parseInt(keyb.nextLine());
		for(int x=1;x<=f;x++){
		String e=keyb.nextLine();	
		String g="";
		for(int y=0;y<e.length();y++){
			g+=t.get(e.substring(y,y+1));
		}
		out.println("Case #"+x+": "+g);}
	}
	public static void two() throws IOException{
		Scanner keyb=new Scanner(new File("pi.txt"));
		int a=keyb.nextInt();
		int b=keyb.nextInt();
		int c=keyb.nextInt();	
		String e[][]=new String[a][b];
		int z1=-1,z2=-1;
		for(int x=0;x<a;x++){
			String d[]=keyb.nextLine().split("");
			for(int y=1;y<d.length;y++){
				e[x][y-1]=d[y];
				if(e[x][y-1].equals("X")){
					z1=x;
					z2=y-1;
				}
			}
		}
		for(int x=0;x<a;x++){
			for(int y=0;y<b;y++){
				if(e[x][y].equals("#")){
					
				}
			}
		}
	}
	public static void three() throws IOException{
		Scanner keyb=new Scanner(new File("C-small-attempt0.in"));
		int a=Integer.parseInt(keyb.nextLine());
		for(int b=1;b<=a;b++){
			int c=keyb.nextInt();
			int d=keyb.nextInt();
			TreeSet<String>t=new TreeSet<String>();
			for(int x=c;x<d;x++){
				String g=Integer.toString(x);
				for(int y=g.length()-1;y>0;y--){
					String l="";
					l+=g.substring(y,g.length());
					l+=g.substring(0,y);
					int q=Integer.parseInt(l);
					String s=Integer.toString(q);
					if(s.length()==g.length()&&x<q&&q<=d){
						t.add(g+"_"+s);
					}
				}
			}
			out.println("Case #"+b+": "+t.size());
		}
	}
	public static void main(String []args)throws IOException{
		three();
			
			
	}
}
