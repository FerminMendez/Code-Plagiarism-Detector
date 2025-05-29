/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.qualification.recyclednumbers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.BaseResolver;
import util.Util;

/**
 *
 * @author bohmd
 */
public class RecycledNumbers extends BaseResolver {

    int cases;

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || args[0].equals("")) {
            throw new Exception("The first parameter must be the input file name without extension.");
        } else {
            new RecycledNumbers(args[0]).resolve();
        }
    }

    public RecycledNumbers(String file) {
        super(file);
    }

    @Override
    protected void executeLine(String line) throws Exception {
        if (getLineNum() == 0) {
            cases = Util.getInt(line);
        } else {
            List<Integer> lineCase = Util.getIntList(line);
            write(resolveCase(lineCase.get(0), lineCase.get(1)));
        }
    }
    
    protected String resolveCase(int min, int max) {
        Set<Pair> pairSet= new HashSet<Pair>();
        for(int i=min; i<=max; i++)
        {
            String n = i+"";
            for(int j=0; j<n.length(); j++)
            {
                String m = n.substring(j)+n.substring(0,j);
                int mInt=Integer.parseInt(m);
                if(mInt>i && mInt<=max)
                {
                    pairSet.add(new Pair(i, mInt));
                }
            }
        }
        return " "+pairSet.size();
    }
    
    private class Pair
    {
        int m;
        int n;

        public Pair(int n, int m) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair other = (Pair) obj;
            return (this.n == other.n && this.m == other.m) || (this.n == other.m && this.m == other.n);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 11 * hash + this.m + this.n;
            return hash;
        }
    }
}
