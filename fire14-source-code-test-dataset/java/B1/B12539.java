package Main;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: arran
 * Date: 14/04/12
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Round {
    public StringBuilder parse(BufferedReader in) throws IOException {
        StringBuilder out = new StringBuilder();
        String lineCount = in.readLine();

        for (int i = 1; i <= Integer.parseInt(lineCount); i++)
        {
            out.append("Case #"+i+": ");
            String line = in.readLine();
            String[] splits = line.split(" ");
            int p1 = Integer.valueOf(splits[0]);
            int p2 = Integer.valueOf(splits[1]);
            int r = pairRecyclable(p1, p2);
            out.append(r);

//            if (i < Integer.parseInt(lineCount))
                out.append("\n");
        }
        return out;
    }

    public static int pairRecyclable(int i1, int i2) {
        HashSet<String> hash = new HashSet<String>();
        for (int i = i1; i < i2; i++)
        {
            String istr = String.valueOf(i);
            if (istr.length() < 2) continue;
            for (int p = 0; p < istr.length() ; p++)
            {
                String nistr = istr.substring(p,istr.length()).concat(istr.substring(0,p));
                if (Integer.valueOf(nistr) < i1) continue;
                if (Integer.valueOf(nistr) > i2) continue;
                if (nistr.equals(istr)) continue;
                String cnistr = (Integer.valueOf(nistr) > Integer.valueOf(istr)) ?  istr + "," + nistr : nistr + "," + istr;
                hash.add(cnistr);
            }
        }
        return hash.size();
    }

    public static void main(String[] args) {
        InputStreamReader converter = null;
        try {
            int attempt = 0;
            String quest = "C";
            converter = new InputStreamReader(new FileInputStream("src/resource/"+quest+"-small-attempt"+attempt+".in"));
            BufferedReader in = new BufferedReader(converter);
            Round r = new Round();
            String str = r.parse(in).toString();
            System.out.print(str);
            FileOutputStream fos = new FileOutputStream(quest+"-small-attempt"+attempt+".out");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(str);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
