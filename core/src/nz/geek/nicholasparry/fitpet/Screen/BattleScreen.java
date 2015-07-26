package nz.geek.nicholasparry.fitpet.Screen;

import java.util.ArrayList;
import java.util.Date;

import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Player;
import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.Assets.SoundAssets;
import nz.geek.nicholasparry.fitpet.DeltaEvents.ChangeLableDeltaEvent;
import nz.geek.nicholasparry.fitpet.DeltaEvents.DeltaEvent;
import nz.geek.nicholasparry.fitpet.battle.Battle;
import nz.geek.nicholasparry.fitpet.battle.BattleControles;
import nz.geek.nicholasparry.fitpet.battle.EndResultPopUp;
import nz.geek.nicholasparry.fitpet.components.AudioPlayer;
import nz.geek.nicholasparry.fitpet.components.PetInfoBox;
import nz.geek.nicholasparry.fitpet.pets.Pet;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetFactory;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.rendering.TextureButton;

//look im useing mvc heres the c
public class BattleScreen implements Screen {
	
	FitPetMain game;
	Player player;
	Pet playerPet;
	Battle battle; //look im useing mvc, heres the m
	
	private Stage stage;
	private FitViewport view;
	
	private Image userPetImage;
	private Image foePetImage;
	private TextureButton attack1B;
	private TextureButton attack2B;
	private Label foeDamageTaken;
	private Label userDamageTaken;
	
	private ArrayList<DeltaEvent> damageQue;
	
	private BattleControles controls;
	
	private ProgressBar userHealth;
	private Label healthLable;
	private Table healthTable;

	private EndResultPopUp endResult;
	
	private AudioPlayer battleThemePlayer;
	
	
	public BattleScreen(FitPetMain _game) {
		
		
		
		game = _game;
		player = game.getPlayer();
		playerPet = player.getPet();
		battle = new Battle(playerPet, PetFactory.makeRandomPet(), this);
		
		damageQue = new ArrayList<DeltaEvent>();
		
		view = new FitViewport(1080, 1920);
		view.update(1080, 1920, true);
		
		stage = new Stage(view);
		
		userPetImage = new Image(player.getPet().getDisplayObject().getTexture());
		userPetImage.setSize(600,600);
		userPetImage.setPosition(             (view.getWorldWidth() / 2) - (userPetImage.getWidth() / 3)             , 320);
		stage.addActor(userPetImage);
		
		foePetImage = new Image(battle.getFoePet().getFoeTexture());
		foePetImage.setSize(600, 600);
		foePetImage.setPosition((view.getWorldWidth() /2) - (2 * (userPetImage.getWidth() / 4)), 5*(320) - 500);
		stage.addActor(foePetImage);
		
		controls = new BattleControles(battle, (int)view.getWorldWidth(), (int)view.getWorldHeight());
		stage.addActor(controls);
		
		foeDamageTaken = new Label("", AssetHanldler.skin, "Score");
		foeDamageTaken.setPosition(foePetImage.getX(), foePetImage.getY());
		foeDamageTaken.setScaleX(-10f);
		foeDamageTaken.setSize(500, 500);
		//foeDamageTaken.getStyle().
		//foeDamageTaken.pack();
		userDamageTaken = new Label("", AssetHanldler.skin, "Score");
		userDamageTaken.setPosition(userPetImage.getX(), userPetImage.getY());
		stage.addActor(foeDamageTaken);
		stage.addActor(userDamageTaken);
		
		

		userHealth = new ProgressBar(0, 100, 1, false, AssetHanldler.battleSkin, "hpBar");
		userHealth.setScale(0.2f, 0.8f);
		userHealth.setSize(500, 400);
		userHealth.setValue(playerPet.getHP());
		healthLable = new Label("HP:", AssetHanldler.skin, "Score");
		healthTable = new Table();
		
		//healthTable.row();
		healthTable.add(healthLable);
		healthTable.add(userHealth);
		healthTable.pack();
		//healthTable.setPosition(view.getWorldWidth() - healthTable.getWidth(), controls.getHeight());
		//healthTable.setP
		healthTable.setPosition(view.getWorldWidth() - 1*(healthTable.getWidth() + 10), 110);
		//healthTable.setPosition(1,1);
		stage.addActor(healthTable);
		
		
		
		Gdx.input.setInputProcessor(stage);
		
		battleThemePlayer = new AudioPlayer();
		battleThemePlayer.playSound(SoundAssets.battleTheme, true);
		

		Gdx.app.log("BattleScreen", "Battle Screen Loaded");
		Gdx.app.log("BattleScreen", "Game: " + game.toString());
		Gdx.app.log("BattleScreen", "Player: " + player.toString());
		Gdx.app.log("BattleScreen", "playerPet: " + playerPet.toString());
		Gdx.app.log("BattleScreen", "Battle: " + battle.toString());
		Gdx.app.log("BattleScreen", "Player: " + player.toString());
		Gdx.app.log("BattleScreen", "");
		Gdx.app.log("BattleScreen", "DamageQue: " + damageQue.toString());
		Gdx.app.log("BattleScreen", "View: " + view.toString());
		Gdx.app.log("BattleScreen", "Stage: " + stage.toString());
		Gdx.app.log("BattleScreen", "UserPetImage: " + userPetImage.toString());
		Gdx.app.log("BattleScreen", "FoePetImage: " + foePetImage.toString());
		Gdx.app.log("BattleScreen", "BattleControls: " + controls);
		Gdx.app.log("BattleScreen", "FoeDamageTaken: " + foeDamageTaken.toString());
		Gdx.app.log("BattleScreen", "UserDamageTaken: " + userDamageTaken.toString());
		Gdx.app.log("BattleScreen", "HealthTable: " + healthTable.toString());
		
		
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		
		for(DeltaEvent e: damageQue){
			e.addTime(delta);
		}
		
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
		// TODO Auto-generated method stub

	}
	
