import java.util.*;


public class GCJ2012QualB{
  public  static void main(String args[]){
    
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    
    for(int mon=1;mon<=t; mon++){
      
      int nplayer=s.nextInt();
      int nsuprise=s.nextInt();
      int nscore=s.nextInt();
      int ans=0;
      int scores[];
      scores = new int [nplayer];
      for (int i=0; i<nplayer; i++){
        scores[i]=s.nextInt();
      } 
      // java.util.Arrays.sort(scores);
      int limsup=nscore-2;
      if(limsup<0){
        limsup=0;
      }
      int limsupall=nscore+limsup+limsup;
      int limnormal=nscore-1;
      if(limnormal<0){
        limnormal=0;
      }
      int limnormalall=nscore+limnormal+limnormal;
      for (int i=0; i<nplayer; i++){
        int checkscore=scores[i];
        if(checkscore>=limnormalall){
          ans+=1;
        }
        else if(checkscore>=limsupall){
          if (nsuprise>0){
            ans+=1;
            nsuprise-=1;
          }
        }
      }
      
      
      System.out.println("Case #"+ mon+": "+ans);
      
    }
    
  }
}
