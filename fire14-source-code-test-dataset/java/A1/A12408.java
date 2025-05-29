package com.wordofday.service.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleDance {

	public static void main(String[] args){
		GoogleDance dancer = new GoogleDance();
		try{
			  FileInputStream in = new FileInputStream(args[0]);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = null;
			  int count = 0;
			  while ((strLine = br.readLine()) != null)   {
				  if(count>0){
					  //skip first line
					  if(count>1){
						  System.out.print("\nCase #"+count+": "+dancer.output(strLine));
					  }else{
						  System.out.print("Case #"+count+": "+dancer.output(strLine));
					  }
				  }
				  count++;
				  
			  }
			  //Close the input stream
			  in.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private int output(String strLine) {
		int output = 0;
		String[] parts = strLine.split(" ");
		int totalItems = Integer.parseInt(parts[0]);
		int surprises = Integer.parseInt(parts[1]);
		int threshold = Integer.parseInt(parts[2]);
		List<Integer> scores = new ArrayList<Integer>();
		for(int i=3;i<parts.length;i++){
			scores.add(Integer.parseInt(parts[i]));
		}
		//each item may have multiple triplets as solutions
		//also each may have multiple as surprises
		List<Map<String,List<List<Integer>>>> outputList = new ArrayList<Map<String,List<List<Integer>>>>();
		for(Integer score:scores){
			Map<String,List<List<Integer>>> scoreMap = new HashMap<String, List<List<Integer>>>();
			List<Integer> outputResult = new ArrayList<Integer>();
			//try dividing by 3 and look for +-1
			int benchMark = score/3;
			int firstScore = benchMark ;
			int secondScore = benchMark;
			int thirdScore = benchMark;
			for(int a=-2;a<2;a++){
				firstScore = benchMark+a;
				
				for(int b=-2;b<=2;b++){
					secondScore = benchMark +b; 
					for(int c=-2;c<=2;c++){
						thirdScore = benchMark +c;
						validateScore(threshold, score, scoreMap, outputResult, firstScore,
								secondScore, thirdScore);
						outputResult= new ArrayList<Integer>();
					}
				}
			}
			outputList.add(scoreMap);
			
		}
		
		int totalItemsWithSurprises = 0;
		for(int m=0;m<outputList.size();m++){
			Map<String,List<List<Integer>>> scoreMap = outputList.get(m);
			if(scoreMap.get("surprise")!=null){
				List<List<Integer>> surpriseList = scoreMap.get("surprise");
				if(surpriseList.size()>0){
					//if this isnt a needed surprise, remove it
					 if( scoreMap.get("normal") != null
						&& scoreMap.get("normal").size() > 0 &&
						(isValidThresHold(	scoreMap.get("normal"), threshold) || (
						!isValidThresHold(scoreMap.get("normal"), threshold) && !isValidThresHold(
						scoreMap.get("surprise"), threshold)))){
						 scoreMap.remove("surprise");
					 }else{
						 if(totalItemsWithSurprises>=surprises){
							 scoreMap.remove("surprise");
						 }else{
							 totalItemsWithSurprises++;
						 }
					 }
				}
			}
		}

		int diff = totalItemsWithSurprises-surprises;
		
		if(totalItemsWithSurprises>surprises){/*
			while (diff > 0) {
				// diff are the extra items that have surprises more than needed
				// clear the surprises from those if they already have a normal
				// solution

				for (int m = 0; m < outputList.size(); m++) {
					Map<String, List<List<Integer>>> scoreMap = outputList
							.get(m);
					if (scoreMap.get("surprise") != null) {
						if (surprises == 0
								|| (diff > 0
										&& scoreMap.get("surprise").size() > 1
										&& scoreMap.get("normal") != null
										&& scoreMap.get("normal").size() > 0 && (isValidThresHold(
										scoreMap.get("normal"), threshold) || (
										!isValidThresHold(
										scoreMap.get("normal"), threshold) && !isValidThresHold(
										scoreMap.get("surprise"), threshold))))) {
							scoreMap.remove("surprise");
							diff--;
						}
					}
				}
			}
		*/}
		
		
		totalItemsWithSurprises=0;
		for (int m = 0; m < outputList.size(); m++) {
			Map<String, List<List<Integer>>> scoreMap = outputList.get(m);
			
			List<List<Integer>> surpriseList = scoreMap.get("surprise");
			List<List<Integer>> normalList = scoreMap.get("normal");
			
			if(isValidThresHold(surpriseList,threshold)
			||isValidThresHold(normalList,threshold)){
				output++;
			}
		}
		return output;
	}

	private boolean isValidThresHold(List<List<Integer>> normalList,
			int threshold) {
		boolean valid = false;
		if(normalList!=null){
			for(List<Integer> data:normalList){
				for(Integer item:data){
					if(item>=threshold){
						valid = true;
						break;
					}
				}
			}
		}
		return valid;
	}

	private void validateScore(int threshold, Integer score,
			Map<String, List<List<Integer>>> scoreMap,
			List<Integer> outputResult, int firstScore, int secondScore,
			int thirdScore) {
		if(isValid(firstScore,secondScore,thirdScore, score,threshold)){
			outputResult.add(firstScore);
			outputResult.add(secondScore);
			outputResult.add(thirdScore);

			if((firstScore-secondScore)==2
					|| (firstScore-secondScore)==-2
					|| (secondScore-thirdScore)==2
					|| (secondScore-thirdScore)==-2
					|| (firstScore-thirdScore)==2
					|| (firstScore-thirdScore)==-2
			){
				List<List<Integer>> surpriseList = scoreMap.get("surprise");
				if(surpriseList==null){
					surpriseList = new ArrayList<List<Integer>>();
				}
				surpriseList.add(outputResult);
				scoreMap.put("surprise", surpriseList);
			}else{
				List<List<Integer>> normalList = scoreMap.get("normal");
				if(normalList==null){
					normalList = new ArrayList<List<Integer>>();
				}
				normalList.add(outputResult);
				scoreMap.put("normal", normalList);
			}
		}
	}

	private boolean isValid(int firstScore, int secondScore, int thirdScore,
			Integer score, int threshold) {
		if(firstScore>=0 && firstScore<=10
			&& secondScore>=0 && secondScore<=10
			&& thirdScore>=0 && thirdScore<=10
			&& (firstScore+secondScore+thirdScore)==score.intValue()
			//&& (firstScore>=threshold || secondScore>=threshold || thirdScore>=threshold)
			&& !(
					(firstScore-secondScore)>2
					|| (firstScore-secondScore)<-2
					|| (secondScore-thirdScore)>2
					|| (secondScore-thirdScore)<-2
					|| (firstScore-thirdScore)>2
					|| (firstScore-thirdScore)<-2		
			)
		){
			return true;
		}
		return false;
	}
	
	
	
}
