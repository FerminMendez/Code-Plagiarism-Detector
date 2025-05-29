package recycled;

import java.util.Scanner;

public class Recycled {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] count = new int[t];
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            for (int j = a; j <= b; j++) {
                String temp = Integer.toString(j);
                int index=0;
                 int[] num=new int[(int) Math.log10(j)];
                for (int k = 0; k < Math.log10(j); k++) {
                    if (Math.log10(j) >= 1) {
                       
                        
                        String temp2 = temp.substring(k + 1, temp.length()) + temp.substring(0, k + 1);
                        int temp3 = Integer.parseInt(temp2);
                        if (temp3 <= b & temp3>j) {
                            count[i]++;
                            num[index]=temp3;
                            index++;
                        }
                    }
                }
                if (index>1){
                for(int k=0;k<index;k++){
                    for(int l=k+1;l<index;l++ ){
                        if (num[k]==num[l]){
                            count[i]--;
                        }
                    }
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + count[i]);
        }
    }
}
