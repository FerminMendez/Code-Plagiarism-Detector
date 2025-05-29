import java.util.*;
/**
 * Google Code Jam 2012 Qualification Round Problem B: Dancing With the Googlers
 * 
 * @author Wayne Roswell
 * @version (4/14/2012 3:20PM EST)
 */
public class Dancing
{
    public static void main(String[] args)
    {
        Scanner a = new Scanner(System.in);
        
        String b = a.nextLine();
        int c = Integer.parseInt(b);
        
        for(int i = 0; i < c; i++)
        {
            String d = a.nextLine();
            String[] e = d.split(" ");
            int number = Integer.parseInt(e[0]);
            int surprises = Integer.parseInt(e[1]);
            int score = Integer.parseInt(e[2]);
            int[] dancers = new int[number];
            int y = 0;
            for(int j = 0; j < number; j++)
            {
                dancers[j] = Integer.parseInt(e[j + 3]);
            }
            
            for(int j = 0; j < number; j++)
            {
                int even = dancers[j] / 3;
                int[] add = {even, even, even};
                
                int diff = dancers[j] - score;
                int other = diff / 2;
                int mod = diff % 2;
                //System.out.println(dancers[j] + " " + even + " " + diff + " " + other + " " + score);
                /*if(score == other)
                {
                    y++;
                }
                else
                {
                    if((score + (other * 2)) == dancers[j])
                    {
                        if(Math.abs(score - other) == 1)
                        {
                            y++;
                        }
                        else if(Math.abs(score - other) == 2 && surprises > 0)
                        {
                            surprises--;
                            y++;
                        }
                    }
                }*/
                int sum = add[0] + add[1] + add[2];
                if(even >= score)
                {
                    y++;
                }
                else
                {
                    if(dancers[j] == sum)
                    {
                        if(even >= score)
                        {
                            y++;
                        }
                        else if((score - even) == 1 && surprises > 0 && dancers[j] > 0 && (score - other) < 3 && (other + mod) < 11)
                        {
                            surprises--;
                            y++;
                        }
                    }
                    else
                    {
                        if(even >= score)
                        {
                            y++;
                        }
                        else if((score - even) == 1 && dancers[j] > 0 && (score - other) < 3 && (other + mod) < 11)
                        {
                            y++;
                        }
                        else if((score - even) == 2 && surprises > 0 && dancers[j] > 0 && (score - other) < 3 && (other + mod) < 11)
                        {
                            surprises--;
                            y++;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + y);
        }
    }
}