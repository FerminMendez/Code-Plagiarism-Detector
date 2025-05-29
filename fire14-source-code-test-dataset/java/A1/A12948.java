import java.util.*;
import java.io.*;
public class CodeJam2{
public static HashMap<Integer,Vector<Integer>> perm = new HashMap<Integer,Vector<Integer>>();
public static void main(String args[]) throws IOException{
llenar();
BufferedReader lector = new BufferedReader(new FileReader(args[0]));
String tmp = lector.readLine();
int uu = 1;
while((tmp = lector.readLine())!=null){
String tar[] = tmp.split(" ");
int sorpr = Integer.parseInt(tar[1]),r = 1<<Integer.parseInt(tar[0]);
int cond = Integer.parseInt(tar[2]);
int max =0;
for(int n = 0;n<=r;n++){
int tmpMax = 0;
int cont = 0,contt=0,mm=n;
do{
if((mm&1)==1)
cont++;
if(sat(Integer.parseInt(tar[3+contt]),cond,mm&1))tmpMax++;
contt++;
}while((mm>>=1)>0 && contt<Integer.parseInt(tar[0]));
if(cont!=sorpr)continue;
for(int u = contt;u<Integer.parseInt(tar[0]);u++)
if(sat(Integer.parseInt(tar[3+u]),cond,0))tmpMax++;
max = Math.max(tmpMax,max);
}
System.out.println("Case #"+(uu++)+": "+max);
}

}
public static boolean sat(int num,int cond,int r){
Vector<Integer> tmpp = perm.get(num);
return tmpp.get(r*3+2)>=cond;
}
public static void llenar(){//0 no sat, 1 sat

for(int n = 0;n<31;n++){
int tmpMaxx[][] = new int[2][3];
for(int nn = 0;nn<=n;nn++)
for(int nnn = 0;nnn<=nn;nnn++)
for(int nnnn =0;nnnn<=nnn;nnnn++)
if((nn-nnnn)<=2 && ((nn+nnn+nnnn)==n)){
if((nn-nnnn)==2 && nn>tmpMaxx[1][2]){
tmpMaxx[1][0]=nnnn;
tmpMaxx[1][1]=nnn;
tmpMaxx[1][2]=nn;
}else if((nn-nnnn)!=2 && nn>tmpMaxx[0][2]){
tmpMaxx[0][0]=nnnn;
tmpMaxx[0][1]=nnn;
tmpMaxx[0][2]=nn;
}

}
Vector<Integer> rejoder = new Vector<Integer>();
for(int k =0;k<tmpMaxx.length;k++)
for(int kk = 0;kk<tmpMaxx[k].length;kk++)
rejoder.add(tmpMaxx[k][kk]);
perm.put(n,rejoder);
//System.out.println(n+" "+rejoder);
}

}
}
