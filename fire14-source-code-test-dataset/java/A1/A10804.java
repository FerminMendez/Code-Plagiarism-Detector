package qualification.Dancing;

public class Combination {
    
    int[] list;
    boolean surprising;
    
    public Combination(int[] list, boolean surprising){
        this.list = list;
        this.surprising = surprising;
    }
    
    public int[] getList(){
        return list;
    }
    
    public boolean isSurprising(){
        return surprising;
    }
    
    @Override
    public String toString(){
        String s = "";
        
        for (int i = 0; i<list.length;i++){
            s += list[i] + " ";
        }
        
        s+= " " + this.surprising;
        
        return s;
    }
    
}
