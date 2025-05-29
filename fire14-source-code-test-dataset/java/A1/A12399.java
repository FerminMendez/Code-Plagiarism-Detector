/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Floran
 */
public class Googlers {

    int nbCase;
	static String inName;
	static String outName;
        public final char h=(char) 104;
	
	public static void solve() throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(outName)));
		//Scanner in=new Scanner("A-small-practice.txt");
		BufferedReader in=new BufferedReader(new FileReader(inName));
		String ligne=in.readLine();
                // nb de cas
		System.out.println(ligne);
		int nbCase=Integer.parseInt(ligne);
                //compte
                int count=0;
                for(int i=1;i<=nbCase;i++){
                    int ns=0;//nb suprise
                    count=0;
                    String[] parametre=in.readLine().split(" ");
                    System.out.println("lenght"+parametre.length);
                    int nb=Integer.parseInt(parametre[0]);//nb de participant
                    System.out.println("nb"+nb);
                    int suprise=Integer.parseInt(parametre[1]);//nb de triplet surprise
                    System.out.println("sup"+suprise);
                    int min=Integer.parseInt(parametre[2]);//un quote du triplet doit être >=min
                    for(int m=3;m<nb+3;m++){
                        //int[][] tab=decomposition(Integer.parseInt(parametre[i]));
                        int[] tab=decomp(Integer.parseInt(parametre[m]));
                        if(tab.length==1){
                            //if(tab[0][2]>=min)
                            if(tab[0]>=min)
                                count++;
                        }
                        else{
                            //if(tab[0][2]>=min)
                            if(tab[0]>=min)
                                count++;
                            //else if(tab[0][2]>=min &&ns<=suprise){
                            else if(tab[1]>=min && ns<suprise){
                                ns++;
                                count++;
                            }
                        }
                    }
                    out.println("Case #"+i+": "+count);	
		}
		out.flush();
		out.close();
		in.close();
	}
   /* public static int[][] decomposition(int quote){
        int mod=quote%3;
        int div=quote/3;
        int[][] tab;
        if(mod==1){
            tab=new int[1][3];
            tab[0][0]=div;
            tab[0][1]=div;
            tab[0][2]=div+1;
            return tab;
        }
        if(mod==2){
            tab=new int[2][3];
            tab[0][0]=div;
            tab[0][1]=div+1;
            tab[0][2]=div+1;
            
            tab[1][0]=div;
            tab[1][1]=div;
            tab[1][2]=div+2;
            
            return tab;
        }
        else{
            tab=new int[2][3];
            tab[0][0]=div;
            tab[0][1]=div;
            tab[0][2]=div;
            
            tab[1][0]=div;
            tab[1][1]=div-1;
            tab[1][2]=div+1;
            
            return tab;
        }
    }*/
    public static int[] decomp(int quote){
        int mod=quote%3;
        int div=quote/3;
        int[] tab;
        if(mod==1){
            tab=new int[1];
            tab[0]=div+mod;
            return tab;
        }
        if(mod==2){
            tab=new int[2];
            tab[0]=div+(mod/2);
            tab[1]=div+mod;
            
            return tab;
        }
        else{
            tab=new int[2];
            tab[0]=div;
            if(quote==0)
                tab[1]=div;
            else
                tab[1]=div+1;
            
            return tab;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inName="A-small-practice.txt";
                //inName="test.txt";
		//outName="solution7.txt";
		inName="B-small-attempt4.in";
		outName="solution_small4.txt";
		//inName="A-large-practice.in";
		//outName="Large_solution.txt";
		try{
			solve();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("fini");
    }
}
