/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumber;

/**
 *
 * @author pos
 */
public class Numbers {

    int A;
    int B;
    int n;
    int m;
    int Result;

    public Numbers(int A, int B) {
        this.A = A;
        this.B = B;
        this.n = A;
        this.m = n + 1;
    }
    
    String sn;
    String sm;
    int nLength;
    int mLength;
    int nIndex;
    int mIndex;

    private boolean isValid(int n, int m) {
        int[] numberN = new int[10];
        int[] numberM = new int[10];

        sn = n + "";
        sm = m + "";
        nLength = sn.length();
        mLength = sm.length();

        for (int i = 0; i < nLength; i++) {
            nIndex = Integer.valueOf(sn.charAt(i)) - 48;
            numberN[nIndex]++;
            mIndex = Integer.valueOf(sm.charAt(i)) - 48;
            numberM[mIndex]++;
        }
        for (int i = 0; i < 10; i++) {
            if (numberN[i] != numberM[i]) {
                return false;
            }
        }
        //System.out.println(A + "<=" + n + "<" + m + "<=" + B);
        return true;
    }

    public void Calculate() {
        int n, m;
        for (int i = this.A; i < this.B; i++) {
            for (int j = i+1; j <= this.B; j++) {
                n = i;
                m = j;
                if (isValid(n, m))
                    isRecycled(n, m);
            }
        }
    }
    
    private boolean isRecycled(int n, int m){
        String sn=n+"";
        nLength=sn.length();
        for(int i=1;i<nLength;i++){
            if (Integer.valueOf(sn.substring(i)+sn.substring(0, i))==m){
                Result++;
                return true;
            }
        }
        return false;
    }
}
