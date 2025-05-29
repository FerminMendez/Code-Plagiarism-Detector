
import java.io.*;

public class gcj
    {

    public static void main(String[] args) throws IOException
        {

            String fileName = "B-small-attempt0.in";
            FileReader reader = new FileReader(fileName);
            LineNumberReader lnreader = new LineNumberReader(reader);
            FileWriter writer = new FileWriter("output-B-small.txt");
			PrintWriter out = new PrintWriter(writer);

            String line = "";
            line = lnreader.readLine();
            int no_of_googlers = 0;
            int surprise;
            int min_score;
            int total_score;
            int rem_score;
            int count;
            int kase = 0;
            String[] strings = line.split(" ");
            int no_test_cases = Integer.parseInt(strings[0]);

            while ((line = lnreader.readLine()) != null){
                strings = line.split(" ");
                kase++;
                count = 0;
                no_of_googlers = Integer.parseInt(strings[0]);
                surprise = Integer.parseInt(strings[1]);
                min_score = Integer.parseInt(strings[2]);
                for (int i = 0;i<no_of_googlers;i++){
                    total_score = Integer.parseInt(strings[i+3]);
                    rem_score = total_score - min_score;
                    if ( rem_score > -1){ 
                    if (((min_score*2 - rem_score) < 3) ){
                        count++;
                    } else {
                        if ((min_score*2 - rem_score == 3) || (min_score*2 - rem_score == 4)){
                            if (surprise != 0) {
                                count ++;
                                surprise--;
                            }
                        }
                    }
					}
                }
				out.println("Case #" + (lnreader.
                getLineNumber()-1) + ": " + count);               
            }
            out.close();

        }

    }

