package com.stc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RecycledNumbers {

	public RecycledNumbers(LinkedList<String> lines) 
	{
		StringBuilder out = new StringBuilder();
		int i=0;
		for(String line : lines)
		{
			String[] ab = line.split(" ");
			out.append("Case #").append((i+1)).append(": ");
			out.append(distinctRecycledNumberCountFromAtoB(ab));
			out.append("\r\n");
			i++;
		}
		System.out.println(out.toString());
	}
	private HashMap<String,HashMap<String,HashSet<String>>> allDistinctRecycledNumbersByLength = new HashMap<String, HashMap<String,HashSet<String>>>();
	private int distinctRecycledNumberCountFromAtoB(String[] ab) 
	{
		HashSet<String> ad = new HashSet<String>();
		String a = ab[0];
		String b = ab[1];
		int ilena = a.length();
		String lena = ""+ilena;
		
		fillRecycledNumberSet(lena);
		HashMap<String,HashSet<String>> allrecnums = allDistinctRecycledNumbersByLength.get(lena);
		Set<String> allrecnumskeys = allrecnums.keySet();
		for(String n : allrecnumskeys)
		{
			HashSet<String> ms = allrecnums.get(n);
			for(String m : ms)
			{
				if(isAlteNlteMlteB(a, n, m, b)){ad.add(n+","+m);}
			}
		}
		String disp = "";
		//for(String ads : ad){disp+="["+ads+"], ";}
		return ad.size();
	}
	private void fillRecycledNumberSet(String lena) 
	{
		int ilena = Integer.parseInt(lena);
		if(!allDistinctRecycledNumbersByLength.containsKey(lena))
		{
			HashMap<String,HashSet<String>> rn = new HashMap<String, HashSet<String>>();
			String zeros = "";
			String nines = "";
			for(int i=0;i<ilena;i++){zeros+="0";nines+="9";}
			int inines = Integer.parseInt(nines);
			for(int i=0;i<=inines;i++)
			{
				String is = ""+i;
				while(is.length()<ilena)
				{
					is = "0"+is;
				}
				HashSet<String> recnums = recycle(is);
				rn.put(is,recnums);
			}
			allDistinctRecycledNumbersByLength.put(lena, rn);
		}
		
	}
	public HashSet<String> recycle(String n)
	{
		if(n.startsWith("0")){return new HashSet<String>();}
		HashSet<String> rtn = new HashSet<String>();
		for(int i=n.length()-1;i>0;i--)
		{
			String end = n.substring(i);
			String begin = n.substring(0,i);
			String rcd = end+begin;
			if(!rcd.startsWith("0"))
			{
				if(!n.equals(rcd))
				{
				rtn.add(rcd);
				}
			}
			//System.out.println(rcd);
		}
		
		return rtn;
	}
	private boolean isAlteNlteMlteB(String a,String n,String m,String b)
	{
		return (
				(Integer.parseInt(a)<=Integer.parseInt(n))
				&& (Integer.parseInt(n)<=Integer.parseInt(m))
				&& (Integer.parseInt(m)<=Integer.parseInt(b))
				
		);
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InputStreamReader inr = new InputStreamReader(System.in);
		
		BufferedReader br = new BufferedReader(inr);
		
		LinkedList<String> lines=new LinkedList<String>();
		String line = br.readLine();
		int ncases = Integer.parseInt(line);
		for(int i=0;i<ncases-1;i++)
		{
			line = br.readLine();
			if((line!=null)&&(line.length()>0))
			{
				lines.addLast(line);
			}
		}
		char[] tc = new char[1];
		String lastLine = "";
		int len = 0;
		while(true)
		{
			br.read(tc, 0, 1);
			if(tc[0]!=' '){lastLine+=tc[0];len++;}
			else
			{
				lastLine+=" ";
				for(int i=0;i<len;i++){br.read(tc, 0, 1);lastLine+=tc[0];}
				break;
			}
		}
		lines.addLast(lastLine);
		RecycledNumbers rn = new RecycledNumbers(lines);

	}

}
