package contractsEqualsAndHashCode;

public class VialationSymmetry {
	private final String ignoreCase;
	
	public VialationSymmetry(String s) {
		this.ignoreCase = s;
	}
	//проверяет равенство объектов String
	@Override
	public boolean equals(Object obj) {
		/*	if(obj instanceof VialationSymmetry) {
			return this.ignoreCase.equalsIgnoreCase(((VialationSymmetry)obj).ignoreCase);
		}
		//одностороннее взаимодействие, нарушение контракта equals, а именно симметричность
		if (obj instanceof String) {
			return this.ignoreCase.equalsIgnoreCase((String) obj);
		}		*/
		
		//изящный пример 
		return obj instanceof VialationSymmetry && this.ignoreCase.equalsIgnoreCase(((VialationSymmetry)obj).ignoreCase);
	}
}
