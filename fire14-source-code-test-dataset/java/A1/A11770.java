/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.qualification.googlersdance;

import java.util.List;
import util.BaseResolver;
import util.Util;

/**
 *
 * @author bohmd
 */
public class GooglersDance extends BaseResolver {

    int cases;

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args[0].equals("")) {
            throw new Exception("The first parameter must be the input file name without extension.");
        } else {
            new GooglersDance(args[0]).resolve();
        }
    }

    public GooglersDance(String file) {
        super(file);
    }

    @Override
    protected void executeLine(String line) throws Exception {
        if (getLineNum() == 0) {
            cases = Util.getInt(line);
        } else {
            List<Integer> lineCase = Util.getIntList(line);
            write(resolveCase(lineCase.get(0), lineCase.get(1), lineCase.get(2), lineCase.subList(3, lineCase.size())));
        }
    }
    
    protected String resolveCase(int dancersCount, int supricesCount, int p, List<Integer> points) {
        int count=0;
        for(Integer point: points)
        {
            if(point+3>3*p)
            {
                count++;
            }
            else if(point+5>3*p && supricesCount>0 && point>0)
            {
                supricesCount--;
                count++;
            }            
        }
        return " "+count;
    }
}
