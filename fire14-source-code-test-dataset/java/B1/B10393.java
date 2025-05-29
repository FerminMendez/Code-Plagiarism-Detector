package hasnaer.puzzles.codejam;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hasnae rehioui
 */
public class RecycledNumbers {

    public static Map<Integer, List<Integer>> _map  = new HashMap<Integer, List<Integer>>();
    
    
    static{    
        for(int i = 0; i < 3000; i++){
           if(i <= 10){
               _map.put(i, new ArrayList<Integer>());
           } 
           else{
               String _str = Integer.toString(i);
               List<Integer> _list = new ArrayList<Integer>();
               for(int j = 1; j < _str.length(); j++){
                   _str = _str.substring(1).concat(_str.substring(0, 1));
                   int _val = Integer.parseInt(_str);
                   if(_val > i){
                       _list.add(_val);
                   }
               }
               _map.put(i, _list);
           }
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        
//        Scanner _input = new Scanner(System.in);
        Scanner _input = new Scanner(new FileInputStream("C-small-attempt0.in"));
//        BufferedWriter _writer = new BufferedWriter(new OutputStreamWriter(System.err));
        BufferedWriter _writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C-small-attempt0.out")));
                        
        int _t = _input.nextInt();
        for(int i = 0; i < _t; i++){
            int _a = _input.nextInt();
            int _b = _input.nextInt();
            
//            System.out.println(String.format("_a:%s;_b:%s", _a, _b));
            
            int _cnt = 0;
            for(int j = _a; j <= _b; j++){
                List<Integer> _list = _map.get(j);
                for(Integer _num : _list){
                    if(_num <= _b){
                        _cnt++;
//                        System.out.println(String.format("[%s,%s]", j, _num));
                    }
                }
            }
            
            _writer.write(String.format("Case #%s: %s\n", i + 1, _cnt));
        }
        
        _writer.close();
    }
    
}