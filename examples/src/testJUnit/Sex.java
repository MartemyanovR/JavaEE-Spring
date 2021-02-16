package testJUnit;

public class Sex {
	private String s;
	
	public boolean equals (Object o) {
		if (this == o) return true;
		return o instanceof Sex && ((Sex) o).s.equals(s);
	}
	public void S1(int i, String s) {
		
	}
	public void S1(String g, int i) {
		
	}
	public void setS (String s) {
		this.s = s;		}
	public String getS() {
		return  s;
	}
}
