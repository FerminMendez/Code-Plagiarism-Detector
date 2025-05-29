import java.util.Arrays;


public class HSC {
	public int a;
	public int b;
	
	public HSC(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int hashCode() {
		return (int) Math.random();
	}
	
	@Override
	public boolean equals(Object o) {

		if (this == o)  
            return true;  
        if (o == null)  
            return false;  
        if (getClass() != o.getClass())  
            return false;  
        HSC other = (HSC) o;  
        
        return other.a == a && other.b == b;  
	}
}
