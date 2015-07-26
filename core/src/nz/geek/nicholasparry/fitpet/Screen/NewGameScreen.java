package nz.geek.nicholasparry.fitpet.Screen;

import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Player;
import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.Assets.Buttons;
import nz.geek.nicholasparry.fitpet.Assets.Pets;
import nz.geek.nicholasparry.fitpet.pets.Pet;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetFactory;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetTypes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.rendering.TextureButton;


public class NewGameScreen implements Screen {

	private FitPetMain game;
	private Stage stage;
	private Viewport view;
	
	private Player player;
	private Pet pet;
	
	private TextField textField;
	private Image choosePetText;
	private TextureButton nextB;
	private TextureButton axolotlB;
	private TextureButton fireAntB;
	private TextureButton moleB;
	private Table table;
	
	private int step;
	
	public NewGameScreen(FitPetMain _game) {
		game = _game;
		player = new Player();
	}
	
	@Override
	public void show() {
		
		view = new FillViewport(360, 640); //360 by 640 cuz it has to be, gosh sassy
		view.update(360, 640, true);
		stage = new Stage(view);
		
		nextB = new TextureButton(Buttons.nextButton);
		nextB.setSize(nextB.getWidth() / 3, nextB.getHeight() / 3);
		nextB.setPosition((view.getWorldWidth() - nextB.getWidth()) / 2, 200);
		nextB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				nextInput();
			}
		});
		stage.addActor(nextB);
		
		setupTextBox("Name");
		stage.addActor(textField);
		
		Gdx.input.setInputProcessor(stage);
		
		game.playMainTheme();
		
	}

	@Override
	public void render(float delta) {
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
	
	public void nextInput(){
		PlayerCard pc = player.getPlayerCard();
		
		switch(step){
			case 0:
				if(pc.setName(textField.getText())){
					setupTextBox("Age");
					step++;
				} else {
					setupTextBox("Invalid Name");
				}
				break;
			case 1:
				int age = 0;
				try{
					age = Integer.parseInt(textField.getText());
				} catch (NumberFormatException e){
					setupTextBox("Invalid age");
					break;
				}
				if(pc.setAge(age)){
					setupTextBox("What is your daily step goal?");
					step++;
				} else {
					setupTextBox("Invalid age");
				}
				break;
			case 2:
				int stepGoal = 0;
				try{
					stepGoal = Integer.parseInt(textField.getText());
				} catch (NumberFormatException e){
					setupTextBox("Invalid step goal");
					break;
				}
				if(pc.setDailyStepGoal(stepGoal)){
					setupTextBox("What is your daily step goal?");
					pc.setDailyStepGoal(stepGoal);
					step++;
					choosePet();  //
				} else {
					setupTextBox("Invalid step goal");
				}
				break;
			case 3:
				step++;
				show();
				setupTextBox("Pet Name");
				break;
			case 4:
				Gdx.app.log("NewGameScreen", textField.toString());
				player.getPet().setName(textField.getText());
				player.setPet(pet);
				game.setPlayer(player);
				game.saveGame();
				game.setScreen(new HomeScreen((FitPetMain)game));
				break;
				
				
		}
	}
	
	private void setupTextBox(String _defultText){
		textField = null;
		textField = new TextField("", new Skin(AssetHanldler.styleJson));
		textField.setMessageText(_defultText);
		textField.setSize(nextB.getWidth(), textField.getHeight());
		textField.setPosition((view.getWorldWidth() - textField.getWidth() ) / 2, 400);
		stage.addActor(textField);
		Gdx.input.setInputProcessor(stage);
	}
	
	private void choosePet(){
		textField = null;
		view = new FillViewport(1080, 1920);
		view.update(1080, 1920, false);
		stage = new Stage(view);
		
		choosePetText = new Image(AssetHanldler.chooseAPetText);
		axolotlB = new TextureButton(Pets.axolotlPetCard);
		axolotlB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pet = PetFactory.makePet(PetTypes.AXOLOTL, player.getPlayerCard());
				player.setPet(pet);
				game.setPlayer(player);
				nextInput();
			}
		});
		fireAntB = new TextureButton(Pets.fireAntPetCard);
		fireAntB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pet = PetFactory.makePet(PetTypes.FIRANT, player.getPlayerCard());
				player.setPet(pet);
				game.setPlayer(player);
				nextInput();
			}
		});
		moleB = new TextureButton(Pets.molePetCard);
		moleB.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				pet = PetFactory.makePet(PetTypes.MOLE, player.getPlayerCard());
				player.setPet(pet);
				game.setPlayer(player);
				nextInput();
			}
		});
		
		table = new Table();
		table.row();
		table.add(choosePetText);
		table.row();
		table.add(axolotlB);
		table.row();
		table.add(fireAntB);
		table.row();
		table.add(moleB);
		table.setFillParent(true);
		
		stage.addActor(table);
		
		Gdx.input.setInputProcessor(stage);
		
	}
	
	
}
