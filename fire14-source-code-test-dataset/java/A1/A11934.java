package com.sam.googlecodejam.speakingtoungue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.sam.googlecodejam.helper.InputReader;

/**
 * This class generates the mapping based on the samples that have been provided.
 * @author Saifuddin Merchant
 *
 */
public class TranslatorMapping {

	public Map<String, String> iAvalableLines = new HashMap<>(); 
	public Map<Character, Character> iLetterMapping = new TreeMap<>();

	public TranslatorMapping() {
		iAvalableLines.put("ejp mysljylc kd kxveddknmc re jsicpdrysi", "our language is impossible to understand");
		iAvalableLines.put("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd", "there are twenty six factorial possibilities");
		iAvalableLines.put("de kr kd eoya kw aej tysr re ujdr lkgc jv", "so it is okay if you want to just give up");
	}
	
	public void mapLetters()
	{
		for(Entry<String , String> lineEntry: iAvalableLines.entrySet())
		{
			String keyLine = lineEntry.getKey();
			String keyValue = lineEntry.getValue();
			int index=0;
			for(Character keyChar:keyLine.toCharArray())
			{
				iLetterMapping.put(keyChar, keyValue.charAt(index++));
			}
		}
		iLetterMapping.put('z', 'q');//add the missing mappings
		iLetterMapping.put('q', 'z');//add the missing mappings
		//System.out.println(iLetterMapping.size());
		//System.out.println(iLetterMapping);
	}
	
	public void translate(String pInput)
	{
		for(Character translateChar:pInput.toCharArray())
		{
			System.out.print(iLetterMapping.get(translateChar));
		}
	}
	
	public static void main(String[] args) {
		TranslatorMapping mapping = new TranslatorMapping();
		mapping.mapLetters();
		
		InputReader reader = new InputReader("c://input.in");
		reader.readNextLine();	//read the line number off - we don't need it
		
		String lineRead = null;
		int i=1;
		while((lineRead=reader.readNextLine())!=null )
		{
			System.out.print("Case #"+i+": "); i++;
			mapping.translate(lineRead);
			System.out.println();
		}
	}
}
