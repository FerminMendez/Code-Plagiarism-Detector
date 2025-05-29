/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam2012;

/**
 *
 * @author ESIEN
 */
public class C {
        static int numOfDigits;
        final static int max = 1001;
        static int div;
        static boolean[] found = new boolean[max];
        static int[]p = new int[max];
    public static void main(String[] args)throws java.io.IOException{
        java.util.Scanner fromFile = new java.util.Scanner(new java.io.File("input.txt"));
        java.io.PrintStream intoFile = new java.io.PrintStream("output.txt");
        int testCase = fromFile.nextInt();
        for (int test = 1; test <= testCase; test++){
        int a = fromFile.nextInt();
        int b = fromFile.nextInt();
        numOfDigits = 0;
        int t = a;
        while((t/=10)!=0)
            numOfDigits++;
        div = (int)Math.pow(10,numOfDigits);
        int ind=0;
        int totalCount = 0;
        for (int i = a; i <= b; i++){
            if (found[i])
                continue;
            found[p[ind++]=i]=true;
            int c = 0;
            for (int j = 0,k=i%10*div+i/10; j < numOfDigits && k!=i; k=k%10*div+k/10, j++)
                if (k<=b&&k>=a){
                    c++;
                    found[p[ind++]=k]=true;
                }
            totalCount+=(c&1)==0?(c>>1)*(c+1):((c+1>>1)*c);
        }
        for(int i = 0; i < ind; i++)
            found[p[i]]=false;
        intoFile.printf("Case #%d: %d%n",test,totalCount);
        }
        intoFile.close();
        fromFile.close();
    }
}
