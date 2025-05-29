import java.util.*;
public class RecycledNums
{
    static Scanner cin = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String out = "";
        System.out.println("GO");
        int repeat = cin.nextInt();
        cin.nextLine();
        int ans=0;
        for(int i = 0; i < repeat; i++) {
            int in1 = cin.nextInt();
            int in2 = cin.nextInt();
            ans = findAns(in1, in2);
            out+="Case #" + (i+1) + ": " +ans+"\n";
        }
        System.out.println(out);
    }
    
    public static int findAns(int in1, int in2)
    {
        ArrayList<Integer> found = new ArrayList<Integer>();
        int ans = 0;
        for(int i = in1; i < in2; i++) {
            for(int j = i+1; j<=in2; j++) {
                int[] recycledNums = numsFor(i);
                for(int k = 0; k < recycledNums.length; k++) {
                    if((recycledNums[k]+"").length() == (j+"").length())
                        if(recycledNums[k] == j) {
                            /*boolean foundN = false;
                            for(int a = 0 ; a < found.size(); a++) {
                                if(j == found.get(a).intValue()) {
                                    foundN = true;
                                }
                            }
                            if(!foundN) {
                                ans++;
                                found.add(new Integer(j));
                            }*/
                            ans++;
                        }
                }
            }
        }
        return ans;
    }
    
    public static int[] numsFor(int in)
    {
        String num = in+"";
        int[] ans = new int[num.length()-1];
        for(int i = 1; i < num.length(); i++) {
            ans[i-1] = Integer.parseInt(num.substring(num.length()-i,num.length()) + num.substring(0,num.length()-i));
            for(int j = 0; j < i-1; j++) {
                if(ans[i-1] == ans[j])
                    ans[i-1] = 0;
            }
        }
        return ans;
    }
}
