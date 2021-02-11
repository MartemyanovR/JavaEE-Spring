package test_Package;

public class RockMusic implements Music {
	private String str;
	
	@Override
	public String playMusic() {
		str = "Ramshtein";	
		return str;		
	}

	@Override
	public String toString() {
		return playMusic();
	}

	

	

}
