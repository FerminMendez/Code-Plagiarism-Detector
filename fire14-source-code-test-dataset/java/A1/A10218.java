package qualification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class A {

	static DecimalFormat DF = new DecimalFormat("0.000000",	new DecimalFormatSymbols(Locale.ENGLISH));

	private static final int MAX = 1000000;
	private static final int MIN = 1 - 1;
	private static final int MOD = 1000000009;
	
	public A(int cc) throws IOException {
		final int N = INT();
		int S = INT();
		final int p = INT();
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			int t = INT();
			int b = t / 3;
			int f = p - b;
			if( f <= 0 ) {
				max++;
				continue;
			}
			
			int k = t % 3;
			
			switch (k) {
			case 0:
				if (f == 1 && S > 0 && b > 0) {
					S--;
					max++;
				}
				break;
			case 1:
				if (f == 1) {
					max++;
				}
				break;
			case 2:
				if (f == 1) {
					max++;
				} else
				if (f == 2 && S > 0) {
					S--;
					max++;
				}
				break;

			default:
				break;
			}
		}
		
		println("Case #" + cc + ": "+max);
		//System.out.format("Case #%d: %.09f\n", cc, total);
	}

	public static void run() throws Exception {
		String qprefix = "B";
		//init(qprefix+"-large");
		init(qprefix + "-small-attempt0");
		//init("test");

		int cases = INT();
		for (int cc = 1; cc <= cases; cc++) {
			new A(cc);
		}
	}

	static class Ct extends Thread {
		public void run() {
		}
	}

	static int[][] mapClone(int[][] map) {
		int[][] cmap = map.clone();
		for (int i = 0; i < cmap.length; i++) {
			cmap[i] = map[i].clone();
		}
		return cmap;
	}

	// *************************************************************************************
	// *********************************** FRAMEWORK
	// *************************************************************************************

	public static BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));
	public static boolean isStandardInput = false;

	public static File input;
	public static FileReader inputreader;
	public static BufferedReader in;

	public static File output;
	public static FileWriter outputwriter;
	public static BufferedWriter out;

	public static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		doSTDIN(true);
		setOutput("test.out");
		run();
		close();
	}

	public static void init(String problemName) throws Exception {
		doSTDIN(false);
		setInput(problemName + ".in");
		setOutput(problemName + ".out");
	}

	// **************** PRINT METHODS **********************

	public static void println() throws IOException {
		out.write("\n");
		System.out.println();
	}

	public static void println(Object obj) throws IOException {
		out.write(obj.toString());
		out.write("\n");
		System.out.println(obj.toString());
	}

	public static void print(Object obj) throws IOException {
		out.write(obj.toString());
		System.out.print(obj.toString());
	}

	public static void println(long number) throws IOException {
		out.write(Long.toString(number));
		out.write("\n");
		System.out.println(number);
	}

	public static void print(long number) throws IOException {
		out.write(Long.toString(number));
		System.out.print(number);
	}

	public static void println(char c) throws IOException {
		out.write(Character.toString(c));
		out.write("\n");
		System.out.println(c);
	}

	public static void print(char c) throws IOException {
		out.write(Character.toString(c));
		System.out.print(c);
	}

	public static void println(String line) throws IOException {
		out.write(line);
		out.write("\n");
		System.out.println(line);
	}

	public static void print(String line) throws IOException {
		out.write(line);
		System.out.print(line);
	}

	// ******************** INPUT DECLARATION ******************

	public static void doSTDIN(boolean standard) {
		isStandardInput = standard;
	}

	public static void setInput(String filename) throws IOException {
		input = new File(filename);
		inputreader = new FileReader(input);
		in = new BufferedReader(inputreader);
	}

	public static void setOutput(String filename) throws IOException {
		output = new File(filename);
		outputwriter = new FileWriter(output);
		out = new BufferedWriter(outputwriter);
	}

	public static void close() throws IOException {
		if (in != null)
			in.close();
		if (inputreader != null)
			inputreader.close();

		if (out != null)
			out.flush();
		if (out != null)
			out.close();
		if (outputwriter != null)
			outputwriter.close();
	}

	// ************************** INPUT READING *****************

	static String LINE() throws IOException {
		return isStandardInput ? stdin.readLine() : in.readLine();
	}

	static String TOKEN() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(LINE());
		return st.nextToken();
	}

	static int INT() throws IOException {
		return Integer.parseInt(TOKEN());
	}

	static long LONG() throws IOException {
		return Long.parseLong(TOKEN());
	}

	static double DOUBLE() throws IOException {
		return Double.parseDouble(TOKEN());
	}

	static BigInteger BIGINT() throws IOException {
		return new BigInteger(TOKEN());
	}

}

