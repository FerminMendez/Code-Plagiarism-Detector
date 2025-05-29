package com.google.codjam.utils;

import java.util.ArrayList;

public class FileDataAndSettings {

    private Integer nCases;
    private ArrayList<ArrayList> inputCase;
    private String tokenSep;
    
    public FileDataAndSettings()
    {
        inputCase = new ArrayList<ArrayList>(0);
    }
    

    public void setNCases(Integer nCases) {
        this.nCases = nCases;
    }

    public Integer getNCases() {
        return nCases;
    }

    public void setInputCase(ArrayList<ArrayList> inputCase) {
        this.inputCase = inputCase;
    }

    public ArrayList<ArrayList> getInputCase() {
        return inputCase;
    }

    public void setTokenSep(String tokenSep) {
        this.tokenSep = tokenSep;
    }

    public String getTokenSep() {
        return tokenSep;
    }
}
