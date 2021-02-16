package example;

public class StringHolder {
		final int a ;
	    private String string;
	 
	    public StringHolder(String s) {
	    	this.a = 1;
	        this.string = s;
	    }
	 
	    public String getstring() {
	        return string;
	    }
	 
	    public void setstring(String string) {
	        this.string = string;
	    }
	 
	    public boolean equals(Object o) {
	        if (this == o)
	            return true;
	        else if (o == null || !(o instanceof StringHolder))
	            return false;
	        else {
	            final StringHolder other = (StringHolder) o;
	            if (string == null)
	                return (other.string == null);
	            else
	                return !(string == null);
	        }
	    }
	 
	    public int hashcode() {
	        return (string != null ? string.hashCode() : 0);
	    }
	 
	    public String tostring() {
	        return string;
	    }
	 
	
	 
	   
	}
