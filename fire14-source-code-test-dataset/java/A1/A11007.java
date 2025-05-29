/*
ID: t.lam1
LANG: JAVA
TASK: codejam
*/
import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;


class codejam {

  	public static void main (String [] args) throws IOException{
		codejam a=new codejam();
		a.run();
	}
	public void run()throws IOException
	{
		dancing();
	}
	public void recycle()throws IOException{
		Scanner file = new Scanner(new File("codejam.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("codejam.out")));
    	int cases = file.nextInt();
    	file.nextLine();
    	ArrayList<String> done = new ArrayList<String>();
    	for(int x =0; x<cases; x++){
    		out.print("Case #"+(x+1)+": ");
    		int a = file.nextInt(), b = file.nextInt(), c = 0;
    		for(int n = a; n<=b; n++){
    			for(int m = n+1; m<=b; m++){
    				if(n<10||m<10)continue;
    				else if(done.contains(""+n+m)){
    					
    				}
    				else{
    					String nn = ""+n, mm=""+m, temp = mm;
    					mm = mm.substring(mm.length()-1)+mm.substring(0,mm.length()-1);
    					while(!mm.equals(temp)){
    						if(mm.equals(nn)){
    							c++;
    							done.add(""+n+m);
    							break;
    						}
    						mm = mm.substring(mm.length()-1)+mm.substring(0,mm.length()-1);
    					}
    				}
    			}
    		}
    		out.println(c);
    	}

    	out.close();
	}
	public void dancing()throws IOException{
		Scanner file = new Scanner(new File("codejam.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("codejam.out")));
    	int cases = file.nextInt();
    	file.nextLine();
    	for(int x =0; x<cases; x++){
    		out.print("Case #"+(x+1)+": ");
    		Scanner chop = new Scanner(file.nextLine());
    		int N = chop.nextInt(), S = chop.nextInt(), P = chop.nextInt(), nums = 0;
    		ArrayList<Integer> googlers = new ArrayList<Integer>();
    		for(int y = 0; y<N; y++){
    			googlers.add(chop.nextInt());
    		}
    		System.out.print(N+" "+S+" "+P+" ");
    		for(Integer a: googlers){
    			System.out.println();
    		
    			System.out.println(a+" ");
    			int temp = a/3;
    			int temp2 = a;

    			if(S>0){
    				System.out.println("bye");
    				if(P-(temp2-P)/2==2){
    					S--;
    					nums++;
    				}
	    			if(temp2-2*temp>=P&&(temp2-2*temp)-temp<2)nums++;
	    			else{
	    				temp++;
	    				if((temp2-2*temp>=P||temp==P)&&temp-(temp2-2*temp)<2)nums++;
	    			}
    			}
    			else{
    				System.out.println("hi");
	    			if(temp2-2*temp>=P&&(temp2-2*temp)-temp<2)nums++;
	    			else{
	    				System.out.println("else");
	    				temp++;
	    				if((temp2-2*temp>=P||temp==P)&&temp-(temp2-2*temp)<2)nums++;
	    			}
    			}

    		}
    		System.out.println("nums: "+nums);
    		out.println(nums);
    	}
    	out.close();
	}
	public void googleRese()throws IOException{
		Scanner file = new Scanner(new File("codejam.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("codejam.out")));
    	int x = file.nextInt(); file.nextLine();
    	//ArrayList<String> cases = new ArrayList<String>();
    	Map<Character,Character> remap = new TreeMap<Character,Character>();
    	remap.put('a','y');
		remap.put('b','h');
		remap.put('c','e');
		remap.put('d','s');
		remap.put('e', 'o');
		remap.put('f', 'c');
		remap.put('g', 'v');
		remap.put('h', 'x');
		remap.put('i', 'd');
		remap.put('j', 'u');
		remap.put('k', 'i');
		remap.put('l', 'g');
		remap.put('m', 'l');
		remap.put('n', 'b');
		remap.put('o', 'k');
		remap.put('p', 'r');
		remap.put('r', 't');
		remap.put('s', 'n');
		remap.put('t', 'w');
		remap.put('u', 'j');
		remap.put('v', 'p');
		remap.put('w', 'f');
		remap.put('x', 'm');
		remap.put('y','a');
		remap.put('z','q');
		remap.put('q','z');
		remap.put(' ',' ');
        for(int y = 1; y<=x; y++){
        	String temp = file.nextLine();
        	out.print("Case #"+y+": ");
        	for(Character a: temp.toCharArray()){
        		if(remap.get(a)==null)System.out.println(a);
        		out.print(remap.get(a));
        	}
        	out.println();
        }   	
		out.close();
	}

}
