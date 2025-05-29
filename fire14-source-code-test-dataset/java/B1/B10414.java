package com.google.codjam.utils;

import com.google.codjam.problems.BotTrust;
import com.google.codjam.problems.CandySplitting;
import com.google.codjam.problems.RecycledNumbers;


public class MainRun {

    public static void main(String[] args) 
    {
        String prefixPath = "D:\\pry\\googlejam\\2012\\pryCodJam\\src\\";
        FileDataAndSettings fS  = new FileDataAndSettings();
        FileLoader.processFile( fS ,prefixPath+ "input.in", 1  ,new RecycledNumbers() );

    }
    

}
