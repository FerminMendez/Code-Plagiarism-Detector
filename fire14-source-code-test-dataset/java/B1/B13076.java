import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pair
{
    private int A;
    private int B;
    private int pairs;

    public Pair(int A, int B)
    {
        this.A = A;
        this.B = B;
        this.pairs = 0;
    }

    public int getA()
    {
        return this.A;
    }

    public int getB()
    {
        return this.B;
    }

    public int getPairs()
    {
        return this.pairs;
    }

    public String snake(String the_string, int position)
    {
        int len = the_string.length();
        int point = len - position;
        String end = the_string.substring(point);
        String build = end + the_string.substring(0, point);
        return build;
    }

    public void finder(int base, int limit)
    {
        ArrayList<String> doubles = new ArrayList<String>();
        String the_base = Integer.toString(base);
        int len = the_base.length();

        for(int i = 1; i < len; i++)
        {
            String answ = this.snake(the_base, i);

            if(!doubles.contains(answ))
            {
                int answer = Integer.parseInt(answ);

                if(answer <= limit && base < answer)
                {
                    doubles.add(answ);
                    this.pairs++;
                }
            }
        }
    }

    public void find_pairs()
    {
        int the_A = this.A;

        while(the_A < this.B)
        {
            this.finder(the_A, this.B);
            the_A++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        String file = JOptionPane.showInputDialog("Enter the name of the file you wish to use.");
        Scanner in = new Scanner(new FileReader(file));
        FileWriter fstream = new FileWriter("out.txt");
        BufferedWriter out = new BufferedWriter(fstream);

        String integ = in.nextLine();
        int cases = Integer.parseInt(integ);

        for(int i = 0; i < cases; i++)
        {
            String ab = in.nextLine();
            Scanner abs = new Scanner(ab);
            String a = abs.next();
            String b = abs.next();
            int int_a = Integer.parseInt(a);
            int int_b = Integer.parseInt(b);

            Pair current = new Pair(int_a, int_b);
            current.find_pairs();

            System.out.println("Case #" + (i + 1) + ": " + current.getPairs());

            out.write("Case #" + (i + 1) + ": " + current.getPairs() + "\r\n");
        }
        out.close();
    }
}