	public void addDeltaEvent(DeltaEvent _event){
		damageQue.add(_event);
		Gdx.app.log("BattleScreen", "DeltaEvent added");
	}
	

		/**
		 * 
		 * @param _time time to trigger
		 * @param _foePet true if damage taken by foe pet
		 * @param _damageTaken damge taken
		 */
	public void addChangeDamageEvent(float _time, Boolean _foePet, int _damageTaken){
		if(_foePet){
			damageQue.add(new ChangeLableDeltaEvent(_time, foeDamageTaken, Integer.toString(_damageTaken)));
			Gdx.app.log("BattleScreen", "event added");
		} else {
			damageQue.add(new ChangeLableDeltaEvent(_time, userDamageTaken, Integer.toString(_damageTaken)));
			Gdx.app.log("BattleScreen", "event added");
		}
		damageQue.add(new ChangeLableDeltaEvent(_time + 0.5f, foeDamageTaken, ""));
		damageQue.add(new ChangeLableDeltaEvent(_time + 0.5f, userDamageTaken, ""));
		
		userHealth.setValue(playerPet.getHP());
	}
	
	public void endBatlle(Boolean playerWon){
		if(playerWon){
			playerPet.setHealth(100);
			player.getPlayerCard().setFitPoints(player.getPlayerCard().getFitPoints() + 1);
		} else {
			playerPet.setHealth(1);
			playerPet.setHappy(10);
		}
		
		endResult = new EndResultPopUp(playerWon);
		endResult.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				battleThemePlayer.stopSound();
				game.setScreen(new HomeScreen(game));
			}
		});
		//endResult
		endResult.setOrigin(Align.center);
		endResult.setPosition((view.getWorldWidth() / 2) - (440), (view.getWorldHeight() / 2) - (endResult.getHeight()));
		endResult.setOrigin(Align.center);
		stage.addActor(endResult);
		
	}

}



