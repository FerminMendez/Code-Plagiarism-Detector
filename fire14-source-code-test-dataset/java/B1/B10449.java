package MyAllgoritmicLib;

public class Sort {
	public static int partition(int[] m, int a, int b) {
		int i = a;
		for (int j = a; j <= b; j++) // просматриваем с a по b
		{
			if (m[j] >= m[b]) // если элемент a[j] не превосходит
			// a[b],
			{
				int t = m[i]; // меняем местами a[j] и a[a], a[a+1], a[a+2] и
				// так далее...
				m[i] = m[j]; // то есть переносим элементы меньшие a[b] в
				// начало,
				m[j] = t; // а затем и сам a[b] «сверху»
				i++; // таким образом последний обмен: a[b] и a[i], после чего
				// i++
			}
		}
		return i - 1; // в индексе i хранится <новая позиция элемента a[b]> + 1
	}

	public static void quicksort(int[] m, int a, int b) // a - начало подмножества,
	// b -
	// конец
	{ // для первого вызова: a = 0, b = <элементов в массиве> - 1
		if (a >= b)
			return;
		int c = partition(m, a, b);
		quicksort(m, a, c - 1);
		quicksort(m, c + 1, b);
	}
}
