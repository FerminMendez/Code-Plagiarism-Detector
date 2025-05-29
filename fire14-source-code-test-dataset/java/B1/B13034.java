package qualification.q1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 17:10
 * To change this template use File | Settings | File Templates.
 */
public class Q1Solver {
    
    private Map<Character,Character> mapping;
    
    public Q1Solver(){
        mapping = new HashMap<Character, Character>();
        mapping.put('y','a');
        mapping.put('n','b');
        mapping.put('f','c');
        mapping.put('i','d');
        mapping.put('c','e');
        mapping.put('w','f');
        mapping.put('l','g');
        mapping.put('b','h');
        mapping.put('k','i');
        mapping.put('u','j');
        mapping.put('o','k');
        mapping.put('m','l');
        mapping.put('x','m');
        mapping.put('s','n');
        mapping.put('e','o');
        mapping.put('v','p');
        mapping.put('z','q');
        mapping.put('p','r');
        mapping.put('d','s');
        mapping.put('r','t');
        mapping.put('j','u');
        mapping.put('g','v');
        mapping.put('t','w');
        mapping.put('h','x');
        mapping.put('a','y');
        mapping.put('q','z');
        mapping.put(' ',' ');
        
    }
    
    public String convertString(String encrypted){
        StringBuilder resString = new StringBuilder("");
        for (int i = 0 ; i < encrypted.length() ; i++){
            char decryptedChar = mapping.get(encrypted.charAt(i));
            resString.append(decryptedChar);
        }
        return resString.toString();
    }
}
