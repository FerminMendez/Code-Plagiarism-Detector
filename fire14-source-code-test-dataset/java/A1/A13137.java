/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises;

/**
 *
 * @author dannocz
 */
public class Parser {
    
    public static char parse(char character){
        
        switch(character)
        {
            case ' ':
                return ' ';
            case 'a':
                return 'y';
            case 'b':
                return 'h';
            case 'c':
                return 'e';
            case 'd':
                return 's';
            case 'e':
                return 'o';
            case 'f':
                return 'c';
            case 'g':
                return 'v';
            case 'h':
                return 'x';
            case 'i':
                return 'd';
            case 'j':
                return 'u';
            case 'k':
                return 'i';
            case 'l':
                return 'g';
            case 'm':
                return 'l';
            case 'n':
                return 'b';
            case 'o':
                return 'k';
            case 'p':
                return 'r';
            case 'q':
                return 'z';
            case 'r':
                return 't';
            case 's':
                return 'n';
            case 't':
                return 'w';
            case 'u':
                return 'j';
            case 'v':
                return 'p';
            case 'w':
                return 'f';
            case 'x':
                return 'm';
            case 'y':
                return 'a';
            case 'z':
                return 'q';
            default:
                return ' ';
        }
        
    }
    
    public static String parse(String cad){
        
       // System.out.println(cad);
        char[] chars = cad.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i]= parse(chars[i]);
        }
            
        return new String(newChars);
        
    }
    
}
