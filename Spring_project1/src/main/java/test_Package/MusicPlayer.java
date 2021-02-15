package test_Package;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
	
	private Music music;
	private String name;
	private int vol;	
	private List<Music> listMusic;
	
	public MusicPlayer() {}	
	
	public MusicPlayer(Music music) {
		this.music = music;
	}		
	
/*	public MusicPlayer(List<Music> listMusic) {
		this.listMusic = listMusic;
	}*/
	
	
	public List<Music> getListMusic() {return listMusic;}

	public void setListMusic(List<Music> listMusic) {this.listMusic = listMusic;}

	public void startSong() {System.out.println(music.playMusic());	}
	
	public void setMusik(Music music) {	this.music = music; }

	public void setName(String name) {this.name = name;	}

	public void setVol(int vol) {this.vol = vol;}

	public String getName() {return name;}

	public int getVol() {return vol;}

}
