import java.util.Scanner;

public class Dance
{
    public static void main(String[] args)
    {
        Scanner jin=new Scanner(System.in);
        int numtries=jin.nextInt();

        jin.nextLine();
        for(int line=0; line<numtries; line++)
        {
            jin.nextInt();

            int surprises=jin.nextInt(), goal=jin.nextInt(), impossible=0;
            //System.out.println(jin.nextLine());
            String[] totals=jin.nextLine().substring(1).split(" ");
            //for(String it : totals) System.out.println(it);

            System.out.print("Case #"+(line+1)+": ");
            for(String each : totals)
            {
                //System.out.println("DEBUG: "+each);
                int total=Integer.parseInt(each), surprising=surprising(total, goal);

                //if(surprising) {surprises--; System.out.println(total+" comes as a surprise");}
                if(surprising!=1) //either tough or impossible
                {
                    if(surprising==0) surprises--; //System.out.println(total+" surprising");}
                    else impossible++; //System.out.println(total+" impossible");} //don't lose allowed surprises for impossibilities
                }
                //else System.out.println(total+" easy");
            }
            if(surprises>=0) System.out.print(totals.length-impossible);
            else System.out.print(totals.length+surprises-impossible);
            System.out.println();
        }
    }

    private static int surprising(int totalPoints, int bestScore)
    {
        if(bestScore>totalPoints) return -1; //impossible ... I can't score that well!

        double remaining=(totalPoints-bestScore)/2.0;

        if(remaining==bestScore) return 1; //unsurprising
        else if(remaining<bestScore) //return bestScore-(int)remaining<=1?1:0; //unsurprising or surprising, round down
        {
            int result=bestScore-(int)remaining;

            if(result<=1) return 1; //unsurprising
            else if(result<=2) return 0; //surprising
            else return -1; //impossible (diff gte 2)
        }
        else /*remaining>bestScore*/ return 1; //unsurprising //(int)(remaining+0.5)-bestScore>1; //round up
    }
}
