package template;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TestCase {

    private boolean isSolved;
    private Object solution;
    private Map<String, Integer> intProperties;
    private Map<String, ArrayList<Integer>> intArrayProperties;
    private Map<String, ArrayList<ArrayList<Integer>>> intArray2DProperties;
    private Map<String, Double> doubleProperties;
    private Map<String, ArrayList<Double>> doubleArrayProperties;
    private Map<String, ArrayList<ArrayList<Double>>> doubleArray2DProperties;
    private Map<String, String> stringProperties;
    private Map<String, ArrayList<String>> stringArrayProperties;
    private Map<String, ArrayList<ArrayList<String>>> stringArray2DProperties;
    private Map<String, Boolean> booleanProperties;
    private Map<String, ArrayList<Boolean>> booleanArrayProperties;
    private Map<String, ArrayList<ArrayList<Boolean>>> booleanArray2DProperties;
    private Map<String, Long> longProperties;
    private Map<String, ArrayList<Long>> longArrayProperties;
    private Map<String, ArrayList<ArrayList<Long>>> longArray2DProperties;
    private int ref;
    private double time;

    public TestCase() {
        initialise();
    }

    private void initialise() {
        isSolved = false;
        intProperties = new HashMap<>();
        intArrayProperties = new HashMap<>();
        intArray2DProperties = new HashMap<>();
        doubleProperties = new HashMap<>();
        doubleArrayProperties = new HashMap<>();
        doubleArray2DProperties = new HashMap<>();
        stringProperties = new HashMap<>();
        stringArrayProperties = new HashMap<>();
        stringArray2DProperties = new HashMap<>();
        booleanProperties = new HashMap<>();
        booleanArrayProperties = new HashMap<>();
        booleanArray2DProperties = new HashMap<>();
        longProperties = new HashMap<>();
        longArrayProperties = new HashMap<>();
        longArray2DProperties = new HashMap<>();
        ref = 0;
    }

    public void setSolution(Object o) {
        solution = o;
        isSolved = true;
    }
    
    public Object getSolution() {
        if (!isSolved) {
            Utils.die("getSolution on unsolved testcase");
        }

        return solution;
    }

    public void setRef(int i) {
        ref = i;
    }
    public int getRef() {
        return ref;
    }

    public void setTime(double d) {
        time = d;
    }
    public double getTime() {
        return time;
    }
    
    public void setInteger(String s, Integer i) {
        intProperties.put(s, i);
    }
    
    public Integer getInteger(String s) {
        return intProperties.get(s);
    }

    public void setIntegerList(String s, ArrayList<Integer> l) {
        intArrayProperties.put(s, l);
    }

    public void setIntegerMatrix(String s, ArrayList<ArrayList<Integer>> l) {
        intArray2DProperties.put(s, l);
    }

    public ArrayList<Integer> getIntegerList(String s) {
        return intArrayProperties.get(s);
    }

    public Integer getIntegerListItem(String s, int i) {
        return intArrayProperties.get(s).get(i);
    }

    public ArrayList<ArrayList<Integer>> getIntegerMatrix(String s) {
        return intArray2DProperties.get(s);
    }
    
    public ArrayList<Integer> getIntegerMatrixRow(String s, int row) {
        return intArray2DProperties.get(s).get(row);
    }
    
    public Integer getIntegerMatrixItem(String s, int row, int column) {
        return intArray2DProperties.get(s).get(row).get(column);
    }

    public ArrayList<Integer> getIntegerMatrixColumn(String s, int column) {
        ArrayList<Integer> out = new ArrayList();
        
        for(ArrayList<Integer> row : intArray2DProperties.get(s)) {
            out.add(row.get(column));
        }
        return out;
    }


    public void setDouble(String s, Double i) {
        doubleProperties.put(s, i);
    }
    
    public Double getDouble(String s) {
        return doubleProperties.get(s);
    }

    public void setDoubleList(String s, ArrayList<Double> l) {
        doubleArrayProperties.put(s, l);
    }

    public void setDoubleMatrix(String s, ArrayList<ArrayList<Double>> l) {
        doubleArray2DProperties.put(s, l);
    }

    public ArrayList<Double> getDoubleList(String s) {
        return doubleArrayProperties.get(s);
    }

    public Double getDoubleListItem(String s, int i) {
        return doubleArrayProperties.get(s).get(i);
    }

    public ArrayList<ArrayList<Double>> getDoubleMatrix(String s) {
        return doubleArray2DProperties.get(s);
    }
    
    public ArrayList<Double> getDoubleMatrixRow(String s, int row) {
        return doubleArray2DProperties.get(s).get(row);
    }
    
    public Double getDoubleMatrixItem(String s, int row, int column) {
        return doubleArray2DProperties.get(s).get(row).get(column);
    }

    public ArrayList<Double> getDoubleMatrixColumn(String s, int column) {
        ArrayList<Double> out = new ArrayList();
        
        for(ArrayList<Double> row : doubleArray2DProperties.get(s)) {
            out.add(row.get(column));
        }
        return out;
    }

    
    public void setString(String s, String t) {
        stringProperties.put(s, t);
    }
    
    public String getString(String s) {
        return stringProperties.get(s);
    }

    public void setStringList(String s, ArrayList<String> l) {
        stringArrayProperties.put(s, l);
    }

    public void setStringMatrix(String s, ArrayList<ArrayList<String>> l) {
        stringArray2DProperties.put(s, l);
    }

    public ArrayList<String> getStringList(String s) {
        return stringArrayProperties.get(s);
    }

    public String getStringListItem(String s, int i) {
        return stringArrayProperties.get(s).get(i);
    }

    public ArrayList<ArrayList<String>> getStringMatrix(String s) {
        return stringArray2DProperties.get(s);
    }
    
    public ArrayList<String> getStringMatrixRow(String s, int row) {
        return stringArray2DProperties.get(s).get(row);
    }
    
    public String getStringMatrixItem(String s, int row, int column) {
        return stringArray2DProperties.get(s).get(row).get(column);
    }

    public ArrayList<String> getStringMatrixColumn(String s, int column) {
        ArrayList<String> out = new ArrayList();
        
        for(ArrayList<String> row : stringArray2DProperties.get(s)) {
            out.add(row.get(column));
        }
        return out;
    }

    
    public void setBoolean(String s, Boolean b) {
        booleanProperties.put(s, b);
    }
    
    public Boolean getBoolean(String s) {
        return booleanProperties.get(s);
    }

    public void setBooleanList(String s, ArrayList<Boolean> l) {
        booleanArrayProperties.put(s, l);
    }

    public void setBooleanMatrix(String s, ArrayList<ArrayList<Boolean>> l) {
        booleanArray2DProperties.put(s, l);
    }

    public ArrayList<Boolean> getBooleanList(String s) {
        return booleanArrayProperties.get(s);
    }

    public Boolean getBooleanListItem(String s, int i) {
        return booleanArrayProperties.get(s).get(i);
    }

    public ArrayList<ArrayList<Boolean>> getBooleanMatrix(String s) {
        return booleanArray2DProperties.get(s);
    }
    
    public ArrayList<Boolean> getBooleanMatrixRow(String s, int row) {
        return booleanArray2DProperties.get(s).get(row);
    }
    
    public Boolean getBooleanMatrixItem(String s, int row, int column) {
        return booleanArray2DProperties.get(s).get(row).get(column);
    }

    public ArrayList<Boolean> getBooleanMatrixColumn(String s, int column) {
        ArrayList<Boolean> out = new ArrayList();
        
        for(ArrayList<Boolean> row : booleanArray2DProperties.get(s)) {
            out.add(row.get(column));
        }
        return out;
    }

    public void setLong(String s, Long b) {
        longProperties.put(s, b);
    }
    
    public Long getLong(String s) {
        return longProperties.get(s);
    }

    public void setLongList(String s, ArrayList<Long> l) {
        longArrayProperties.put(s, l);
    }

    public void setLongMatrix(String s, ArrayList<ArrayList<Long>> l) {
        longArray2DProperties.put(s, l);
    }

    public ArrayList<Long> getLongList(String s) {
        return longArrayProperties.get(s);
    }

    public Long getLongListItem(String s, int i) {
        return longArrayProperties.get(s).get(i);
    }

    public ArrayList<ArrayList<Long>> getLongMatrix(String s) {
        return longArray2DProperties.get(s);
    }
    
    public ArrayList<Long> getLongMatrixRow(String s, int row) {
        return longArray2DProperties.get(s).get(row);
    }
    
    public Long getLongMatrixItem(String s, int row, int column) {
        return longArray2DProperties.get(s).get(row).get(column);
    }

    public ArrayList<Long> getLongMatrixColumn(String s, int column) {
        ArrayList<Long> out = new ArrayList();
        
        for(ArrayList<Long> row : longArray2DProperties.get(s)) {
            out.add(row.get(column));
        }
        return out;
    }

    

    


}
