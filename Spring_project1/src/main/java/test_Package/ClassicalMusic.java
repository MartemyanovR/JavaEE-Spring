package test_Package;

public class ClassicalMusic implements Music {
	private static int count = 0;
	
	
	//ФМ, при prototype создается один раз
	public static ClassicalMusic getlassicalMusic() {
		System.out.println("Start factory method: count = " + (++count) );
		return new ClassicalMusic();
	}
	
	
	public void doMyInit() {
		System.out.println("My innitialization");
	}

	@Override
	public String playMusic() {
		return "Iogaan Bach";		
	}

	@Override
	public String toString() {
		return playMusic();
	}
	
	public void doMyDestroy() {
		System.out.println("My destroy");
	}
}
