package engine.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import engine.rendering.DisplayObject;

public class SplashScreen extends EngineScreen {
	
	/**
	 * A simple SplashScreen, will display a texture for 5 seconds before moving to the next scene
	 * Currently does not transition
	 * 
	 * @param _game Main game class
	 * @param _texture Texture to display
	 */
	public SplashScreen(Game _game, Texture _texture, EngineScreen _nextScreen){
		super(_game);
		System.out.println(_texture);
		addDisplayObject(new DisplayObject(_texture,new Vector2(0,0), getVieportSize()));
		switchScreens(5000, _game, _nextScreen);
	}
	
	/**
	 * A simple SplashScreen, will display an image for a set amount of time before moving to the next scene
	 * Currently does not transition
	 * 
	 * 
	 * @param _game Main game class
	 * @param _texture Texture to display
	 * @param _displayTime Time in milliseconds to display for
	 */
	public SplashScreen(Game _game, Texture _texture, EngineScreen _nextScreen, int _waitTime){
		super(_game);
		System.out.println(_texture);
		addDisplayObject(new DisplayObject(_texture,new Vector2(0,0), getVieportSize()));
		switchScreens(_waitTime, _game, _nextScreen);
	}
	
	private void switchScreens(int _waitTime, Game _game, EngineScreen _nextScreen){
		try {
			wait(_waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_game.setScreen(_nextScreen);
	}
	
}
