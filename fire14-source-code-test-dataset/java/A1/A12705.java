import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;
import java.io.*;

public class bx{
	public static void main(String[] args){
		try{			
			File output;
			FileWriter outputwriter;
			BufferedWriter out;
			String filename = "bx.out";
			
			output = new File(filename);
			outputwriter = new FileWriter(output);
			out = new BufferedWriter(outputwriter);
			
			//System.out.println("siap");
			//out.write("ardhianvv\nll");
			BufferedReader f = new BufferedReader(new FileReader("a.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int datax[][] = new int[][]{{0, 0, 0, 0,0},
{1, 0, 0, 1,0},
{10, 2, 4, 4,1},
{10, 3, 3, 4,0},
{11, 3, 3, 5,1},
{11, 3, 4, 4,0},
{12, 3, 4, 5,1},
{12, 4, 4, 4,0},
{13, 3, 5, 5,1},
{13, 4, 4, 5,0},
{14, 4, 4, 6,1},
{14, 4, 5, 5,0},
{15, 4, 5, 6,1},
{15, 5, 5, 5,0},
{16, 4, 6, 6,1},
{16, 5, 5, 6,0},
{17, 5, 5, 7,1},
{17, 5, 6, 6,0},
{18, 5, 6, 7,1},
{18, 6, 6, 6,0},
{19, 5, 7, 7,1},
{19, 6, 6, 7,0},
{2, 0, 0, 2,1},
{2, 0, 1, 1,0},
{20, 6, 6, 8,1},
{20, 6, 7, 7,0},
{21, 6, 7, 8,1},
{21, 7, 7, 7,0},
{22, 6, 8, 8,1},
{22, 7, 7, 8,0},
{23, 7, 7, 9,1},
{23, 7, 8, 8,0},
{24, 7, 8, 9,1},
{24, 8, 8, 8,0},
{25, 7, 9, 9,1},
{25, 8, 8, 9,0},
{26, 8, 8, 10,1},
{26, 8, 9, 9,0},
{27, 8, 9, 10,1},
{27, 9, 9, 9,0},
{28, 8, 10, 10,1},
{28, 9, 9, 10,0},
{29, 9, 10, 10,0},
{3, 0, 1, 2,1},
{3, 1, 1, 1,0},
{30, 10, 10, 10,0},
{4, 0, 2, 2,1},
{4, 1, 1, 2,0},
{5, 1, 1, 3,1},
{5, 1, 2, 2,0},
{6, 1, 2, 3,1},
{6, 2, 2, 2,0},
{7, 1, 3, 3,1},
{7, 2, 2, 3,0},
{8, 2, 2, 4,1},
{8, 2, 3, 3,0},
{9, 2, 3, 4,1},
{9, 3, 3, 3,0}
};
			int angka = Integer.parseInt(st.nextToken());
			for(int a=0;a<angka;a++){
				st = new StringTokenizer(f.readLine());
				String hh[] = st.nextToken("\n").split(" ");
				int n = Integer.parseInt(hh[0]);
				maxS = Integer.parseInt(hh[1]);
				minP = Integer.parseInt(hh[2]);
				maxx = 0;
				int ss[] = new int[n];
				ssx = new int[n][2][5];
				sx = new int[n];
				int gaDa = 0;
				for(int b=0;b<n;b++){
					ss[b] = Integer.parseInt(hh[3+b]);
					ssx[b][0][4] = ss[b];
					ssx[b][1][4] = ss[b];
					int ind =0;
					for(int c=0;c<datax.length;c++){
						if(datax[c][0]==ss[b]){
							ssx[b][ind][0] = datax[c][1];
							ssx[b][ind][1] = datax[c][2];
							ssx[b][ind][2] = datax[c][3];
							ssx[b][ind][3] = datax[c][4];														
							ind++;
						}
					}
				}
				
				if(a==0)
				for(int b=0;b<ssx.length;b++){
					for(int c=0;c<2;c++){
						System.out.println(ssx[b][c][0]+" "+ssx[b][c][1]+" "+ssx[b][c][2]+" "+ssx[b][c][3]+" "+ssx[b][c][4]);
					}
					System.out.println();
				}
				if(gaDa==0)
					find(0,0, new int[n][3]);
				if(a!=angka-1)					
					out.write("Case #"+(a+1)+": "+maxx+"\n");
				else
					out.write("Case #"+(a+1)+": "+maxx);
			}
			out.close();
		} catch(Exception cc){
			System.out.println(cc.toString());
		}
	}
	public static void find(int ind, int s, int data[][]){
		if(s==maxS){			
			for(int a=ind;a<data.length;a++){
				for(int c=0;c<ssx[a].length;c++)
					if(ssx[a][c][3]==0)
						if(ssx[a][c][0]+ssx[a][c][1]+ssx[a][c][2]==ssx[a][c][4]){
							data[a][0] = ssx[a][c][0];
							data[a][1] = ssx[a][c][1];
							data[a][2] = ssx[a][c][2];
						}				
			}
			System.out.println("+");
			for(int b=0;b<data.length;b++){
				System.out.println(data[b][0]+" "+data[b][1]+" "+data[b][2]);
			}
			System.out.println("-");
			maxx = Math.max(maxx,hitung(data));
		} else if(s<maxS && ind<data.length){
			if(ssx[ind][0][0]+ssx[ind][0][1]+ssx[ind][0][2]==ssx[ind][0][4]){
				data[ind][0] = ssx[ind][0][0];
				data[ind][1] = ssx[ind][0][1];
				data[ind][2] = ssx[ind][0][2];
				if(ssx[ind][0][3]==0)
					find(ind+1, s,data);
				else
					find(ind+1, s+1,data);
			}
			if(ssx[ind][1][0]+ssx[ind][1][1]+ssx[ind][1][2]==ssx[ind][1][4]){
				data[ind][0] = ssx[ind][1][0];
				data[ind][1] = ssx[ind][1][1];
				data[ind][2] = ssx[ind][1][2];
				if(ssx[ind][1][3]==0)
					find(ind+1, s,data);
				else
					find(ind+1, s+1,data);
			}
		}
	}
	public static int hitung(int [][] data){
		int hasil =0;
		for(int a=0;a<data.length;a++){
			if(data[a][0]>=minP || data[a][1]>=minP || data[a][2]>=minP){
				hasil++;
			}
		}
		return hasil;
	}
	public static int maxS = 0;
	public static int minP = 0;
	public static int maxx = 0;
	public static int ssx[][][] = new int[1][1][1];
	public static int sx[] = new int[1];
}