import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
//			  FileInputStream fstream = new FileInputStream("C-small-practice.in");
			  FileInputStream fstream = new FileInputStream("B-small-attempt0 (1).in");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  FileWriter foutstream = new FileWriter("output.out");
			  BufferedWriter out = new BufferedWriter(foutstream);
			  System.out.println (br.readLine());
			  int Case = 0;
			  while ((strLine = br.readLine()) != null)   
			  {
				  Case+=1;
				  out.write("Case #" + Case + ": ");
				  System.out.println (strLine);
				  String str[] = strLine.split(" ");
				  int N = Integer.parseInt(str[0]);
				  int S = Integer.parseInt(str[1]);
				  int p = Integer.parseInt(str[2]);
				  int g[] = new int[str.length-3];
				  int y = 0;
				  for (int i = 3;i<str.length;i++)
				  {
				  g[i-3]=Integer.parseInt(str[i]);
				  //System.out.println(g[i-3]);
				  }
				  //Quicksort(g,0,g.length-1);
				  bubbleSort1(g);
				  for (int i=0;i<g.length;i++)
				  {
					  if (S==-1) S=0;
					  System.out.print(g[i] + ", p=" + p + ", S=" + S + " ,y=");
					  if (((g[i]-p)+2>=2*p))
						  y++;
					  else if (g[i]==0) ;
					  else if (((g[i]-p)+4>=2*p))
					  {
						  if (S>0)
						  {
						  y++;
						  S--;
						  }
						  
					  }
					  System.out.println(y);
					  //if (((g[i]-p)+4>=2*p));

				  }
				  out.write(Integer.toString(y));
				  out.newLine();
				  
				  
			  }
			  out.close();
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage() + " " + e.getCause());
			  }
		System.exit(-1);
	}
	
	 public static void swap (int A[], int x, int y)
	   {
	      int temp = A[x];
	      A[x] = A[y];
	      A[y] = temp;
	   }

	   // Reorganizes the given list so all elements less than the first are 
	   // before it and all greater elements are after it.                   
	   public static int partition(int A[], int f, int l)
	   {
	      int pivot = A[f];
	      while (f < l)
	      {
	        // if (A[f] == pivot || A[l] == pivot) 
	         {
	           // System.out.println("Only distinct integers allowed - C321");
	           // System.out.println("students should ignore this if statement");
	            
	         }
	         while (A[f] < pivot) f++;
	         while (A[l] > pivot) l--;
	         swap (A, f, l);
	      }
	      if (A[f]==A[l])
	    	  return f--;
	      return f;
	   }

	   public static void Quicksort(int A[], int f, int l)
	   {
	      if (f >= l) return;
	      int pivot_index = partition(A, f, l);
	      Quicksort(A, f, pivot_index);
	      Quicksort(A, pivot_index+1, l);
	   }
	   public static void bubbleSort1(int[] x) {
		    int n = x.length;
		    for (int pass=1; pass < n; pass++) {  // count how many times
		        // This next loop becomes shorter and shorter
		        for (int i=0; i < n-pass; i++) {
		            if (x[i] < x[i+1]) {
		                // exchange elements
		                int temp = x[i];  x[i] = x[i+1];  x[i+1] = temp;
		            }
		        }
		    }
		}
		}


