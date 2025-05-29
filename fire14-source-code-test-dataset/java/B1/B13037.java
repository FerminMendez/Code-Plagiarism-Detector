public class Recycle extends CodeJam{

    public Recycle() {
        super("C-small-attempt0");
    }

    public static void main(String[] args) {
        //long t = System.currentTimeMillis();
        new Recycle().run();
        //System.out.println(System.currentTimeMillis() - t);
    }
    
    private int[][] nm = new int[2000001][10];
    
    public void init() {
        //long t = System.currentTimeMillis();
        int k10 = 10;
        for (int n = 1 ; n < 2000001; n++){
            int[] mar = new int[10];
            if (n == k10){
                k10 *= 10;
            }
            int d = 10;
            int a = n / d;
            for (int i = 0 ; a > 0 ; i++, d *= 10, a /= 10){
                int b = n % d;
                int m = (k10/d) * b + a;
                if (m > n){
                    boolean add = true;
                    for (int exists : mar){
                        if (exists == m){
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        mar[i] = m;
                    }
                }
                
            }
            nm[n] = mar;
        }
        //System.out.println(System.currentTimeMillis() - t);
    }

    @Override
    protected String solve() {
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int count = 0;
        for (int n = A ; n < B; n++) {
            for (int m : nm[n]) {
                if (m > 0 && m <= B){
                    count++;
                }
            }    
        }
        return count + "";
    }
}
