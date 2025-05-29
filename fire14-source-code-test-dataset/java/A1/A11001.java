/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author kutub
 */
public class dwg {
    
    public boolean valid(int score1,int score2,int score3,int total)
    {
        if(score1>=0 && score2>=0 && score3>=0 && score1+score2+score3==total)
        {
            return true;
        }
        else
            return false;
    }
    public boolean same(int s1,int s2,int s3)
    {
        if(s1==s2 && s2==s3)
        {
            return true;
        }
        else
            return false;
    }
    public boolean surprising(int score1,int score2,int score3)
    {
        if(Math.abs(score1-score2)==2 || Math.abs(score2-score3)==2 || Math.abs(score3-score1)==2)
        {
            return true;
        }
        else
            return false;
    }
    public int possibilities(int [] total,int b,int sur)
    {
        int best=0,sc=0,score1=0,score2=0,score3=0;
        for(int i=0;i<total.length;i++)
        {
        if(total[i]%3!=0)
        {
            score1=Math.round(total[i]/3);
            score2=Math.round(total[i]/3)+1;
            score3=Math.round(total[i]/3);
            if(valid(score1, score2, score3, total[i]))
            {
                
                    
                    if(score1>=b || score2>=b || score3>=b)
                    {
                        best++;
                    }
                    else
                    {
                        if(sc<sur)
                        {
                            score1++;
                            score3--;
                            if(valid(score1, score2, score3, total[i]))
                            {
                                if(score1>=b || score2>=b || score3>=b)
                                {
                                    best++;
                                }
                                else
                                {
                                    sc--;
                                }
                                if(surprising(score1, score2, score3))
                                {
                                    sc++;
                                }
                            }
                        }
                    }
                    
                }
               
            else
            {
                score1=Math.round(total[i]/3);
                score2=Math.round(total[i]/3)+1;
                score3=Math.round(total[i]/3)+1;
                if(valid(score1, score2, score3, total[i]))
                {
                    if(score1>=b || score2>=b || score3>=b)
                    {
                        best++;
                    }
                    else
                    {
                        if(sc<sur)
                        {
                            score2++;
                            score3--;
                            if(valid(score1, score2, score3, total[i]))
                            {
                                if(score1>=b || score2>=b || score3>=b)
                                {
                                    best++;
                                }
                                else
                                {   
                                    sc--;
                                }
                                if(surprising(score1, score2, score3))
                                {
                                    sc++;
                                }
                            }
                        }
                    }
                }
                
            }
        }
        else
        {
            score1=Math.round(total[i]/3);
            score2=Math.round(total[i]/3);
            score3=Math.round(total[i]/3);
            
            if(valid(score1, score2, score3, total[i]))
            {
                if(score1>=b || score2>=b || score3>=b)
                    {
                        best++;
                    }
                    else
                    {
                        if(sc<sur)
                        {
                            score2++;
                            score3--;
                            if(valid(score1, score2, score3, total[i]))
                            {
                                if(score1>=b || score2>=b || score3>=b)
                                {
                                    best++;
                                }
                                else
                                {
                                    sc--;
                                }
                                if(surprising(score1, score2, score3))
                                {
                                    sc++;
                                }
                            }
                        }
                    }
            }
        } 
    }
       
            return best;
       
    }
    
    
    public static void main(String args[]) throws FileNotFoundException
    {
        File f=new File("C:/Users/kutub/Documents/NetBeansProjects/JavaApplication1/src/javaapplication1/input1.txt");
        Scanner s=new Scanner(f);
        int n=0,noofg=0,sur=0,b=0,best=0,sc=0;
        int score[];
        while(s.hasNext())
        {
            n=s.nextInt();
            for(int j=1;j<=n;j++)
            {
                s.nextLine();
                noofg=s.nextInt();
                score=new int[noofg];
                sur=s.nextInt();
                b=s.nextInt();
                for(int i=0;i<noofg;i++)
                {
                    score[i]=s.nextInt();
                    
                }
                dwg d=new dwg();
                best=d.possibilities(score, b, sur);
                System.out.print("Case #"+j+": ");
                System.out.println(best);
            }
            
        }
        
    }
    
}
