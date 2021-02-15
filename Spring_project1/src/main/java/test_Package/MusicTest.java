package test_Package;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicTest {
	
	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml")) {
		
     	Music music =context.getBean("musicBeanClassical", ClassicalMusic.class);
		System.out.println(music.playMusic());
		Music music2 =context.getBean("musicBeanClassical", ClassicalMusic.class);
		System.out.println(music == music2);
		System.out.println(music.playMusic());   
		
	
	/*	//get collection method
			MusicPlayer mp = context.getBean("musicPlayer", MusicPlayer.class);
			System.out.println(mp.getListMusic());*/
	
			
			//Dependency injection  via consturction or setmethod + set value by hand or via property file 
			/*	MusicPlayer mp = context.getBean("musicPlayer", MusicPlayer.class);
		mp.startSong();
		System.out.println(mp.getName() + "\n" + mp.getVol());		
		context.close();		
		 
		
		//способ получение доступа через SF
		Music music = (Music) context.getBean("musicBeanRock");
		MusicPlayer mp = new MusicPlayer(music);
		mp.startSong();
	
			//способ получение доступа вручную
		mp.setMusic(new ClassicalMusic());
		mp.startSong();		*/
		}		
		
	}

}