class AF {
	private Object array;
	private int oa = 0;
	private int ob = 0;
	private int as = 10;
	private int bs = 10;

	public AF(Object array) {
		this.array = array;
	}

	public AF(Object array, int oa, int ob) {
		this.array = array;
		this.oa = oa;
		this.ob = ob;
	}

	public AF(Object array, int oa, int ob, int as, int bs) {
		this.array = array;
		this.oa = oa;
		this.ob = ob;
		this.as = as;
		this.bs = bs;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < as; a++) {
			sb.append(a + oa).append('[');
			for (int b = 0; b < bs; b++) {
				sb.append(get(a, b));
				if (b != bs - 1)
					sb.append(',');
			}
			sb.append("]\n");
		}
		return sb.toString();
	}

	private String get(int a, int b) {
		a += oa;
		b += ob;
		String s = " ";
		try {
			if (array instanceof int[][]) {
				int[][] na = (int[][]) array;
				s = Integer.toString(na[a][b]);
			} else if (array instanceof byte[][]) {
				byte[][] na = (byte[][]) array;
				s = Byte.toString(na[a][b]);
			} else if (array instanceof Object[][]) {
				Object[][] na = (Object[][]) array;
				s = na[a][b].toString();
			}
		} catch (Exception e) {
		}
		while (s.length() < 2) {
			s = " " + s;
		}
		return s;
	}
}

class AF2 extends JFrame implements ActionListener {
	static Object lock = new Object();

	private JTable jt;

	public AF2(String title, int[][] data) {
		super(title);
		setSize(150, 150);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
				System.exit(0);
			}
		});
		jt = new JTable(new ITableModel(data));
		jt.setDefaultRenderer(Integer.class, new CustomTableCellRenderer());

		// jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(jt,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(pane);
		
		JButton button = new JButton("Continue");
		getContentPane().add(button, BorderLayout.SOUTH);
		button.addActionListener(this);
		
		pack();
		setVisible(true);
	}

	public void updateData(int[][] data) {
		((ITableModel) jt.getModel()).updateData(data);
		/*synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
			}
		}*/
		return;
	}

	public void actionPerformed(ActionEvent arg0) {
		synchronized (lock) {
			lock.notify();
		}
	}
}

class ITableModel extends AbstractTableModel {
	int[][] data;
	int[][] old_data;

	public ITableModel(int[][] data) {
		if (data != null)
			this.data = data;
		else
			this.data = new int[1][1];
	}

	public void updateData(int[][] p_data) {
		if( p_data.length == data.length && p_data[0].length == data[0].length ) {
			old_data = data;
		} else {
			old_data = null;
		}
		this.data = p_data;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				fireTableStructureChanged();
			}
		});
	}

	public int getColumnCount() {
		return data[0].length + 1;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int column) {
		return Integer.toString(column - 1);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return rowIndex;
		if( old_data != null && data[rowIndex][columnIndex - 1] != old_data[rowIndex][columnIndex - 1] ) {
			return ""+old_data[rowIndex][columnIndex - 1]+" -> "+data[rowIndex][columnIndex - 1];
		}
		return data[rowIndex][columnIndex - 1];
	}

	public Class<?> getColumnClass(int arg0) {
		return getValueAt(0, arg0).getClass();
	}
}

class CustomTableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component cell = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		if (column == 0) {
			cell.setBackground(Color.gray);
		} else if (value instanceof Integer) {
			Integer amount = (Integer) value;
			if (amount.intValue() <= 0) {
				cell.setBackground(Color.red);
			} else {
				cell.setBackground(Color.white);
			}
		} else {
			cell.setBackground(Color.yellow);
		}
		return cell;
	}
}
