import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadWriter
{
    public ArrayList<String> readFile(String path){
        File file = new File(path);
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while((text=reader.readLine())!=null){
                strings.add(text);
            }
            return strings;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(reader!=null){
                    reader.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
    public void writeFile(ArrayList<String> list, String path){
        BufferedWriter out=null;
        try{
            FileWriter fstream = new FileWriter(path);
            out = new BufferedWriter(fstream);
            for(String s : list){
                out.write(s);
                out.write("\r\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(out!=null){
                    out.close();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
