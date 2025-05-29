/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codejam;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Ben
 */
public class Main {

    public static Scanner freader;
    public static int caseCount, _height, _width;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //solveFreeCell();
        //solveKiller();
        sovleDWG();
        //solveRC();
        //solveSIT();
    }

    public static void solveSIT()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/1a2011/A-small-attempt0.in"));
            caseCount = freader.nextInt();
            freader.nextLine();
            
            char GtoE [] =
            {'y',     //a
            'h',      //b
            'e',      //c
            's',      //d
            'o',      //e
            'c',      //f
            'v',      //g
            'x',      //h
            'd',      //i
            'u',      //j
            'i',      //k
            'g',      //l
            'l',      //m
            'b',      //n
            'k',      //o
            'r',      //p
            'z',      //q
            't',      //r
            'n',      //s
            'w',      //t
            'j',      //u
            'p',      //v
            'f',      //w
            'm',      //x
            'a',      //y
            'q'};     //z

            ArrayList<String> L = new ArrayList();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                L.add(freader.nextLine());
            }

            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                System.out.print("Case #" + (caseIdx + 1) + ": ");
                char chr [] =  L.get(caseIdx).toCharArray();
                
                for(int i = 0; i < chr.length; i++)
                {
                    if(chr[i] == ' ')
                        continue;
                    chr[i] = GtoE[chr[i] - 'a'];
                }
                System.out.println(chr);
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void solveRC()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/1a2011/C-small-attempt0.in"));
            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                System.out.print("Case #" + (caseIdx+1) + ": ");

                int A = freader.nextInt();
                int B = freader.nextInt();

                int result = RC(A,B);

                System.out.println(result);
                freader.nextLine();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int RC(int A, int B)
    {
        int count = 0;

        ArrayList<Integer> iL;
        ArrayList<Integer> jL;

        for(int i = A; i <= B-1; i++)
        {
            for(int j = i + 1; j <= B; j++)
            {
                iL = convertNumToArray(i);
                jL = convertNumToArray(j);

                if(iL.size() != jL.size())
                    continue;

                if(recycled(iL, jL))
                {
                   count++;
                }
            }
        }
        return count;
    }
    
    public static boolean recycled(ArrayList<Integer> iL, ArrayList<Integer> jL)
    {
        boolean equal;
        int size = iL.size();
        
        for(int i = 0; i < size; i++)
        {
            equal = true;

            //compare iL and jL
            for(int j = 0; j < size; j++)
            {
                if(iL.get(j).intValue() != jL.get(j).intValue())
                {
                    equal = false;
                    break;
                }
            }
            if(equal)
                return true;

            //shift iL
            Integer temp = iL.get(size-1);
            for(int j = size-1; j > 0; j--)
            {
                iL.set(j, iL.get(j-1));
            }
            iL.set(0, temp);
            
        }
        
        return false;
    }

    public static ArrayList<Integer> convertNumToArray(int x)
    {
        ArrayList<Integer> L = new ArrayList();

        while(x > 0)
        {
            int r = x % 10;
            L.add(0, new Integer(r));

            x = x / 10;
        }
        return L;
    }

    public static void sovleDWG()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/1a2011/B-small-attempt2.in"));
            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                System.out.print("Case #" + (caseIdx+1) + ": ");

                int n = freader.nextInt();
                int s = freader.nextInt();
                int p = freader.nextInt();

                int T [] = new int [n];

                for(int i = 0; i < n; i++){
                    T[i] = freader.nextInt();
                }

                int count = DWG(T, n, s, p);

                System.out.println(count);
                freader.nextLine();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int DWG(int [] T, int n, int s, int p)
    {
        int minSup = p + 2 * max(p-2,0);
        int minNonSup = p + 2 * max(p-1,0);
        int count = 0;
        int maybe = 0;

        for(int i = 0; i < n; i++)
        {
            int curr = T[i];

            if(curr >= minNonSup)
            {
                count++;
            }
            else if(curr < minNonSup && curr >= minSup)
            {
                maybe++;
            }
        }

        count = count + min(maybe, s);

        return count;
    }

    public static int min(int x, int y)
    {
        if (x < y){
            return x;
        }
        return y;
    }
    public static int max(int x, int y)
    {
        if (x > y){
            return x;
        }
        return y;
    }

    public static void solveKiller()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/1a2011/B-large-practice.in"));
            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                System.out.print("Case #" + (caseIdx+1) + ": ");

                int n = freader.nextInt();
                int m = freader.nextInt();

                ArrayList<String> L = new ArrayList(n);

                for(int i = 0; i < n; i++){
                    L.add(freader.next());
                }

                String kword = null;
                int score, worst;

                for(int j = 0; j < m; j++)
                {
                    String todo = freader.next();
                    worst = 1;

                    for(int i = 0; i < n; i++)
                    {
                        score = killer(L.get(i), todo, (ArrayList<String>)L.clone());
                        if(score < worst)
                        {
                            worst = score;
                            kword = L.get(i);
                        }
                    }
                    if(j == m-1)
                        System.out.print(kword);
                    else
                        System.out.print(kword + " ");

                    freader.nextLine();
                }
                System.out.println();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int killer(String word, String todo, ArrayList<String> dict)
    {
        int score = 0;
        int index [] = new int [26];

        updateTodo(todo, dict, index);

        char guess [] = new char [word.length()];
        for(int i = 0; i < word.length(); i++)
        {
            guess[i] = '*';
        }

        dict = updateDict(dict, guess);

        int j = 0;
        while(j < 26)
        {
            while(index[j] == 0)
            {
                ++j;
                if(j >= 26)
                    return score;
            }
            if(!updateGuess(guess, word, todo.charAt(j))){
                score--;
                dict = filter(dict, todo.charAt(j));
            }

            dict = updateDict(dict, guess);
            updateTodo(todo, dict, index);

            ++j;
        }
        return score;
    }

    public static ArrayList<String> filter(ArrayList<String> dict, char c)
    {
        ArrayList<String> result = new ArrayList();
        for(String str : dict)
        {
            if(str.indexOf(c) < 0)
            {
                result.add(str);
            }
        }
        return result;
    }
    public static ArrayList<String> updateDict(ArrayList<String> dict, char [] guess)
    {
        ArrayList<String> result = new ArrayList();
        for(String str : dict){
            if(matches(str,guess)){
                result.add(str);
            }
        }
        return result;
    }
    public static boolean matches(String str, char [] guess)
    {
        if(str.length() != guess.length)
            return false;
        
        for(int i = 0; i < guess.length; i++)
        {
            if(guess[i] == '*')
            {
                continue;
            }
            else if(guess[i] != str.charAt(i))
            {
                return false;
            }
        }
        return true;
    }
    public static void updateTodo(String todo, ArrayList<String> dict, int [] index)
    {
        for(int i = 0; i < index.length; i++)
            index[i] = 0;
        
        for(String str : dict)
        {
            for(int i = 0; i < str.length(); i++)
            {
                index[todo.indexOf(str.charAt(i))] = 1;
            }
        }
    }
    public static boolean updateGuess(char [] guess, String word, char c)
    {
        boolean found = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == c){
                guess[i] = c;
                found = true;
            }
        }
        return found;
    }
    public static void solveFreeCell()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/1a2011/A-large-practice.in"));
            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                System.out.print("Case #" + (caseIdx+1) + ": ");

                BigInteger n  = new BigInteger(freader.next());
                long pd = freader.nextInt();
                long pg = freader.nextInt();

                if(pd > 0 && pg == 0)
                {
                    System.out.println("Broken");
                    continue;
                }

                if(pd == 0 && pg == 100)
                {
                    System.out.println("Broken");
                    continue;
                }

                if(pd == 0 && pg != 100)
                {
                    System.out.println("Possible");
                    continue;
                }

                if(pd < 100 && pg == 100)
                {
                    System.out.println("Broken");
                    continue;
                }

                if(n.compareTo(new BigInteger("100")) >= 0){
                    System.out.println("Possible");
                    continue;
                }

                double den;
                long div;
                div = gcd(pd, 100);
                den = (double)100/div;

                

                if(den > n.intValue())
                {
                    System.out.println("Broken");
                    continue;
                }
                System.out.println("Possible");
                freader.nextLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static long gcd(long x, long y)
    {
        while(x != y)
        {
            //System.out.println(x + " " + y);
            if(x > y)
            {
                x = x - y;
            }
            else{
                y = y - x;
            }
        }
        return x;
    }

    public static void solveMagika()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/codejam/B-large-practice.in"));
            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                TreeMap<String, String> oppMap = new TreeMap();
                TreeMap<String, String> comMap = new TreeMap();
                ArrayList<String> list = new ArrayList();

                int c = freader.nextInt();

                for(int i = 0; i < c; i++)
                {
                    String str = freader.next();
                    String rev = new StringBuffer(str.substring(0,2)).reverse().toString();
                    comMap.put(str.substring(0, 2), str.substring(2));
                    comMap.put(rev.substring(0, 2), str.substring(2));
                }

                int d = freader.nextInt();

                for(int i = 0; i < d; i++)
                {
                    String str = freader.next();
                    String rev = new StringBuffer(str).reverse().toString();
                    oppMap.put(str, str);
                    oppMap.put(rev, rev);
                }

                int n = freader.nextInt();

                String todo = freader.next();

                //System.out.println(todo);

                Magika(caseIdx+1, n, todo, comMap, oppMap, list);

                freader.nextLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void Magika(int caseIdx, int n, String todo, TreeMap<String, String> comMap, TreeMap<String, String> oppMap, ArrayList<String> list)
    {
        list.add(todo.substring(0,1));

        for(int i = 1; i < n; i++)
        {
            list.add(todo.substring(i,i+1));

            int size = list.size();

            if(size >= 2){
                String newElement
                        = comMap.get( list.get(size-2).concat(list.get(size-1)) );
                if(newElement != null)
                {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(newElement);
                }
            }
            check(oppMap, list);
        }

        System.out.print("Case #" + caseIdx + ": [");
        if(list.isEmpty())
        {
            System.out.println("]");
        }
        else
        {
            for(int i = 0; i < list.size()-1; i++)
            {
                System.out.print(list.get(i) + ", ");
            }
            System.out.println(list.get(list.size()-1) + "]");
        }
    }

    public static void check(TreeMap<String, String> oppMap, ArrayList<String> list)
    {
        int size = list.size();
        for(int j = 0; j < size-1; j++)
        {
            for(int k = 0; k < size; k++)
            {
                if(oppMap.containsKey(list.get(j).concat(list.get(k))))
                {
                    list.clear();
                    return;
                }
            }
        }
    }

    public static void solveBotTrust()
    {
        try{
            freader = new Scanner(
                    new File("C:/Users/Ben/Documents/NetBeansProjects/CodeJam/src/codejam/A-large-practice.in"));

            caseCount = freader.nextInt();
            freader.nextLine();

            int caseIdx;
            for(caseIdx = 0; caseIdx < caseCount; caseIdx++)
            {
                int n = freader.nextInt();

                int buttons [] = new int [n];
                String robots []  = new String [n];

                int i;
                for(i = 0; i < n; i++)
                {
                    robots[i]  = freader.next();
                    buttons[i] = freader.nextInt();
                }

                BotTrust(caseIdx+1, robots, buttons, n);
                freader.nextLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void BotTrust(int caseIdx, String [] robots, int [] buttons, int n)
    {
        int turn, seconds;
        boolean buttonPressed;
        Robot B, O, active, passive;

        turn        = 0;
        seconds     = 0;

        B = new Robot("B");
        O = new Robot("O");

        for(int i = 0; i < n; i++)
            if(robots[i].equals("B")){
                B.nextPosition = buttons[i];
                break;
            }

        for(int i = 0; i < n; i++)
            if(robots[i].equals("O")){
                O.nextPosition = buttons[i];
                break;
            }

//        System.out.println("orange pos : " + O.nextPosition);
//        System.out.println("blue   pos : " + B.nextPosition);

        while(turn < n)
        {
            seconds++;
            buttonPressed = false;

            if(robots[turn].equals("O")){
                active = O;
                passive = B;
            }
            else{
                active = B;
                passive = O;
            }
            int moveIncr;

            if(active.currPosition == active.nextPosition){
                moveIncr = 0;
            }else if(active.currPosition < active.nextPosition){
                moveIncr = 1;
            }else{
                moveIncr = -1;
            }

            if(moveIncr == 0)
            {
                buttonPressed = true;
            }
            else{
                active.currPosition = active.currPosition + moveIncr;
            }

            if(passive.currPosition == passive.nextPosition){
                moveIncr = 0;
            }else if(passive.currPosition < passive.nextPosition){
                moveIncr = 1;
            }else{
                moveIncr = -1;
            }

            passive.currPosition = passive.currPosition + moveIncr;

            if(buttonPressed){
                turn++;
                for(int i = turn; i < n; i++){
                    if(robots[i].equals(active.name))
                    {
                        active.nextPosition = buttons[i];
                        break;
                    }
                }
            }
        }

        System.out.println("Case #" + caseIdx + ": " + seconds);
    }

    private static class Robot
    {
        int currPosition, nextPosition;
        String name;

        public Robot(String _name)
        {
            currPosition = 1;
            nextPosition = 0;
            name = _name;
        }
    }

}
