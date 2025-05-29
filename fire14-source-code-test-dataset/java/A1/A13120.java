package org.weiwei.googlejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ding
 * Date: 12-4-14
 * Time: 上午11:37
 * To change this template use File | Settings | File Templates.
 */
public class Dancing {
    List<Integer> scores;
    int surp;
    int p;

    public Dancing(List<Integer> scores, int surp, int p){
        this.scores = scores;
        this.surp = surp;
        this.p = p;
    }

    public static Dancing loadFromString(String input){
        String[] elems = input.trim().split(" ");
        int surp = Integer.parseInt(elems[1].trim());
        int p = Integer.parseInt(elems[2].trim());
        int total = Integer.parseInt(elems[0].trim());
        List<Integer> scores = new ArrayList<Integer>();
        for (int i =0; i < total; i++){
            scores.add(Integer.parseInt(elems[3+i].trim()));
        }
        return new Dancing(scores, surp, p);
    }

    public int getNumber(){
        int number = 0;
        Collections.sort(scores, Collections.reverseOrder());
        for(int score : scores){
            if(score >= 3*p -2 ){
                number++;
            }
            else if(surp > 0){
                if(score >=3*p-4 && p >= 2) {
                    number++;
                    surp--;
                }
                else {
                    break;
                }
            } else
                break;
        }
        return number;
    }
}
