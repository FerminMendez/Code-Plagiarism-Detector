import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Dancing {
	public static void main(String args[]){
		Scanner scan = null;
		try{
		scan = new Scanner(new File(JOptionPane.showInputDialog("Please input filepath, e.g. C:/Documents/A-small.in")));
		}
		catch(FileNotFoundException e){}
		String ans = "";
		
		int T = Integer.parseInt(scan.nextLine());
		for(int i=0; i<T; i++){
			String[] data = scan.nextLine().split(" ");
			int N = Integer.parseInt(data[0]);
			int S = Integer.parseInt(data[1]);
			int p = Integer.parseInt(data[2]);
			int[] tots = new int[N];
			for(int j=0; j<N; j++) tots[j] = Integer.parseInt(data[3+j]);
			ans += "Case #" + (i+1) + ": ";
			int ok = 0;
			if(N==1) ok = doOne(S,p,tots);
			if(N==2) ok = doTwo(S,p,tots);
			if(N==3) ok = doThree(S,p,tots);
			ans += ok + "\r\n";
		}
		
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileOutputStream("output.txt"));
		}catch(FileNotFoundException e){}
		pw.write(ans);
		pw.close();
		scan.close();
	}
	
	public static int doOne(int S, int p, int[] tots){
		int numOverP = 0;
		ArrayList<int[]> a = getPoss(tots[0]);
		for(int i=0; i<2; i++){
			if(a.get(i)==null) continue;
			int tmpS = (isSurp(a.get(i))?1:0);
			if(S!=tmpS) continue;
			int tmpAns = ((best(a.get(i))>=p)?1:0);
			numOverP=Math.max(numOverP, tmpAns);
		}
		return numOverP;
	}
	
	public static int doTwo(int S, int p, int[] tots){
		int numOverP = 0;
		ArrayList<int[]> a = getPoss(tots[0]);
		ArrayList<int[]> b = getPoss(tots[1]);
		for(int i=0; i<2; i++){
			if(a.get(i)==null) continue;
			for(int j=0; j<2; j++){
				if(b.get(j)==null) continue;
				int tmpS = (isSurp(a.get(i))?1:0) + (isSurp(b.get(j))?1:0);
				if(S!=tmpS) continue;
				int tmpAns = ((best(a.get(i))>=p)?1:0) + ((best(b.get(j))>=p)?1:0);
				numOverP=Math.max(numOverP, tmpAns);
			}
		}
		return numOverP;
	}

	public static int doThree(int S, int p, int[] tots){
		int numOverP = 0;
		ArrayList<int[]> a = getPoss(tots[0]);
		ArrayList<int[]> b = getPoss(tots[1]);
		ArrayList<int[]> c = getPoss(tots[2]);
		for(int i=0; i<2; i++){
			if(a.get(i)==null) continue;
			for(int j=0; j<2; j++){
				if(b.get(j)==null) continue;
				for(int k=0; k<2; k++){
					if(c.get(k)==null) continue;
					int tmpS = (isSurp(a.get(i))?1:0) + (isSurp(b.get(j))?1:0) + (isSurp(c.get(k))?1:0);
					if(S!=tmpS) continue;
					int tmpAns = ((best(a.get(i))>=p)?1:0) + ((best(b.get(j))>=p)?1:0) + ((best(c.get(k))>=p)?1:0);
					numOverP=Math.max(numOverP, tmpAns);
				}
			}
		}
		return numOverP;
	}
	
	public static ArrayList<int[]> getPoss(int tot){
		int[] notSur = null;
		int[] sur = null;
		int maxNotSur = 0;
		int maxSur = 0;
		ArrayList<int[]> a = new ArrayList<int[]>();
		for(int i=0; i<11; i++){
			for(int j=i; j<11 && j<i+3; j++){
				for(int k=j; k<11 && k<i+3; k++){
					if(i+j+k==tot){
						int[] um = new int[3];
						um[0] = i; um[1] = j; um[2] = k;
						if(isSurp(um)){
							if(sur==null) sur=new int[3];
							if(best(i,j,k)>=maxSur){
								maxSur = best(i,j,k);
								sur[0]=i;sur[1]=j;sur[2]=k;
							}
						} else {
							if(notSur==null) notSur=new int[3];
							if(best(i,j,k)>=maxNotSur){
								maxNotSur = best(i,j,k);
								notSur[0]=i;notSur[1]=j;notSur[2]=k;
							}
						}
					}
				}
			}
		}
		a.add(notSur);
		a.add(sur);
		return a;
	}
	
	public static int best(int[] t){
		return best(t[0],t[1],t[2]);
	}
	
	public static int best(int a, int b, int c){
		return Math.max(Math.max(a,b), c);
	}
	
	public static boolean isSurp(int[] t){
		int a = Math.abs(t[0]-t[1]);
		int b = Math.abs(t[0]-t[2]);
		int c = Math.abs(t[2]-t[1]);
		if(a>=2 || b>=2 || c>=2) return true;
		return false;
	}
}
