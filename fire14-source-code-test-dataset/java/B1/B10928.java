/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.y12.round0;

import java.util.HashMap;
import utils.Jam;
import utils.JamCase;

/**
 *
 * @author fabien
 */
public class SpeakingInTongues extends Jam {

  private static final String g1 = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
  private static final String g2 = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
  private static final String g3 = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
  
  private static final String e1 = "our language is impossible to understand";
  private static final String e2 = "there are twenty six factorial possibilities";
  private static final String e3 = "so it is okay if you want to just give up";
  
//  private HashMap<Character, Character> mapToGoogleres;
  private HashMap<Character, Character> mapToEnglish;
  
  public SpeakingInTongues(String filename) {
    super(filename);
    mapToEnglish = new HashMap<Character, Character>();
//    mapToGoogleres = new HashMap<Character, Character>();
    mapToEnglish.put('z', 'q');
    mapToEnglish.put('q', 'z');
//    mapToGoogleres.put('z', 'q');
    addToMap(g1, e1);
    addToMap(g2, e2);
    addToMap(g3, e3);
  }
  
  private void addToMap(String goo, String eng) {
    char[] gooc = goo.toCharArray();
    char[] engc = eng.toCharArray();
    
    for (int i = 0; i < gooc.length; i++) {
      if (mapToEnglish.get(gooc[i]) == null) {
        mapToEnglish.put(gooc[i], engc[i]);
      }
    }
  }
  
  @Override
  public JamCase getJamCase(int number) {
    return new Line(this, number, lines[number]);
  }
  
  private class Line extends JamCase {
    
    private String line;
    
    public Line(Jam parent, int number, String line) {
      super(parent, number);
      this.line = line;
    }

    @Override
    public void parse() {
      
    }

    @Override
    public void solve() {
      StringBuilder sb = new StringBuilder(line.length());
      Character e = null;
      for (char c : line.toCharArray()) {
        e = mapToEnglish.get(c);
        if (e == null) {
          sb.append(c);
        } else {
          sb.append(e);
        }
      }
      result = sb.toString();
    }
    
  }
}
