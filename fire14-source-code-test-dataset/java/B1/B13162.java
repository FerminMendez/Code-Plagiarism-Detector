package org.weiwei.recyclenumber;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ding
 * Date: 12-4-14
 * Time: 下午1:03
 * To change this template use File | Settings | File Templates.
 */
public class RecyleBin {
    int lower;
    int higher;
    Set<Integer> retSet = new HashSet<Integer>();
    int length;

    public RecyleBin(int lower, int higher) {
        this.lower = lower;
        this.higher = higher;
        this.length = String.valueOf(lower).length();
    }

    public int exhaust(int i){
        int ret = 0;
        retSet.clear();
        if(length ==1 )
            return 0;
        else{
            for(int j = 1; j < length+1; j++){
                int temp = i/(int)Math.pow(10,j)+i%(int)Math.pow(10,j)*(int)Math.pow(10,length - j);
                if(temp >= (10^length)  && temp < i && temp >= lower && !retSet.contains(temp)){
                    ret++;
                    retSet.add(temp);
                }
            }
        }
        return ret;
    }

    public int exhaust(){
        int ret = 0;
        for(int i = higher; i >= lower; i--){
            ret+=exhaust(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Date(System.currentTimeMillis()));
        RecyleBin bin = new RecyleBin(1111, 2222);
        System.out.println(bin.exhaust());
    }
}
