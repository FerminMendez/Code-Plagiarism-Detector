
import java.io.*;

public class FileReader {
    
    FileInputStream in;
    DataInputStream dis;
    BufferedReader br;
    public FileReader(File input) throws FileNotFoundException
    {
        in = new FileInputStream(input);
        dis = new DataInputStream(in);
        br = new BufferedReader(new InputStreamReader(dis));
    }
    
    public String nextString() throws IOException
    {
        return br.readLine();
    }
    
    public String[] nextStringArray() throws IOException
    {
        return br.readLine().split(" ");
    }
        
    public char nextChar() throws IOException
    {
        return (char)br.read();
    }
    
    public char[] nextCharArray() throws IOException
    {
        return br.readLine().toCharArray();
    }
    
    public int nextInt() throws IOException
    {
        return Integer.parseInt(nextString());
    }
    
    public int[] nextIntArray() throws IOException
    {
        String[] split = nextStringArray();
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++)
        {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
    
    public long nextLong() throws IOException
    {
        return Long.parseLong(nextString());
    }
    
    public long[] nextLongArray() throws IOException
    {
        String[] split = nextStringArray();
        long[] result = new long[split.length];
        for (int i = 0; i < split.length; i++)
        {
            result[i] = Long.parseLong(split[i]);
        }
        return result;
    }
            
}
