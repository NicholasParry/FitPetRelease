package nz.geek.nicholasparry.fitpet.components;

import com.badlogic.gdx.audio.Sound;

public class AudioPlayer {
	
	private Sound sound;
	private boolean looping;
	private boolean playing;

	public AudioPlayer() {
		playing = false;
	}
	
	public void playSound(Sound _sound, boolean _looping){
		sound = _sound;
		looping = _looping;
		if(!playing){
			if(looping){
				sound.loop();
			} else {
				sound.play();
			}
			playing = true;
		}
	}
	
	public void stopSound(){
		if(playing){
			sound.stop();
			playing = false;
		}
	}
	
	public void pauseSound(){
		if(playing){
			sound.pause();
			playing = false;
		}
	}
	
	public void unpauseSound(){
		if(!playing){
			if(looping){
				sound.loop();
			} else {
				sound.play();
			}
			playing = true;
		}
	}

}
