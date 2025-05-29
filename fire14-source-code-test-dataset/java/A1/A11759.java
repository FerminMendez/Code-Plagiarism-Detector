import java.io.*;
import java.util.*;

public class Problem2
{
    static ArrayList<Integer> scores;
    public static void main(String args[])
    {
        try
        {
            FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            String line;
            int total;
            int i = 0, cases;
            Scanner sc;
            int number, surprising, minpoints;
            while ((line = br.readLine()) != null)
            {
                if(i == 0)
                {
                    total = Integer.parseInt(line);
                    i = 1;
                    continue;
                }
                sc = new Scanner(line);
                scores = new ArrayList<Integer>();
                number = sc.nextInt();
                surprising = sc.nextInt();
                minpoints = sc.nextInt();
                cases = 0;
                for(int j = 0; j < number; j++)
                {
                    scores.add(sc.nextInt());
                }
                for(int score : scores)
                {
                    int base = (int)(score/3);
                    
                    switch(score%3)
                    {
                        case 0:
                        {
                            if(base>=minpoints)
                            {
                                cases++;
                            }
                            else if(surprising > 0 && base > 0 && base + 1 >= minpoints)
                            {
                                cases++;
                                surprising--;
                            }
                            break;
                        }
                        case 1:
                        {
                            if(base>=minpoints | base + 1 >= minpoints)
                            {
                                cases++;
                            }
                            else if(surprising > 0 && base + 1 >= minpoints)
                            {
                                cases++;
                                surprising--;
                            }
                            break;
                        }
                        case 2:
                        {
                            if(base + 1>= minpoints | base>=minpoints)
                            {
                                cases++;
                            }
                            else if(surprising > 0 && base + 2 >= minpoints)
                            {
                                cases++;
                                surprising--;
                            }
                            break;
                        }
                    }
                }
                System.out.println("Case #"+i+": "+cases);
                write("Case #"+i+": "+cases);
                i++;
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }       
    }
    
 
    public static void write(String text)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Problem2Output.out"), true));
            bw.write(text);
            bw.newLine();
            bw.close();
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}