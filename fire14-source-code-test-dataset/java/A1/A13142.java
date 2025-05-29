/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author dannocz
 */
public class TestCase {
    
    private int noGooglers;
    private int p;
    private Googler[] googlers;

    public TestCase(String testCase) {
        String[] cads=testCase.split(" ");
        noGooglers = Integer.parseInt(cads[0]);
        int surprisedCases = Integer.parseInt(cads[1]);
        p = Integer.parseInt(cads[2]);
        googlers= new Googler[noGooglers];
        
        for (int i = 0; i < noGooglers; i++) {
            int score=Integer.parseInt(cads[i+3]);
            googlers[i]=new Googler(score, surprisedCases);
            buildTripplets(googlers[i]);
        }
        
    }

    
    public TestCase(int noGooglers, int surprisedCases, int p) {
        this.noGooglers = noGooglers;
        this.p = p;
        this.googlers= new Googler[noGooglers];
    }
    
   
    
    public int result(){
        int total=0;
        for (Googler googler : googlers) {
            if(googler.result(p))
                total++;
        }
        
        return total;
    }

    private void buildTripplets(Googler googler) {
        
        int score = googler.getScore();        
        for(int hp = p; hp<=10; hp++)
        {
            int x= score-hp;
            for(int y1=0;y1<=hp;y1++){
            //for(int y1=hp;y1>=hp-2;y1--){
                int y2 = x-y1;
                if(validTripplet(score,hp,y1,y2))
                    googler.addTriplet(new Triplet(hp,y1,y2));
            }
        }               
    }

    private boolean validTripplet(int score,int hp, int y1, int y2) {
        
        return (hp+y1+y2)==score &&
                validPair(hp,y1) && validPair(hp,y2) && validPair(y1,y2);
        
    }
    
    private boolean validPair(int y1, int y2){
          
        if(y1<0 || y2<0 || y1>10 || y2>10)
            return false;
        
        int r= y1-y2;
        return (r<=2 && r>=-2);
    }
}