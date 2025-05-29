import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
import java.io.*;
import java.util.Scanner;

public class RecycledNumbers{

  private long inversions = 0;
  
  public static void main(String[] args) throws FileNotFoundException{
    String filename = args[0];
    RecycledNumbers countInversions = new RecycledNumbers();
    countInversions.readArray(filename);
//    list = countInversions.sortAndCount(list);
//    System.out.println(list);
//    System.out.println(countInversions.inversions);
  }
  
  private void readArray( String filename ) throws FileNotFoundException{
    ArrayList<Integer> list = new ArrayList<Integer>();
    File fFile = new File(filename);
    Scanner scanner = new Scanner(new FileReader(fFile));
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter("outfilename"));
      int k = Integer.valueOf(scanner.nextLine());
      for (int j=1; j<=k; ++j){
        String szoveg = scanner.nextLine();
        Object[] szamok =szoveg.split("[^0-9]");
        int A = Integer.valueOf((String)szamok[0]);
        int B = Integer.valueOf((String)szamok[1]);

        String mashogy = new String();

        mashogy = mashogy.concat("Case #");
        mashogy = mashogy.concat(((Integer)j).toString());
        mashogy = mashogy.concat(": ");


        int s=0;
        for (int i=A; i<B; ++i){
          int l = ((Integer)A).toString().length();
//          System.out.println(l);
          ArrayList<Integer> elerh = new ArrayList<Integer>();
          for (int f=1; f<l; ++f){
            int pow = (int)Math.floor(Math.pow(10,f));
            int powpot = (int)Math.floor(Math.pow(10,l-f));
            int ael = i/pow;
            int aveg = i%pow;
            int ford = powpot*aveg+ael;
            if (ford>i && ford<=B && !elerh.contains(ford)){
//              System.out.println(pow+" "+ael+" "+aveg+" "+ford);
              elerh.add(ford);
              s++;
            }
          }
        }
//      String mashogy = (String)(szoveg.clone());
//      System.out.println(szoveg);
        mashogy = mashogy.concat(((Integer)s).toString());
        mashogy = mashogy.concat("\n");
        out.write(mashogy);
      }    
      out.close();
    } catch (IOException e) {
    }
    scanner.close();
    return;
  }
}
