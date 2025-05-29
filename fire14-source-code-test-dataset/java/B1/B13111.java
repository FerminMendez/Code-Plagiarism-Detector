package com.vp.impl;

import java.util.HashSet;
import java.util.Set;

import com.vp.iface.Problem;

public class RecycledNumbers implements Problem {

	private static int iUpperLimit;
	private static int iLowerLimit;	
	private static int[] iVisited;

	private static Set <String> removeDuplicates;
	@Override
	public String solve(String[] dataset) {
		String strReturnValue ="";
		String strRecycledNos = dataset[0];
		String strRecycledNosArr[] = strRecycledNos.split(" ");
		
		
		iLowerLimit = Integer.parseInt(strRecycledNosArr[0]);
		iUpperLimit = Integer.parseInt(strRecycledNosArr[1]);
		iVisited = new int[iUpperLimit+1];		
		removeDuplicates = new HashSet<String>();
		
		for(int i=iLowerLimit;i<=iUpperLimit;i++)
		{
			if(iVisited[i] == 0 && i > 9)
			{
				 findMatchingNumbers(i);
			}
		}
		System.out.println("Output : " +removeDuplicates.size());
		
		 return strReturnValue + removeDuplicates.size();
	}
	
	private void findMatchingNumbers(int iVar)
	{
		String strVar = ""+iVar;
		for(int i=1; i < (strVar.length());i++)
		{
			String strSuffix = strVar.substring(0,strVar.length() -i);
			String strPrefix = strVar.substring(strVar.length() -i,strVar.length());
		
			int iNewNo = Integer.parseInt(strPrefix + strSuffix);
			
			if (iNewNo >= iLowerLimit && iNewNo <= iUpperLimit && iVar != iNewNo && iVisited[iNewNo] ==0 )
			{
				removeDuplicates.add(iVar + " : " + iNewNo);				
				iVisited[iVar] = 1;
			}
			
		}
	}
}
