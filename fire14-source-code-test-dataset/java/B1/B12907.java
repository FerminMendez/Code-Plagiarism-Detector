package codejam;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Codejam {
    static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
    int casos = Integer.parseInt(keyboard.nextLine());
        for(int x=1; x<=casos;x++)
        {
           String a, b;
           String A[]=new String[1000];
           String linea;
           linea = keyboard.nextLine();
            	StringTokenizer tokens= new StringTokenizer(linea," ");
		a = tokens.nextToken();
                b = tokens.nextToken();
           int counter=0;
           for (int i=Integer.parseInt(a); i<Integer.parseInt(b); i++)
                {
                    String c = "" +i;
                    char[] achar = c.toCharArray();
                    if (achar.length==2)
                    {
                        int one=Integer.parseInt("" +achar[1])*10+Integer.parseInt("" +achar[0]); 
                        if (one<=Integer.parseInt(b)&&one>i)
                        counter+=1;
                    }
                     if (achar.length==3)
                    {
                        int one= Integer.parseInt("" +achar[2])*100+Integer.parseInt("" +achar[0])*10+Integer.parseInt("" +achar[1]); 
                        if (one<=Integer.parseInt(b)&&one>i)
                        counter+=1;
                        int two= Integer.parseInt("" +achar[1])*100+Integer.parseInt("" +achar[2])*10+Integer.parseInt("" +achar[0]); 
                        if (two<=Integer.parseInt(b)&&two>i)
                        counter+=1;
                    }
                }
           System.out.println("Case #" +x +": " +counter);
        }     
    }
}
