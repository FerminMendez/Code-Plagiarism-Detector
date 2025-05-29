/*
 * Created on Apr 14, 2012
 *
 */
package com.codejam.y2k12.qualification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author manveer
 * 
 */
public class DancingGooglers
{
    public static boolean isSurprising(int[] scores)
    {
        int a = scores[0], b = scores[1], c = scores[2];
        if (Math.abs(a - b) == 2)
            return true;
        if (Math.abs(c - b) == 2)
            return true;
        if (Math.abs(a - c) == 2)
            return true;
        return false;
    }

    public static int[][] getPossibleScores(int total)
    {
        // 3 --> (1,1,1), (0,1,2)
        // 4 --> (1,1,2), (0,2,2)
        // 5 --> (1,2,2), (1,1,3)
        int[][] result = new int[2][3];
        int first[] = new int[3];
        int second[] = new int[3];
        result[0] = first;
        result[1] = second;
        if(total <= 1)
        {
            first[0] = 0; first[1] = 0; first[2] = total;
            second[0] = 0; second[1] = 0; second[2] = total;
            return result;
        }
        int base = total / 3;
        if (total % 3 == 0)
        {
            first[0] = base;
            first[1] = base;
            first[2] = base;

            second[0] = base - 1;
            second[1] = base;
            second[2] = base + 1;

        }
        else if (total % 3 == 1)
        {
            first[0] = base;
            first[1] = base;
            first[2] = base + 1;

            second[0] = base - 1;
            second[1] = base + 1;
            second[2] = base + 1;
        }
        else
        {
            first[0] = base;
            first[1] = base + 1;
            first[2] = base + 1;

            second[0] = base;
            second[1] = base;
            second[2] = base + 2;
        }
        //System.out.println("Score : " + total + " " + Arrays.toString(result[0]) + " " + Arrays.toString(result[1]));
        return result;
    }

    public static boolean isAcceptableResult(int[] result, int p)
    {
        for (int i = 0; i < result.length; i++)
        {
            if (result[i] >= p)
                return true;
        }
        return false;
    }

    public static int findMaxGooglers(int[] scores, int s, int p, int current)
    {
        if(current >= scores.length)
            return 0;
        //System.out.println("Current: " + current);
        int currScore = scores[current];
        int[][] results = getPossibleScores(currScore);
        boolean isFirstAcceptable = isAcceptableResult(results[0], p);
        boolean isFirstSurprising = isSurprising(results[0]);
        boolean isSecondAcceptable = isAcceptableResult(results[1], p);
        boolean isSecondSurprising = isSurprising(results[1]);
        boolean canTakeFirst = true;
        boolean canTakeSecond = true;
        if (s <= 0 && isFirstSurprising)
        {
            canTakeFirst = false;
        }
        if (s <= 0 && isSecondSurprising)
        {
            canTakeSecond = false;
        }
        int firstPath = 0, secondPath = 0;
        if (canTakeFirst)
        {
            firstPath = (isFirstAcceptable ? 1 : 0);
            //if(firstPath == 1)
              //  System.out.println(Arrays.toString(results[0])) ;
            int sFirst = (isFirstSurprising ? s - 1 : s);
            firstPath += (findMaxGooglers(scores, sFirst, p, current + 1));
        }
        if (canTakeSecond)
        {
            secondPath = (isSecondAcceptable ? 1 : 0);
            //if(secondPath == 1)
             //   System.out.println(Arrays.toString(results[1]));
            int sSecond = (isSecondSurprising ? s - 1 : s);
            secondPath += (findMaxGooglers(scores, sSecond, p, current + 1));
        }
        return Math.max(firstPath, secondPath);
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(args[0]));
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= T; i++)
        {
            int N = scan.nextInt();
            int S = scan.nextInt();
            int p = scan.nextInt();
            int scores[] = new int[N];
            for (int j = 0; j < N; j++)
            {
                scores[j] = scan.nextInt();
            }
            //System.out.println(Arrays.toString(scores) + " " + p);
            scan.nextLine();
            int result = findMaxGooglers(scores, S, p, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}
