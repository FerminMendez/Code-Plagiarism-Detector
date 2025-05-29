package MyAllgoritmicLib;

public class Sort {
	public static int partition(int[] m, int a, int b) {
		int i = a;
		for (int j = a; j <= b; j++) // ������������� � a �� b
		{
			if (m[j] >= m[b]) // ���� ������� a[j] �� �����������
			// a[b],
			{
				int t = m[i]; // ������ ������� a[j] � a[a], a[a+1], a[a+2] �
				// ��� �����...
				m[i] = m[j]; // �� ���� ��������� �������� ������� a[b] �
				// ������,
				m[j] = t; // � ����� � ��� a[b] �������
				i++; // ����� ������� ��������� �����: a[b] � a[i], ����� ����
				// i++
			}
		}
		return i - 1; // � ������� i �������� <����� ������� �������� a[b]> + 1
	}

	public static void quicksort(int[] m, int a, int b) // a - ������ ������������,
	// b -
	// �����
	{ // ��� ������� ������: a = 0, b = <��������� � �������> - 1
		if (a >= b)
			return;
		int c = partition(m, a, b);
		quicksort(m, a, c - 1);
		quicksort(m, c + 1, b);
	}
}
