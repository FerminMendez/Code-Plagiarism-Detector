package codezam.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
 
 
public class LCM {
        static HashMap<Long, Integer> factor;
        static BigInteger[][] dp;
        static long l;
        public static void main(String[] args) throws FileNotFoundException {
                Scanner r = new Scanner(System.in);
                int T = r.nextInt();
               
                while(T-- > 0){
                        int n = r.nextInt();
                        l = r.nextInt();
                       
                        factor = new HashMap<Long, Integer>();
                        int id = 0;
                        for(long d = 1; d * d <= l; d++)if(l % d == 0){
                                factor.put(d, id++);
                                if(d * d != l)factor.put(l / d, id++);
                        }
//                     
                        dp = new BigInteger[factor.size() + 1][n + 2];
                        for(int i  = 0; i < factor.size(); i++)
                                dp[i][0] = BigInteger.ZERO;
                        dp[factor.get(l)][0] = BigInteger.ONE;
                       
                       
                        BigInteger ways = go(1, n);
 
                        System.out.println(ways);
                }
        }
        static long gcd(long x, long y){
                if( y == 0 )return x;
                else return gcd(y, x % y);
        }
        private static BigInteger go(long lcm, int rem) {              
                if(rem == 0 && lcm == l)return BigInteger.ONE;
                if(rem == 0)return BigInteger.ZERO;
                System.out.println(lcm + ", " + rem);
               
                if(dp[factor.get(lcm)][rem] != null) return dp[factor.get(lcm)][rem];
                       
                BigInteger ways = BigInteger.ZERO;
                for(long d = 1; d * d <= l; d++)if(l % d == 0){
                        long lcmNEW1 = lcm * d / gcd(d, lcm);
                        long lcmNEW2 = lcm * (l/d) / gcd(l / d, lcm);
                       
                        ways = ways.add( go(lcmNEW1, rem - 1));
                        if(d * d != l)ways = ways.add( go(lcmNEW2, rem - 1));
                }
                return dp[factor.get(lcm)][rem] = ways;
        }
}