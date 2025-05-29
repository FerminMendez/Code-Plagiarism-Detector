import java.util.* ; 


public class Utils {
	
	private static void quickAscSort(ArrayList list, int low0, int high0) {

		int low = low0, high = high0;

		if (low >= high) {

			return;

		} else if (low == high - 1) {

			if (((Comparable)list.get(low)).compareTo(list.get(high)) > 0) {

				Object temp = list.get(low);

				list.set(low, list.get(high));

				list.set(high, temp);

			}

			return;

		}

		

		Object pivot = list.get((low + high) / 2);

		list.set((low + high) / 2, list.get(high));

		list.set(high, pivot);

		

		while (low < high) {

			while (((Comparable)list.get(low)).compareTo(pivot) <= 0 && low < high) {

				low++;

			}

			while (((Comparable)list.get(high)).compareTo(pivot) >= 0 && low < high) {

				high--;

			}

			if (low < high) {

				Object temp = list.get(low);

				list.set(low, list.get(high));

				list.set(high, temp);

			}

		}

		list.set(high0, list.get(high));

		list.set(high, pivot);

		quickAscSort(list, low0, low - 1);

		quickAscSort(list, high + 1, high0);

	}

	
	private static void quickDescSort(ArrayList list, int low0, int high0) {

		int low = low0, high = high0;

		if (low >= high) {

			return;

		} else if (low == high - 1) {

			if (((Comparable)list.get(low)).compareTo(list.get(high)) > 0) {

				Object temp = list.get(low);

				list.set(low, list.get(high));

				list.set(high, temp);

			}

			return;

		}

		

		Object pivot = list.get((low + high) / 2);

		list.set((low + high) / 2, list.get(high));

		list.set(high, pivot);

		

		while (low < high) {

			while (((Comparable)list.get(low)).compareTo(pivot) >= 0 && low < high) {

				low++;

			}

			while (((Comparable)list.get(high)).compareTo(pivot) <= 0 && low < high) {

				high--;

			}

			if (low < high) {

				Object temp = list.get(low);

				list.set(low, list.get(high));

				list.set(high, temp);

			}

		}

		list.set(high0, list.get(high));

		list.set(high, pivot);

		quickDescSort(list, low0, low - 1);

		quickDescSort(list, high + 1, high0);

	}
	

	public static void sortAscList(ArrayList list) {

		Collections.sort(list) ;
	

	}
	
	public static void sortDescList(ArrayList list) {

		Collections.sort(list,Collections.reverseOrder()) ;

	}
	
	public static ArrayList<String> toStrArrayList(String str)
	{
      StringTokenizer stTokenizer = new StringTokenizer(str) ;
		
		ArrayList<String> readStrList = new ArrayList<String>(stTokenizer.countTokens()) ; 
		
		while(stTokenizer.hasMoreTokens())
		{
			readStrList.add(stTokenizer.nextToken()) ;
		}
		
		return readStrList ; 
	}

	
	public static ArrayList<Integer> toIntArrayList(String str)
	{
      StringTokenizer stTokenizer = new StringTokenizer(str) ;
		
		ArrayList<Integer> readIntList = new ArrayList<Integer>(stTokenizer.countTokens()) ; 
		
		while(stTokenizer.hasMoreTokens())
		{
			readIntList.add(Integer.parseInt(stTokenizer.nextToken())) ;
		}
		
		return readIntList ; 
	}
	
	public static void printArrayList(ArrayList list,String seperator)
	{
         ListIterator iterator = list.listIterator() ;
		
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()) ;
			if(iterator.hasNext()) System.out.print(seperator) ;
			
		}
		
		System.out.print("\n"); 
		
	}
	
	
	public static void reverseArrayList(ArrayList list)
	{
     Collections.reverse(list) ; 
		
	}
	
	
}
 
 

	

