import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Dancing {

    public static HashMap<Integer,ArrayList<ArrayList<Integer>>> unsurprising = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
    public static HashMap<Integer,ArrayList<ArrayList<Integer>>> surprising = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i = 0;i<=10;i++){
            for(int j = i;j<=i+2;j++){
                for(int k = j; k<=i+2;k++){
                    Integer sum = i+k+j;
                    if(k-i==2||j-i==2){
                        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
                        if(surprising.containsKey(sum)){
                            arrs = surprising.get(sum);
                        }
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(i);
                        arr.add(j);
                        arr.add(k);
                        arrs.add(arr);
                        surprising.put(sum, arrs);
                    } else {
                        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
                        if(unsurprising.containsKey(sum)){
                            arrs = unsurprising.get(sum);
                        }
                        ArrayList<Integer> arr = new ArrayList<Integer>();
                        arr.add(i);
                        arr.add(j);
                        arr.add(k);
                        arrs.add(arr);
                        unsurprising.put(sum, arrs);
                    }
                }
            }
        }

        for(int i = 1;i<=cases;i++){
            int numPeople = scanner.nextInt();
            int surprisingNums = scanner.nextInt();
            int lookFor = scanner.nextInt();
            int[] scores = new int[numPeople];
            for(int j = 0;j<numPeople;j++){
                scores[j] = scanner.nextInt();
            }
            System.out.println("Case #"+i+": "+solve(numPeople,surprisingNums,lookFor,scores));
        }
    }

    private static int solve(int numPeople, int surprisingNums, int lookFor,
            int[] scores) {
        int sum = 0;
        Binomial binomial = new Binomial(numPeople,surprisingNums);
        while(binomial.hasMore()){
            int[] combo = binomial.getNext();
            int currentSum = 0;
            int index=0;
            for(int i = 0;i<scores.length;i++){
                if(index<combo.length&&combo[index]==i){
                    ArrayList<ArrayList<Integer>> arrs = surprising.get(scores[i]);
                    if(arrs==null)break;
                    boolean found = false;
                    for(int j = 0;j<arrs.size();j++){
                        if(arrs.get(j).get(1)>=lookFor||arrs.get(j).get(2)>=lookFor||arrs.get(j).get(0)>=lookFor){
                            found = true;
                        }
                    }
                    if(found){
                        currentSum++;
                    }
                    index++;
                } else {
                    ArrayList<ArrayList<Integer>> arrs = unsurprising.get(scores[i]);
                    boolean found = false;
                    for(int j = 0;j<arrs.size();j++){
                        if(arrs.get(j).get(1)>=lookFor||arrs.get(j).get(2)>=lookFor||arrs.get(j).get(0)>=lookFor){
                            found = true;
                        }
                    }
                    if(found){
                        currentSum++;
                    }
                }
            }
            if(currentSum>sum)
                sum = currentSum;
        }
        return sum;
    }
}
