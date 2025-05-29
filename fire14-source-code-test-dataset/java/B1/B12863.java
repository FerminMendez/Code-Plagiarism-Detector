package google.codejam;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Main {
  private static boolean debug = false;

  public static void main(String [] args){
    if(args!=null && args.length==2){
      FileInputStream fstream = null;
      try {
        fstream = new FileInputStream(args[0]);
     // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        
        File file = new File(args[1]);

        FileWriter fstreamOut = new FileWriter(file.getAbsolutePath());
        BufferedWriter out = new BufferedWriter(fstreamOut);
        
        
        int lineNum = Integer.parseInt(br.readLine());
        
        GoogleSolver solver = new RecycledNumberSolver();
        //GooglereseSolver.calcualteMapping();
        
        
        for(int i=0 ; i<lineNum; i++){
          strLine = br.readLine();
          String resultStr = solver.solve(strLine);
          
          if(debug){            
            System.out.println (strLine + "->" + resultStr);
          }else{
            String output = "Case #"+(i+1) +": " + resultStr;
            System.out.println (output);
            out.write(output+"\n");
          }
        }
          
        out.close();
        in.close();
        
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
  }
}
