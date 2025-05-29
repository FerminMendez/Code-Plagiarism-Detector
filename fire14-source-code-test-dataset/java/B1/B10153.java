import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class CodeJam
{
    private static BufferedReader reader;
    private static BufferedWriter writer;
    
    public static void main(String args[]) throws Exception
    {
        prepareFiles("C-small-attempt0");
        
        int T = Integer.parseInt(reader.readLine());
     
        for(int i = 0; i < T; i++)
        {
            String[] line = reader.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            
            int l = String.valueOf(A).length();
            int recycled = 0;
            
            for(int n = A; n <= B; n++)
            {
                HashSet<Integer> checkedCycles = new HashSet<>();
                String recycledSequence = String.valueOf(n);
                
                for(int j = 1; j < l; j++)
                {
                    recycledSequence = recycle(recycledSequence);
                    
                    int recycledInt = Integer.valueOf(recycledSequence);
                    
                    if(checkedCycles.contains(recycledInt))
                    {
                        continue;
                    }
                    else
                    {
                        checkedCycles.add(recycledInt);
                    }
                        
                    if(n < recycledInt && recycledInt <= B)
                    {
                        recycled ++;
                    }
                }
            }
            
            print(getCase(i + 1));
            print(recycled);
            print("\n");
        }
        
        putAwayFiles();
    }
    
    private static String recycle(String sequence)
    {
        String newSequence = new String();
        
        newSequence += sequence.charAt(sequence.length() - 1);
        
        for(int i = 0; i < sequence.length() - 1; i++)
        {
            newSequence += sequence.charAt(i);
        }
        
        return newSequence;
    }
    
    private static void prepareFiles(String fileName) throws IOException
    {
        reader = new BufferedReader(new FileReader(new File(fileName + ".in")));
        writer = new BufferedWriter(new FileWriter(new File(fileName + ".out")));
    }
    
    private static void putAwayFiles() throws IOException
    {
        reader.close();
        writer.flush();
        writer.close();
    }
    
    private static String getCase(int i)
    {
        return "Case #" + i + ": ";
    }
    
    private static void print(Object object) throws IOException
    {
        System.out.print(object.toString());
        writer.write(object.toString());
    }
}


