package codejam2012.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fedez
 */
public class ReadWriteUtil
{
    private static Logger logger = Logger.getLogger(ReadWriteUtil.class.getName());

    /**
     * Read a file from a location
     * @param fileName
     * @return
     * @throws java.io.IOException
     */
    public static List<String> readFile(String fileName) throws IOException
    {
        BufferedReader br = null;
        List<String> in = null;
        String line;

        try
        {
            br = new BufferedReader(new FileReader(fileName));
            in = new ArrayList<String>();
            while ((line = br.readLine()) != null)
            {
                in.add(line);
            }
        }
        catch (FileNotFoundException ex)
        {
            logger.log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (br != null)
            {
                br.close();
            }
        }
        return in;
    }

    /**
     * Write a file to location
     * @param fileName
     * @param content
     * @throws java.io.IOException
     */
    public static void writeFile(String fileName, List<String> content) throws IOException
    {
        BufferedWriter bw = null;
        try
        {
            bw = new BufferedWriter(new FileWriter(fileName));
            for (String line : content)
            {
                bw.write(line);
                bw.write(System.getProperty("line.separator"));
            }
        }
        catch (IOException ex)
        {
            logger.log(Level.SEVERE, null, ex);
        }
        finally
        {
            if (bw != null)
            {
                bw.close();
            }
        }
    }
}