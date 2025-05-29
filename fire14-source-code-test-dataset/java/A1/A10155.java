import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CodeJam
{
    private static BufferedReader reader;
    private static BufferedWriter writer;
    
    public static void main(String args[]) throws Exception
    {
        prepareFiles("B-small-attempt2");
        
        int T = Integer.parseInt(reader.readLine());
     
        for(int i = 0; i < T; i++)
        {
            String[] line = reader.readLine().split(" ");
            
            int N = Integer.parseInt(line[0]); // # of googlers
            int S = Integer.parseInt(line[1]); // # of suprising triplets
            int p = Integer.parseInt(line[2]); // best result of at least p
            
            int maxTopScorers = 0;
            
            ArrayList<Case> surprisingCases = calulate(N, line, p, true);
            ArrayList<Case> normalCases = calulate(N, line, p, false);
            
            ArrayList<ArrayList<Case>> permutations = new ArrayList<ArrayList<Case>>();
            permutate(new ArrayList<Case>(), surprisingCases, permutations);
            
            for(int j = 0; j < permutations.size(); j++)
            {
                int topScorers = 0;
                HashSet<Case> topScorersCases = new HashSet<Case>();
                
                ArrayList<Case> suprisingPermutation = permutations.get(j);
                
                for(int k = 0; k < suprisingPermutation.size() && k < S; k++)
                {
                    topScorersCases.add(suprisingPermutation.get(k));
                    topScorers ++;
                }
                
                for(int k = 0; k < normalCases.size(); k++)
                {
                    if(!topScorersCases.contains(normalCases.get(k)))
                    {
                        topScorers ++;
                    }
                }
                
                if(topScorers > maxTopScorers)
                {
                    maxTopScorers = topScorers;
                }
            }
            
            print(getCase(i + 1));
            print(maxTopScorers);
            //print(" " + Arrays.toString(line));
            print("\n");
        }
        
        putAwayFiles();
    }
    
    private static void permutate(ArrayList<Case> head, List<Case> tail, ArrayList<ArrayList<Case>> permutations) throws Exception
    {
        if(tail.size() == 0)
        {
            permutations.add(head);
            return;
        }
        else
        {
            for(int i = 0; i < tail.size(); i++)
            {
                ArrayList<Case> newHead = new ArrayList<Case>();
                newHead.addAll(head);
                newHead.add(tail.get(i));
                
                permutate(newHead, joinLists(tail.subList(0, i), tail.subList(i + 1, tail.size())), permutations);
            }
        }
    }
    
    private static List<Case> joinLists(List<Case> list1, List<Case> list2)
    {
        ArrayList<Case> list = new ArrayList<>();
        
        list.addAll(list1);
        list.addAll(list2);
        
        return list;
    }
    
    private static ArrayList<Case> calulate(int N, String[] line, int p, boolean surprising)
    {
        ArrayList<Case> cases = new ArrayList<Case>();
        
        for(int j = 0; j < N; j++)
        {
            boolean actuallySurprising = false;
            int t = Integer.parseInt(line[3 + j]); // total points for this googler
            
            int basePoints = t/3;
            int extraPoints = t%3;
            int maxPoints = 0;
            
            if(surprising)
            {
                if(extraPoints == 0 && basePoints > 0)
                {
                    maxPoints = basePoints + 2;
                    actuallySurprising = true;
                }
                else if(extraPoints > 0)
                {
                    maxPoints = basePoints + extraPoints;
                    
                    if(extraPoints == 2)
                    {
                        actuallySurprising = true;
                    }
                }
                else
                {
                    maxPoints = basePoints;
                }
                
                if(actuallySurprising && maxPoints >= p)
                {
                    Case pointCase = new Case(j, maxPoints, true);
                    cases.add(pointCase);
                }
            }
            else
            {
                if(extraPoints > 0)
                {
                    maxPoints = basePoints + 1;
                }
                else
                {
                    maxPoints = basePoints;
                }
                
                if(maxPoints >= p)
                {
                    Case pointCase = new Case(j, maxPoints, false);
                    cases.add(pointCase);
                }
            }
        }
        
        
        Collections.sort(cases, new Comparator<Case>()
        {
            @Override
            public int compare(Case arg0,
                               Case arg1)
            {
                return arg1.maxPoints - arg0.maxPoints;
            }
        });
        
        return cases;
    }
    
    private static void prepareFiles(String fileName) throws IOException
    {
        reader = new BufferedReader(new FileReader(new File(fileName + ".in")));
        writer = new BufferedWriter(new FileWriter(new File(fileName + ".out")));
    }
    
    private static void putAwayFiles() throws IOException
    {
        reader.close();
        writer.flush();
        writer.close();
    }
    
    private static String getCase(int i)
    {
        return "Case #" + i + ": ";
    }
    
    private static void print(Object object) throws IOException
    {
        System.out.print(object.toString());
        writer.write(object.toString());
    }
    
    private static class Case
    {
        private int caseNumber;
        private int maxPoints;
        private boolean surprising;
        
        public Case(int caseNumber,
                    int maxPoints,
                    boolean surprising)
        {
            this.caseNumber = caseNumber;
            this.maxPoints = maxPoints;
            this.surprising = surprising;
        }
        
        @Override
        public boolean equals(Object o)
        {
            return ((Case)o).caseNumber == caseNumber;
        }
        
        @Override
        public int hashCode()
        {
            return caseNumber;
        }
        
        @Override
        public String toString()
        {
            return caseNumber + ":" + maxPoints;
        }
    }
}


