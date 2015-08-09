package nz.geek.nicholasparry.fitpet.Screen;


import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.Assets.Buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.rendering.TextureButton;

public class MainMenuScreen implements Screen {
	
	private Stage stage;
	private Viewport view;
	//private Image backGroundI;
	private TextureButton newGameB;
	private TextureButton loadGameB;
	private FitPetMain game;
	
	public MainMenuScreen(FitPetMain _game) {
		game = _game;
		
		//fix font color issue
		//AssetHanldler.battleSkin.getFont("default-font").setColor(Color.BLACK);
		System.out.println("NIXK IS COOL" + AssetHanldler.battleSkin.getFont("default-font").getColor().toString());
		
	}

	@Override
	public void show() {
		view = new FitViewport(1080, 1920);
		view.update(1080, 1920, true);
		stage = new Stage(view);
                //System.out.print(new FileHandle("BLAH.BLOO").path());
                System.out.println(Gdx.files.local("../BLAH.BLOO").path() + "fghjkl");
                System.out.println(Gdx.files.absolute("BLAH.BLOO").path());
		
                System.out.println(Gdx.files.absolute("/Users/Nick/git/FitPet/FitPet-android/").path());
                System.out.println(Gdx.files.getLocalStoragePath());
                
		//setUpNewGameButton
		newGameB = new TextureButton(Buttons.newGameButton);
		newGameB.setPosition(33, 1355 - newGameB.getHeight());
		newGameB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				newGameHit();
			}
		});
		stage.addActor(newGameB);
		
		//setup load button
		loadGameB = new TextureButton(Buttons.loadGameButton);
		loadGameB.setPosition(33, 834 - loadGameB.getHeight());
		loadGameB.setName("loadGameB");
		loadGameB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				loadGameHit();
			}
		});
		stage.addActor(loadGameB);
		
		Gdx.input.setInputProcessor(stage);
		
		game.playMainTheme();
	};

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.892f,0.892f,0.892f,1); //high RGB acuracy monitors + pickyness. 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	private void newGameHit(){
		this.dispose();
		game.setScreen(new NewGameScreen(game));
	}
	
	private void loadGameHit(){
		if(game.loadGame()){
			game.setScreen(new HomeScreen(game));
		} else {
			Gdx.app.log("Load Game", "Could not load game, starting new game");
			game.setScreen(new NewGameScreen(game));
		}
	}
	
	
	
	
}
