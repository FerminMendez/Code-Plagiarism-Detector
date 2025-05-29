/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Luis Sergio Curay
 */
public class b_2 {

    public b_2() {
        Scanner in= new Scanner(System.in);
        int t= in.nextInt();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> comb= new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i <= 30; i++) {
            ArrayList<ArrayList<Integer>> curr= new ArrayList<ArrayList<Integer>>();
            for (int j = 0; j <= 10; j++) 
                for (int k = 0; k <= 10; k++) 
                    for (int l = 0; l <= 10; l++) 
                        if((j+k+l) == i) {
                            ArrayList<Integer> tmp= new ArrayList<Integer>();
                            int arr[]= new int[]{j,k,l};
                            Arrays.sort(arr);
                            for (int m = 0; m < arr.length; m++) {
                                tmp.add(arr[m]);
                            }
                            curr.add(tmp);
                        }
            comb.put(i, curr);
        }
        for (int i = 0; i < t; i++) {
            int n= in.nextInt();
            int s= in.nextInt();
            int p= in.nextInt();
            int res= 0;
            for (int j = 0; j < n; j++) {
                int c= in.nextInt();
                int rank= 0;
                ArrayList<ArrayList<Integer>> curr= comb.get(c);
                for (ArrayList<Integer> combs : curr) {
                    if(combs.get(0).equals(combs.get(1)) && combs.get(0).equals(combs.get(2))) {
                        if(combs.get(0) >= p) {
                            rank=6;break;//res++;break;
                        }
                    } else if(combs.get(0).equals(combs.get(1))) {
                        if(combs.get(2) >= p && (combs.get(2) - combs.get(1)) == 1) {
                            if(rank < 5) rank= 5;//res++;break;
                        } else if(combs.get(2) >= p && (combs.get(2) - combs.get(1)) == 2 && s > 0) {
                            if(rank < 4) rank= 4;//res++;s--;break;
                        }
                    } else if(combs.get(1).equals(combs.get(2))) {
                        if(combs.get(1) >= p && (combs.get(1) - combs.get(0)) == 1) {
                            if(rank < 3) rank= 3;//res++;break;
                        } else if(combs.get(1) >= p && (combs.get(1) - combs.get(0)) == 2 && s > 0) {
                            if(rank < 2) rank= 2;//res++;s--;break;
                        }
                    } else {
                        if(combs.get(2) >= p)
                            if((combs.get(2) - combs.get(1)) == 1 && (combs.get(1) - combs.get(0)) == 1 && s > 0) {
                                if(rank < 1) rank= 1;//res++;s--;break;
                            }
                    }
                }
                if(rank == 6 || rank ==5 || rank == 3)
                    res++;
                else if( rank > 0){
                    res++;s--;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }
    
    public void print(ArrayList<Integer> t) {
        for (Integer integer : t) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}