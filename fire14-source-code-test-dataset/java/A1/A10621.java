import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
import java.io.*;
import java.util.Scanner;

public class DancingWithTheGooglers{

  private long inversions = 0;
  
  public static void main(String[] args) throws FileNotFoundException{
    String filename = args[0];
    DancingWithTheGooglers countInversions = new DancingWithTheGooglers();
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
        ArrayList szamlista = new ArrayList(Arrays.asList(szamok));
	for (int i=0; i<szamlista.size(); ++i){
          if (szamlista.get(i).equals("")){
            szamlista.remove(i);
            i--;
          }else{
            szamlista.set(i,Integer.valueOf((String)szamlista.get(i)));
          }
        }
        String mashogy = new String();
        int o=0;
        int u=0;
        int N = ((Integer)(szamlista.get(0)));
        int S = ((Integer)(szamlista.get(1)));
        int p = ((Integer)(szamlista.get(2)));
        szamlista.remove(0);
        szamlista.remove(0);
        szamlista.remove(0);
        int w=4;
        if (p==1){
          w=2;
        }else if (p==0){
          w=0;
        }
        mashogy = mashogy.concat("Case #");
        mashogy = mashogy.concat(((Integer)j).toString());
        mashogy = mashogy.concat(": ");
        for (int i=0; i<szamlista.size(); ++i){
          if (((Integer)(szamlista.get(i)))<(3*p-w)){
            szamlista.remove(i);
            i--;
          }else if(((Integer)(szamlista.get(i)))>=(3*p-2)){
            szamlista.remove(i);
            i--;
            o++;
          }else if(u<S){
            szamlista.remove(i);
            i--;
            o++;
            u++;
          }
        }
//      String mashogy = (String)(szoveg.clone());
//      System.out.println(szoveg);
        mashogy = mashogy.concat(((Integer)o).toString());
        mashogy = mashogy.concat("\n");
        System.out.println(mashogy);
        out.write(mashogy);
      }    
      out.close();
    } catch (IOException e) {
    }
    scanner.close();
    return;
  }
}
