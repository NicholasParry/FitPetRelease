package nz.geek.nicholasparry.fitpet.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetHanldler {
	
	public static Texture chooseAPetText = new Texture(Gdx.files.internal("ChooseAPetText.png"));
	public static Texture grey = new Texture(Gdx.files.internal("grey.png"));
	
	public static FileHandle styleJson = (Gdx.files.internal("Skins/uiskin.json"));
	public static Skin skin = new Skin(styleJson);

	public static Skin oldSkin = new Skin(Gdx.files.internal("Skins/old/uiskin.json"));
	

	public static Skin testSking = new Skin(Gdx.files.internal("Skins/uiskin.json")); 
	public static Skin battleSkin = new Skin(Gdx.files.internal("Skins/uiskin.json"));  

	public static Object Buttons;
	
	public static Texture wonBattle  = new Texture(Gdx.files.internal("wonBattle.png"));
	public static Texture lostBattle  = new Texture(Gdx.files.internal("lostBattle.png"));
	
	
	public AssetHanldler() {/*
		newGameButton = new Texture(Gdx.files.internal("NewGameButton.png"));
		loadGameButton = new Texture(Gdx.files.internal("LoadGameButton.png"));
		nextButton = new Texture(Gdx.files.internal("NextButton.png"));
		axolotlPetCard = new Texture(Gdx.files.internal("AxolotlCard.png"));
		fireAntPetCard = new Texture(Gdx.files.internal("FireAntCard.png"));
		molePetCard = new Texture(Gdx.files.internal("MoleCard.png"));
		chooseAPetText = new Texture(Gdx.files.internal("ChooseAPetText.png"));
		feedIcon = new Texture(Gdx.files.internal("feedIcon.png"));
		playIcon = new Texture(Gdx.files.internal("playIcon.png"));
		battleIcon = new Texture(Gdx.files.internal("battleIcon.png"));
		axolotl = new Texture(Gdx.files.internal("axolotl.png"));
		fireAnt = new Texture(Gdx.files.internal("axolotl.png"));
		mole = new Texture(Gdx.files.internal("axolotl.png"));
		grey = new Texture(Gdx.files.internal("grey.png"));
		
		FileHandle styleJson = (Gdx.files.internal("uiskin.json"));
		skin = new Skin(styleJson);
		*/
		
		//battleSkin.getFont("defult").setColor(Color.BLACK);
	}
	
	
}
