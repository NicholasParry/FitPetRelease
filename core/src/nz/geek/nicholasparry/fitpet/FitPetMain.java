package nz.geek.nicholasparry.fitpet;

//WOO we are now offically building at 1.7 compliance (Goodbye 1.6, hellow switched strings and de-sugaring

//oden is randioactie
//stanly is standard
//hulga is the big bithch
//quintin is the cool one



import nz.geek.nicholasparry.fitpet.Assets.SoundAssets;
import nz.geek.nicholasparry.fitpet.PlatformDependant.PlatformPackage;
import nz.geek.nicholasparry.fitpet.PlatformDependant.SaveManager;
import nz.geek.nicholasparry.fitpet.Screen.HomeScreen;
import nz.geek.nicholasparry.fitpet.Screen.MainMenuScreen;
import nz.geek.nicholasparry.fitpet.components.AudioPlayer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

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
	
	public FitPetMain(SaveManager _saveManager){
		saveManager = _saveManager;
                //sSystem.out.println(Gdx.files.internal("").path());
                //Gdx.files.
		
		//mainTheme = new AudioPlayer();
		//mainTheme.playSound(SoundAssets.mainTheme, true);
		//mainTheme.pauseSound();
	}
	
	public FitPetMain(){
		fitPetMain = this;
		//mainTheme = new AudioPlayer();
		//mainTheme.playSound(SoundAssets.mainTheme, true);
		//mainTheme.pauseSound();
	}
	
	@Override
	public void create () {
		if(saveManager == null){
			saveManager = new AndroidSaveManager();
		}
		setScreen(new MainMenuScreen(this));
		//Gdx.app.setLogLevel(0);
		if(saveManager.autoLoad() && loadGame()){
			setScreen(new HomeScreen(this));
		} else {
			setScreen(new MainMenuScreen(this));
		}
		
		//mainTheme = new AudioPlayer();
		//mainTheme.playSound(SoundAssets.mainTheme, true);
		//mainTheme.pauseSound();
		makeMainThemeObj();
		playMainTheme();
	}
	
	@Override
	public void render () {
		super.render(); //important, but always fun to turn off :D
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player _player){
		player = _player;
	}
	
	public boolean saveGame(){
		
		return saveManager.savePlayer(player);
	}
	
	public boolean loadGame(){
		player = saveManager.getPlayer();
		player.onDeserialization();
		
		//Gdx.app.log("FitPetMain", player.toString());
		return (player != null);
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
	
	
}
