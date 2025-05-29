package com.vp.impl;

import java.util.ResourceBundle;

import com.vp.iface.Problem;

public class SpeakGooglerese implements Problem {

	@Override
	public String solve(String[] dataset) {
		
		ResourceBundle rb = ResourceBundle.getBundle("Mapping");
		String strReturnValue = "";
		//System.out.println("Translated Text: " + strReturnValue);
		
		
		String strGooglereseSentence = dataset[0];
		
		String[] strGooglereseWords = strGooglereseSentence.split(" ");
		
		for(int i=0; i<strGooglereseWords.length; i++)
		{
			if(i >0 )
			{
				strReturnValue += " ";
			}
			char strChars[] = strGooglereseWords[i].toCharArray();
			
			for(int j=0;j<strChars.length;j++)
			{
				try
				{
				   strReturnValue += rb.getString(strChars[j]+"");
				}
				catch(Exception ex)
				{
					strReturnValue += "!";
				}
			}
		}
		
		System.out.println("Translated Text: " + strReturnValue);
		return strReturnValue.trim();
	}

}
