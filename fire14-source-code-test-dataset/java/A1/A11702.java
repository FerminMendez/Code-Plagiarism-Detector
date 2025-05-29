/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.util.LinkedList;

/**
 *
 * @author Student
 */
public class Best {

    public static LinkedList<Score> scores(int som) {
        LinkedList<Score> res = new LinkedList<Score>();
        int x = som / 3;
        switch (som % 3) {
            case 0: {
                res.add(new Score(x, x, x,!true));
                res.add(new Score(x - 1, x + 1, x,!false));
                break;
            }
            case 1: {
                res.add(new Score(x, x, x + 1,!true));
                res.add(new Score(x - 1, x + 1, x + 1,!false));
                break;
            }
            case 2: {
                res.add(new Score(x, x, x+2,!false));
                res.add(new Score(x, x + 1, x+1,!true));
                break;
            }
        }
        if(!res.getFirst().isValid()) res.removeFirst();
        if(!res.getLast().isValid()) res.removeLast();
        return res;
    }
    
    public static int opt(int n,int s,int p,LinkedList<Integer> l){
        LinkedList<Score> lg=new LinkedList<>();
        int restofs=s;
        for(Integer i:l){
            LinkedList<Score> xxx=scores(i);
            switch(xxx.size()){
                case 1: {
                     if(xxx.getFirst().isbetter(p)) lg.add(xxx.getFirst());
                    break;
                }
                    
                case 2: {
                    if(xxx.getFirst().isSurprising()){
                        if(xxx.getFirst().isbetter(p)&& restofs!=0&&!xxx.getLast().isbetter(p)){
                        lg.add(xxx.getFirst());
                        restofs--;
                        break;
                        }
                    }
                    if(xxx.getLast().isSurprising()){
                        if(xxx.getLast().isbetter(p)&& restofs!=0&&!xxx.getFirst().isbetter(p)){
                        lg.add(xxx.getLast());
                        restofs--;
                        break;
                        }
                    }
                   if(xxx.getLast().isbetter(p)&&!xxx.getLast().isSurprising()){
                        lg.add(xxx.getLast());
                        break;
                   }
                   if(xxx.getFirst().isbetter(p)&&!xxx.getFirst().isSurprising()){
                        lg.add(xxx.getFirst());
                        break;
                   }
                    }
                }

            }
       
        return lg.size();
        
    }
}