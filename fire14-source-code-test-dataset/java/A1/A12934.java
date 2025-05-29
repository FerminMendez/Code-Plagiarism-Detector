package Dancing;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kevin
 * Date: 4/13/12
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dancing {

    public static Iterator<DanceSet> parseSets(String filename) throws IOException {
        File file = new File(filename);
        final BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine();
        //ehhh unclosed reader =P

        Iterator<DanceSet> itr = new Iterator<DanceSet>() {

            String line=null;
            @Override
            public boolean hasNext() {
                try{

                    line=reader.readLine();
                }   catch (Exception e){
                    throw new RuntimeException(e);
                }
                return line!=null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public DanceSet next() {
                if(line==null)
                    return null;
                String[] split = line.split("\\s");

                int[] numbers = new int[split.length];
                for(int i =0;i<split.length;++i){
                    numbers[i]=Integer.parseInt(split[i]);
                }

                DanceSet set = new DanceSet(numbers[0],numbers[1],numbers[2], Arrays.copyOfRange(numbers,3,numbers.length));

                return set;

            }


            @Override
            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        return itr;

    }

    public static int findMinimumWithLowScore(DanceSet set) {

        int used = 0;
        int answer = 0;
        boolean hasSuprisesLeft = used < set.sunrises;
        int smin = (set.minscore - 2) * 3;
        int min = (set.minscore - 1) * 3;

        if(set.minscore==0)
            return set.dancers;
        for (int score : set.scores) {

            if (score <= smin || score == 0)
                continue;
            if (score > smin && score <= min)
                if (!hasSuprisesLeft) {
                    continue;
                } else {
                    ++used;
                    hasSuprisesLeft = used < set.sunrises;
                }
            ++answer;

        }

        return answer;
    }

    public static void main(String[] argv) throws IOException {
        FileWriter output = new FileWriter("output.dance.txt");
        BufferedWriter writer = new BufferedWriter(output);
        Iterator<DanceSet> itr = parseSets(argv[0]);

        int cnum = 1;
        while(itr.hasNext()){
            int ans= findMinimumWithLowScore(itr.next());
            output.write(String.format("Case #%d: %d\n",cnum++,ans));

        }
        output.close();

    }

}
