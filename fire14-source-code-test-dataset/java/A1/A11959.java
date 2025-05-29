import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProblemB {


    int[][] resultset = new int[3][3];
    int googlersCount = 3;
    int surprising = 1;
    int winners=0;
    int count = 0;
    int p = 0;

    FileWriter fstream;
    BufferedWriter out;

    public static void main(String[] args) throws IOException {

        ProblemB p1 = new ProblemB();
        p1.fstream = new FileWriter("outB.txt");
        p1.out = new BufferedWriter(p1.fstream);
        p1.readFile("B-small-attempt0.in");

    }


    public void readFile(String filePath) {

        String[] result = null;

        try {
            FileReader input = new FileReader(filePath);
            BufferedReader bufRead = new BufferedReader(input);


            Scanner scan = new Scanner(input);

            this.count = scan.nextInt();


            for (int i = 0; i < count; i++) {
                winners = 0;
                this.googlersCount = scan.nextInt();
                this.surprising = scan.nextInt();
                this.p = scan.nextInt();
                int a[] = new int[googlersCount];
                for (int j=0; j<googlersCount;j++){

                     a[j] = scan.nextInt();
                }


                resultset = new int[googlersCount][3];
                for (int h = 0; h < a.length; h++)
                    resultset[h]=getCombinations(a[h],p);
                int[] g = new int[0];
                recursion(g);
                System.out.println(winners);



                out.write("Case #" + (i + 1) + ": "+winners);
                if (i<count-1)
                    out.write("\n");
            }
            bufRead.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    
    
    public int[] getCombinations(int a, int p) {
        int[] result = new int[3];
//        System.out.println("----" + a + ":");
        for (int i = 0; i <= 10; i++) {
            for (int j = i; j <= 10; j++) {
                for (int k = j; k <= 10; k++) {
                    if ((i + j + k) == a) {
                        int diff1 = Math.abs(i - j);
                        int diff2 = Math.abs(k - j);
                        int diff3 = Math.abs(i - k);
                        if (diff1 <= 2 && diff2 <= 2 && diff3 <= 2) {
//                            System.out.println(i + "-" + j + "-" + k);
                            Integer[] res = {i, j, k};
                            if (isSurprising(i, j, k) && ((i >= p) || (j >= p) || (k >= p))) {
                                result[0] = 1;
                            } else if (isSurprising(i, j, k)) {
                                result[1] = 1;
                            } else if ((i >= p) || (j >= p) || (k >= p)) {
                                result[2] = 1;
                            }
                        }
                    }
                }
            }

        }
        return result;
    }

    public void check() {
        for (int i=0; i<googlersCount; i++);
    }

    public boolean isSurprising(int a, int b, int c) {
        int diff1 = Math.abs(a - b);
        int diff2 = Math.abs(b - c);
        int diff3 = Math.abs(a - c);
        if (diff1 == 2 || diff2 == 2 || diff3 == 2) {
            return true;
        }
        return false;
    }

    public void recursion(int[] a){
        
        if (a.length<googlersCount-1){
            int[] b = new int[a.length+1];
            for (int rec=0;rec<a.length;rec++){
                b[rec]=a[rec];
            }
            for (int i=0; i<=2; i++){
                b[b.length-1]=0;
                if(resultset[b.length-1][i]==1 && i==0){
                    b[b.length-1]=1;    
                }
                if(resultset[b.length-1][i]==1 && i==1){
                    b[b.length-1]=2;
                }
                if(resultset[b.length-1][i]==1 && i==2){
                    b[b.length-1]=3;
                }
                recursion(b);
            }    
        } else {
            int[] b = new int[a.length+1];
            for (int rec=0;rec<a.length;rec++){
                b[rec]=a[rec];
            }
            for (int i=0; i<=2; i++){
                b[b.length-1]=0;
                if(resultset[b.length-1][i]==1 && i==0){
                    b[b.length-1]=1;
                }
                if(resultset[b.length-1][i]==1 && i==1){
                    b[b.length-1]=2;
                }
                if(resultset[b.length-1][i]==1 && i==2){
                    b[b.length-1]=3;
                }
                int surpCount=0;
                int winCount=0;
                for (int j=0; j<b.length;j++){

                    if (b[j]==1){
                        surpCount++;
                        winCount++;    
                    }
                    if(b[j]==2){
                        surpCount++;    
                    }
                    if(b[j]==3){
                        winCount++;
                    }

                }
                if (this.winners<=winCount && surpCount==this.surprising){
                    winners=winCount;
                }
                
                
            }
        }
    }
    

   
}
