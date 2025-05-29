/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Student
 */
public class Score {

    private int i;
    private int j;
    private int k;
    private boolean surp;

    public Score(int i, int j, int k,boolean surp) {
        this.i = i;
        this.j = j;
        this.k = k;
        this.surp = surp;
    }
    
    public boolean isValid(){
        return (i<=10&&j<=10&&k<=10)&&(i>=0&&j>=0&&k>=0);
    }
   
    public boolean isSurprising(){
        return surp;
    }
    
    public boolean isbetter(int x){
        return i>=x||j>=x||k>=x;
    }
    
    public String toString(){
        return "("+i+","+j+","+k+")";
    }
}
