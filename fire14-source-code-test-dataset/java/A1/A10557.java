package codeJam;
import java.util.ArrayList;
import utilities.FileReadWrite;

public class DancingWiththeGooglers {

	public static int noOfGooglers;
	public static int noOfSurprisingTriplets;
	public static int score;
	public static int[] howManyPlayesGotScore;
	
	public static void main(String[] args) 
	{
		FileReadWrite myFile = new FileReadWrite();
		String outputString ="";
		ArrayList<String> lines = myFile.readFile();
		int N = Integer.parseInt(lines.get(0));
		howManyPlayesGotScore=new int[N];
		String[] numbers;
		for (int i = 1; i < lines.size(); i++) 
		{
			numbers = lines.get(i).split(" ");
			noOfGooglers = Integer.parseInt(numbers[0]);
			noOfSurprisingTriplets = Integer.parseInt(numbers[1]);
			score = Integer.parseInt(numbers[2]);
			System.out.println(noOfGooglers+" "+noOfSurprisingTriplets+" "+score);
			
			int[] scores = new int[noOfGooglers];
			for (int j = 3; j < numbers.length; j++) 
				scores[j-3]=Integer.parseInt(numbers[j]);

			if(i==3)
				System.out.println();
			ArrayList<ArrayList<int[]>> arrayConstruc = new ArrayList<ArrayList<int[]>>();
			ArrayList<int[]> e = null;
			for (int j = 0; j < scores.length; j++) 
			{
//				System.out.println("score="+scores[j]);
				ArrayList<int[]> noOfPossibilities = DancingWiththeGooglers.getAllPosibilities(scores[j]);
//				System.out.println("#="+noOfPossibilities.size());
				e = new ArrayList<int[]>();
				for (int k = 0; k < noOfPossibilities.size(); k++) 
				{
					int[] uu = noOfPossibilities.get(k);
//					for (int jj = 0; jj < 5; jj++) 
//						System.out.print(uu[jj]+" ");
//					System.out.println();				
					e.add(uu);
				}
				arrayConstruc.add(e);
			}
			//
			System.out.println(arrayConstruc.size());
			for (int j = 0; j < arrayConstruc.size(); j++) 
			{
				ArrayList<int[]> ziki = arrayConstruc.get(j);
				System.out.println(ziki.size());
			}
			//
			
			DancingWiththeGooglers.z(arrayConstruc, i-1);
			System.out.println(howManyPlayesGotScore[i-1]);
			String tempLine = "Case #"+(i)+": ";
			int z = howManyPlayesGotScore[i-1];
			outputString = outputString + tempLine + String.valueOf(z) + "\n";
			System.out.println("========================");
		}
		System.out.println(outputString);
		myFile.writeFile(outputString);
	}
	
	public static ArrayList<int[]> getAllPosibilities (int x)
	{
		ArrayList<int[]> allP = new ArrayList<int[]>();
		int[] y;
		for (int i = 0; i < 11; i++) 
		{
			for (int j = i; j < 11; j++) 
			{
				if(j-i>2)
					continue;
				for (int k = j; k < 11; k++) 
				{
					if(k-j>2 || k-i>2)
						continue;
					if(i+j+k==x)
					{
						y = new int[5];
						y[0] = i;
						y[1] = j;
						y[2] = k;
						// maximum point
						if(i>=j && i>=k)
							y[3]=i;
						else if(j>=i && j>=k)
							y[3]=j;
						else if(k>=i && k>=j)
							y[3]=k;
						// 1 for surprising case. 0 for normal case
						if(j-i==2 || k-j==2 || k-i==2)
							y[4]=1;
						else
							y[4]=0;
						allP.add(y);
					}
				}	
			}	
		}
		return allP;
	}
	
	public static int getNoOfGooglers (ArrayList<int []> x, int maxScore, int noOfSurp)
	{
		int[] y;
		int sumOfSurp=0;
		int noOfGooglers=0;
		for (int i = 0; i < x.size(); i++) 
		{
			y = x.get(i);
			sumOfSurp = sumOfSurp + y[4]; 
			if(y[3] >= maxScore)
				noOfGooglers++;	
		}
		if(sumOfSurp<=noOfSurp)
			return noOfGooglers;
		else
			return -1;
	}

