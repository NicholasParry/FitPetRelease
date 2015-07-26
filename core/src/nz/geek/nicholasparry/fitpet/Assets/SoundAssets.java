package nz.geek.nicholasparry.fitpet.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;

public class SoundAssets {

	public static Sound mainTheme = Gdx.audio.newSound(Gdx.files.internal("sounds/music/MainTheme/MainTheme16.wav"));
	public static Sound battleTheme = Gdx.audio.newSound(Gdx.files.internal("sounds/music/BattleTheme/BattleTheme16.wav"));
	public static Sound hitFx = Gdx.audio.newSound(Gdx.files.internal("sounds/effects/Hitfx16.wav"));
	
	public SoundAssets() {
		// TODO Auto-generated constructor stub
	}

}
