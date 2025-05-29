package codejam2012.qr.dancing;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fedez
 */
public class DancerSolver
{

    private static Logger logger = Logger.getLogger(DancerSolver.class.getName());

    public static int solve(int googlers, int[] scores, int suprises, int scoreTopass)
    {
        AtomicInteger surprisesLeft;
        int numberOfPasses = 0;
        int score, i, possible;

        surprisesLeft = new AtomicInteger(suprises);
        for (i = 0; i < googlers; i++)
        {
            score = scores[i];
            possible = isItPossible(score, surprisesLeft, scoreTopass);
            logger.log(Level.INFO, "Score:{0}, surprisesLeft:{1}, scoreTopass:{2}, result:{3}", new Object[]
                    {
                        score, surprisesLeft, scoreTopass, possible
                    });

            numberOfPasses += possible;
        }

        return numberOfPasses;
    }

    private static int isItPossible(double score, AtomicInteger surprisesLeft, int scoreTopass)
    {
        double remainder, leftValues, lowestValue;

        if (scoreTopass == 0)
        {
            return 1;
        }

        remainder = score - scoreTopass;
        if (remainder < 0)
        {
            return 0;
        }
        
        leftValues = remainder / 2d;
        if (remainder % 2 == 0)
        {
            lowestValue = leftValues;
        }
        else
        {
            lowestValue = Math.floor(leftValues);
        }
        if (scoreTopass - lowestValue <= 1)
        {
            return 1;
        }
        else if (scoreTopass - lowestValue <= 2 && surprisesLeft.get() > 0)
        {
            surprisesLeft.decrementAndGet();
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
