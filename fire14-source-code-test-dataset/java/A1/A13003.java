package codejam;

public class Dancer extends CodeJam{

    public Dancer() {
        super("B-small-attempt0");
    }

    public static void main(String[] args) {
        new Dancer().run();
    }

    @Override
    protected String solve() {
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int p = scanner.nextInt();
        
        if (p == 0){
            scanner.nextLine();
            return n + "";
        }
        
        if (p == 1){
            s = 0;
        }
        
        int sum = 3*p - 2;
        int sum2 = 3*p - 4;
        int count = 0;
        for (int i = 0 ; i < n ; i++){
            int v = scanner.nextInt();
            if (v >= sum){
                count++;
            } else if (v >= sum2 && s-- > 0){
                count++;    
            }
        }
        return count + "";
    }
}