	public static void z (ArrayList<ArrayList<int[]>> x, int counter)
	{
		ArrayList<ArrayList<int[]>> A = recursiveFunction(x);
		int y;
		System.out.println("A.size()="+A.size());
		for (int i = 0; i < A.size(); i++) 
		{
			ArrayList<int[]> B = A.get(i);
//			System.out.println("B.size()="+B.size());
//			for (int j = 0; j < B.size(); j++) 
//			{
//				int[] C = B.get(j);
//				for (int k = 3; k < C.length; k++)
//				{
//					System.out.print(C[k]+" ");
//					
//				}
//				System.out.println();
//			}
//			System.out.println("~~~~~~~~~~~~");
			for (int j = 0; j < B.size(); j++) 
			{
				y = getNoOfGooglers(B, score, noOfSurprisingTriplets);
				if(y>howManyPlayesGotScore[counter])
					howManyPlayesGotScore[counter] = y;
//				System.out.println("no of googlers = "+y);
			}
		}
	}
	
	public static ArrayList<ArrayList<int[]>> recursiveFunction (ArrayList<ArrayList<int[]>> x)
	{
		ArrayList<ArrayList<int[]>> rows = new ArrayList<ArrayList<int[]>>();
		if(x.size()==1)
		{
			for (int i = 0; i < x.size(); i++) 
			{
				ArrayList<int[]> x1 = x.get(0);
				for (int i1 = 0; i1 < x1.size(); i1++) 
				{
					ArrayList<int[]> z = new ArrayList<int[]>();
					int[] y1 = x1.get(i1);
					z.add(y1);
					rows.add(z);
				}
			}
			return rows;
		}
		if(x.size()==2)
		{
			ArrayList<int[]> x1 = x.get(0);
			ArrayList<int[]> x2 = x.get(1);
			ArrayList<int[]> x3 = null;
			for (int i1 = 0; i1 < x1.size(); i1++) 
			{
				int[] y1 = x1.get(i1);
				for (int i2 = 0; i2 < x2.size(); i2++) 
				{
					int[] y2 = x2.get(i2);
					x3 = new ArrayList<int[]>();
					x3.add(y1);
					x3.add(y2);
					rows.add(x3);
				}
			}
			/*for (int i = 0; i < rows.size(); i++) 
			{
				ArrayList<int[]> xx = rows.get(i);
				for (int j = 0; j < xx.size(); j++) 
				{
					int[] xxx = xx.get(j);
					for (int k = 3; k < xxx.length; k++) 
						System.out.print(xxx[k]+" ");
					System.out.println("");
				}
				System.out.println("--");
			}*/
			
		}
		else
		{
			ArrayList<ArrayList<int[]>> remainedArray = new ArrayList<ArrayList<int[]>>();
			for (int i = 1; i < x.size(); i++) 
				remainedArray.add(x.get(i));
			
			ArrayList<ArrayList<int[]>> addRows = recursiveFunction(remainedArray);
			
//			for (int i = 0; i < addRows.size(); i++) 
//			{
//				ArrayList<int[]> xx = addRows.get(i);
//				System.out.println("xx.size()="+xx.size());
//				for (int j = 0; j < xx.size(); j++) 
//				{
//					int[] y = xx.get(j);
//					for (int k = 0; k < y.length; k++)
//					{
//						System.out.print(y[k]+" ");
//					}
//					System.out.println();
//				}
//			}
//			System.out.println("addRows.size()="+addRows.size());
			
			ArrayList<int[]> xx = x.get(0);
//			System.out.println("xx.size()="+xx.size());
			for (int i = 0; i < xx.size(); i++) 
			{
				int[] o = xx.get(i);
//				System.out.println("addRows.size()="+addRows.size());
				for (int ii = 0; ii < addRows.size(); ii++) 
				{
					ArrayList<int[]> h = new ArrayList<int[]>();
					h.add(o);
					ArrayList<int[]> hh = addRows.get(ii);
//					System.out.println("hh.size()="+hh.size());
					for (int j = 0; j < hh.size(); j++) 
					{
						int[] oo = hh.get(j);
						h.add(oo);	
					}
//					System.out.println("h.size()="+h.size());
					rows.add(h);
				}	
			}
//			System.out.println("rows.size()="+rows.size());
//			for (int i = 0; i < rows.size(); i++) 
//			{
//				ArrayList<int[]> xex = rows.get(i);
//				System.out.println("xex.size()="+xex.size());
//				System.out.println("i="+i+".");
//				for (int j = 0; j < xex.size(); j++) 
//				{
//					System.out.println("j="+j+".");
//					int[] xxx = xex.get(j);
//					
//					for (int k = 3; k < xxx.length; k++) 
//						System.out.print(xxx[k]+" ");
//					System.out.println("");
//				}
//				System.out.println("--");
//			}
		}
		return rows;
	}
}
