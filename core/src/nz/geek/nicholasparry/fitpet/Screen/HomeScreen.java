package nz.geek.nicholasparry.fitpet.Screen;

import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.Assets.Buttons;
import nz.geek.nicholasparry.fitpet.Assets.SoundAssets;
import nz.geek.nicholasparry.fitpet.components.AudioPlayer;
import nz.geek.nicholasparry.fitpet.components.PetInfoBox;
import nz.geek.nicholasparry.fitpet.components.TextDisplayBox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.rendering.DisplayObject;
import engine.rendering.TextureButton;
import engine.screen.GameScreen;

public class HomeScreen implements Screen{

	private FitPetMain game;
	
	private TextureButton feedB;
	private TextureButton playB;
	private TextureButton battleB;
	private TextureButton petImage;
	private PetInfoBox petInfoBox;
	
	private Stage stage;
	private Viewport view;
	
	private Label fitPointsLable;
	
	private TextDisplayBox fitPointDisplayBox;
	
	
	
	public HomeScreen(FitPetMain _game) {
		game = _game;
		
		
	}

	@Override
	public void show() {
		
		view = new FillViewport(1080, 1920);
		view.update(1080, 1920, true);
		stage = new Stage(view);

		
		
		
		
		
		feedB = new TextureButton(Buttons.feedIcon);
		feedB.setSize(200, 200);
		feedB.setPosition((((stage.getWidth() / 4) * 1) - (feedB.getWidth())), 100);
		feedB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				feedPet();
				game.getPlayer().getPet().feed();
			}
		});
		stage.addActor(feedB);
		
		playB = new TextureButton(Buttons.playIcon);
		playB.setSize(200, 200);
		playB.setPosition((((stage.getWidth() / 4) * 2) - (playB.getWidth() /2)), 100);
		playB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.getPlayer().getPet().play();
			}
		});
		stage.addActor(playB);
		
		battleB = new TextureButton(Buttons.battleIcon);
		battleB.setSize(200, 200);
		battleB.setPosition((((stage.getWidth() / 4) * 3)), 100);
		battleB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.pauseMainTheme();
				game.setScreen(new BattleScreen(game));
			}
		});
		stage.addActor(battleB);
		
		
		petImage = new TextureButton(game.getPlayer().getPet().getDisplayObject().getTexture());
		petImage.setName("Pet Image");
		petImage.setOrigin(20);
		petImage.setSize(800, 800);
		petImage.setPosition((view.getWorldWidth() / 2) - (petImage.getWidth() / 2 ), (view.getWorldHeight() / 2)  - (petImage.getHeight() / 2 ));
		petImage.setZIndex(1);
		petImage.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				petInfoBox.setPosition(x + 140, y + 545, Align.topLeft);
				//petInfoBox.setPosition(x, y, Align.topLeft); //who even knows how this rendering engine works????
				petInfoBox.setVisible(!petInfoBox.isVisible());
				petInfoBox.setZIndex(100);
			}
		});
		
		Gdx.app.log("HomeScreen", "PetImg = " + petImage.getX() + " , " + petImage.getY());
		Gdx.app.log("HomeScreen", "battleB = " + battleB.getX() + " , " + battleB.getY());
		

		petInfoBox = new PetInfoBox(game.getPlayer().getPet());
		petInfoBox.setVisible(false);
		petInfoBox.setOrigin(Align.center);
		petInfoBox.setZIndex(100);
		stage.addActor(petInfoBox);
		
		
		
		stage.addActor(petImage);
		AssetHanldler.skin.add("B", battleB);
		Gdx.input.setInputProcessor(stage);
		
		game.playMainTheme();
		
		
		//stage = new Stage(view);
		fitPointsLable = new Label("FitPoints: " + game.getPlayer().getPlayerCard().getFitPoints(),	AssetHanldler.battleSkin);
		//fitPointsLable.setPosition((stage.getWidth()/3) - 200, (stage.getHeight()/3) - 200);
		//fitPointsLable.setZIndex(100);
		//fitPointsLable.
		fitPointsLable.setText("Boo");
		//fitPointsLable.setVisible(true);
		//fitPointsLable.setPosition(140, 560);
		//stage.addActor(fitPointsLable);
		Gdx.app.log("BattleScreen", Integer.toString((int)fitPointsLable.getX()));
		System.out.println(stage.getActors().get(0).isVisible());
		
		
		
		fitPointsLable.setScale(3f);
		
		fitPointDisplayBox = new TextDisplayBox("FitPoints: " + game.getPlayer().getPlayerCard().getFitPoints());
		fitPointDisplayBox.setPosition((stage.getWidth() / 2) - (fitPointDisplayBox.getWidth() + 50),
				(stage.getHeight() / 1) - (fitPointDisplayBox.getHeight()));
		stage.addActor(fitPointDisplayBox);
		
	}
	
	/*
	@Override
	public void render(float delta) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch = new SpriteBatch();
		batch.begin();
		batch.draw(petDisplay.getTexture(), 50, 50);
		batch.end();
	}*/
	
	public void feedPet(){
		
	}
	
	public void playPet(){
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fitPointDisplayBox.update("FitPoints: " + game.getPlayer().getPlayerCard().getFitPoints());
		fitPointDisplayBox.setPosition((stage.getWidth() / 2) - (fitPointDisplayBox.getWidth() + 175),
				(stage.getHeight() / 1) - (fitPointDisplayBox.getHeight()));
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
		// TODO Auto-generated method stub
		
	}
	

	

}
