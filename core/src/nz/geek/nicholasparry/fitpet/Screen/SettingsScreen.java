package nz.geek.nicholasparry.fitpet.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import engine.rendering.TextureButton;
import nz.geek.nicholasparry.fitpet.FitPetMain;
import nz.geek.nicholasparry.fitpet.Settings;
import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.Assets.Buttons;

public class SettingsScreen implements Screen {

	private Stage stage;
	private Viewport view;
	
	private Table table;
	
	private TextureButton toggleMusic;
	private TextureButton toggleSFX;
	private TextureButton home;
	
	@Override
	public void show() {
		view = new FillViewport(1080, 1920);
		view.update(1080, 1920, true);
		stage = new Stage(view);
		
		table = new Table(AssetHanldler.skin);
		
		
		toggleMusic = new TextureButton(Buttons.toggleMusicOn, Buttons.toggleMusicOn, Buttons.toggleMusicOff);
		toggleMusic.setChecked(!Settings.music);
		toggleMusic.setPosition(50, 50);
		toggleMusic.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.music = !Settings.music;
				super.clicked(event, x, y);
				toggleMusic.setChecked(!Settings.music);
				FitPetMain.fitPetMain.saveGame();
			}
		});
		
		
		toggleSFX = new TextureButton(Buttons.toggleSfxOn, Buttons.toggleSfxOn, Buttons.toggleSfxOff);
		toggleSFX.setChecked(!Settings.sfx);
		toggleSFX.setPosition(260, 50);
		toggleSFX.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Settings.sfx = !Settings.sfx;
				super.clicked(event, x, y);
				toggleSFX.setChecked(!Settings.sfx);
				FitPetMain.fitPetMain.saveGame();
			}
		});
		
		
		
		home = new TextureButton(Buttons.home);
		home.setSize(200, 200);
		home.setPosition((stage.getWidth() / 2) - (home.getWidth() + 50),
				(stage.getHeight() / 1) - (home.getHeight()));
		home.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				FitPetMain.fitPetMain.setScreen(new HomeScreen(FitPetMain.fitPetMain));
				super.clicked(event, x, y);
			}
		});
		stage.addActor(home);
		
		//toggleMusic.
		
		table.row();
		table.add(toggleMusic);
		table.add(toggleSFX);
		table.row();
		table.pack();
		
		//stage.getBatch().setS
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);

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

}
