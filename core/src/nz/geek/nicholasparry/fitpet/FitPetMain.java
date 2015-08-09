package nz.geek.nicholasparry.fitpet;

//WOO we are now offically building at 1.7 compliance (Goodbye 1.6, hellow switched strings and de-sugaring

//oden is randioactie
//stanly is standard
//hulga is the big bithch
//quintin is the cool one



import nz.geek.nicholasparry.fitpet.Assets.SoundAssets;
import nz.geek.nicholasparry.fitpet.PlatformDependant.PlatformPackage;
import nz.geek.nicholasparry.fitpet.saves.SaveManager;
import nz.geek.nicholasparry.fitpet.Screen.HomeScreen;
import nz.geek.nicholasparry.fitpet.Screen.MainMenuScreen;
import nz.geek.nicholasparry.fitpet.Screen.NewGameScreen;
import nz.geek.nicholasparry.fitpet.components.AudioPlayer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import engine.screen.SplashScreen;

/**
 * Main game Class for FitPet, used by all projects (Android, pc, etc.)
 * @author Nick
 *
 */
public class FitPetMain extends Game{
	
	SplashScreen badLogicScreen;
	private Player player;
	private SaveManager saveManager;
	private AudioPlayer mainTheme;
	
	
	public static FitPetMain fitPetMain; // oh fucking man, I AM THE BEST CODER EVER
	public static PlatformPackage platformPackage;
	
	
	
	public FitPetMain(){
		fitPetMain = this;
		//mainTheme = new AudioPlayer();
		//mainTheme.playSound(SoundAssets.mainTheme, true);
		//mainTheme.pauseSound();
	}
	
	@Override
	public void create () {
		//setup shit
		
		//play sound
		makeMainThemeObj();
		playMainTheme();
		
		//Set up saves
		saveManager = new SaveManager();
		if(saveManager.savedGameExsistes()){
			player = saveManager.loadGame();
			if(player == null){
				setScreen(new NewGameScreen(this));
				return;
			}
			setScreen(new HomeScreen(this));
		} else {
			setScreen(new NewGameScreen(this));
		}
		
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0,1,0,1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render(); //important, but always fun to turn off :D
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player _player){
		player = _player;
	}
	
	public boolean saveGame(){
		return saveManager.saveGame(player);
	}
	
	/**
	 * Loads a game
	 * @return true if successful
	 */
	public boolean loadGame(){
		if(saveManager.savedGameExsistes()){
			player = saveManager.loadGame();
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Plays main theme
	 */
	public void playMainTheme(){
		if(mainTheme == null){
			makeMainThemeObj();
		}
		mainTheme.unpauseSound();
	}
	
	/**
	 * Puases main theme
	 */
	public void pauseMainTheme(){
		if(mainTheme == null){
			makeMainThemeObj();
		}
		mainTheme.pauseSound();
	}
	
	/**
	 * Makes main theme
	 */
	private void makeMainThemeObj(){
		mainTheme = new AudioPlayer();
		mainTheme.playSound(SoundAssets.mainTheme, true);
		mainTheme.pauseSound();
	}
	
	
	
	/**
	 * Switches screen and saves the game, fantastico
	 */
	@Override
	public void setScreen(Screen screen) {
		saveGame();
		super.setScreen(screen);
	}
	
	
}
