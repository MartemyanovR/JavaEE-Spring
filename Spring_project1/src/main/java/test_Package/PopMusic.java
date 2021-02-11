package test_Package;

public class PopMusic implements Music {

	

	@Override
	public String playMusic() {
		return "Britney Spears";		
	}
	
	@Override
	public String toString() {
		return  playMusic();
	}
	

}
