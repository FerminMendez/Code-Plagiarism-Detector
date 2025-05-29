/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package code_jam;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author leonardo
 */
public class RecyclingNumbers {
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputSize = Integer.parseInt(scanner.nextLine());
        
        for (long i = 1; i <= inputSize; i++) {
            String[] input = scanner.nextLine().split(" ") ;
            
            /* No solution exists. */
            if (input.length == 1)
                continue ;
            
            long a = Long.parseLong(input[0]) ;
            long b = Long.parseLong(input[1]) ;
            System.out.println("Case #" + i + ": " + countRecyclablePairs(a, b)) ;
        }        
    }
    
    private static long countRecyclablePairs(long a, long b) {
        if (a == b)
            return 0 ;        
                
        long count = 0 ;
        for(long n = a; n <= b; n++) {                   
                                   
            LinkedList<Long> digits = toLinkedList(n) ;
            Set<Long> counted = new HashSet<Long>() ;
            
            for(int i = 0; i < digits.size(); i++) {                                
                digits.addFirst(digits.removeLast()) ;
                long m = toNumber(digits) ;
                
                if (! counted.contains(m) && n < m && m <= b) {
                    counted.add(m) ;
                    count++ ;
                }
            }            
        }
        return count ;
    }    
    
    private static LinkedList<Long> toLinkedList(long number) {
        LinkedList<Long> digits = new LinkedList<Long>() ;                
        long remainer = 0 ;
        
        while(number >= 10) {
            remainer = number % 10 ;
            digits.addFirst(remainer);
            number = number / 10 ;
        }
        
        digits.addFirst(number) ;        
        return digits ;
    }    
    
    private static long toNumber(LinkedList<Long> digits) {
        long number = 0 ;
        int expoent = digits.size() - 1 ;
        
        for(long d : digits) {
            number += d * Math.pow(10, expoent) ;
            expoent-- ;
        }
        
        return number ;
    }
}

