package google.codejam;


import java.util.HashMap;

public class GooglereseSolver implements GoogleSolver{
  
  static HashMap<String, String> map = new HashMap<String, String>();
  
  public static void calcualteMapping(){
    String in[] = new String[]{
        "ejp mysljylc kd kxveddknmc re jsicpdrysi", 
        "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd",
        "de kr kd eoya kw aej tysr re ujdr lkgc jv"};
    
    String out[] = new String[]{
        "our language is impossible to understand",
        "there are twenty six factorial possibilities",
        "so it is okay if you want to just give up"};
    
    int count = 0;
    map.put("y","a");
    map.put("e","o");
    map.put("q","z");
    map.put(" "," ");
    
    for(int i=0 ; i<in.length ; i++){
      for(int j=0 ; j<in[i].length() ; j++){
        String inC = in[i].charAt(j)+"";
        String outC = out[i].charAt(j)+"";
        if(inC.equalsIgnoreCase(" "))continue;
        
        if(map.containsKey(inC)){
          if(!map.get(inC).equalsIgnoreCase(outC+""))
            System.out.println("Different mapping?"+ inC +"->"+map.get(inC) + ", actual:"+outC);
        }else{
          System.out.println("Add mapping:"+ inC +"->"+outC);
          map.put(inC+"", outC+"");
          count++;
        }
      }
    }
    
    
    char missingKey = ' ';
    char missingValue = ' ';
    char check = 'a';
    for(int i=0 ; i<26 ; i++){
      char target = (char)(check+i);
      //System.out.println("check:"+target);
      if(!map.containsKey(target+"")){
        System.out.println("missing Key:"+target);
        missingKey = target;
      }
      
      if(!map.containsValue(target+"")){
        System.out.println("missing Value:"+target);
        missingValue = target;
      }
    }
    map.put(missingKey+"", missingValue+"");
    
    System.out.println("Total mapping:"+ count +"->" + map.size());
  }
    

  @Override
  public String solve(String str) {
    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<str.length() ; i++){
      sb.append(map.get(str.charAt(i)+""));
    }
    return sb.toString();
  }

}
