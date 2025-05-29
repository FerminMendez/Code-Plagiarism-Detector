import java.util.*;
import java.io.*;

public class B {	
	
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("B-small-attempt4.in"));
		FileWriter fw = new FileWriter("B-small.out");	
		int T = in.nextInt();
		
		for (int cases = 1; cases <= T; cases++){
			
			// read parameters for this case
			int N = in.nextInt();
			int S = in.nextInt();
			int P = in.nextInt();
			
			// read the data to an array point
			int[] point = new int[N];
			fw.write("Case #" + cases + ": ");
			for (int i = 0; i < N; i++){
				point[i] = in.nextInt();							
			}
			
			// quicksort the array point		
			QuickSort result = new QuickSort(point);
			result.sort();
			
			/* this is used to test
			for (int i = 0; i < N; i++){
				fw.write(" " + point[i]);							
			}
			*/			
			
			// this part is to get the number for this case
			
			int number = N - 1;			
			for (int i = N - 1; i >= 0 && point[i] >= 3 * P - 2; i--){
				number = i - 1;				
			}
			// fw.write("\nP is " + P +" Number is " + number + "      ");
			
			int total = N - 1 - number;
			
			// this part is to inclusice the S
			for (int j = 0; j < S && j <= number && point[number - j] >= 3 * P - 4  && point[number - j] >= 2; j++) {
				total = N - 1 - number + j +1;
			}
			fw.write(total + "\n");
			
		}
		fw.flush();
		fw.close();		
	}
}

// this is the quicksork
class QuickSort {
	private int[] a;
	
	public QuickSort(int[] anArray){
       a = anArray;
    }
   
    public void sort(){
       sort(0, a.length - 1);
    }
 
    public void sort(int low, int high){
		if (low >= high) return;
		int p = partition(low, high);
		sort(low, p);
		sort(p + 1, high);
    }
 
    private int partition(int low, int high){
       // First element
       int pivot = a[low]; 
       int i = low - 1;
       int j = high + 1;
		while (i < j) {
			i++; while (a[i] < pivot) i++;
			j--; while (a[j] > pivot) j--;
			if (i < j) swap(i, j);
		}
		return j;
	}
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
    */
    private void swap(int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
	