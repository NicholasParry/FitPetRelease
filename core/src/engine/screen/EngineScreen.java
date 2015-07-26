package engine.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport; 
import engine.rendering.DisplayObject;

/**
 * @author nick
 *
 */
public class EngineScreen implements Screen {

	private Game game;
	protected SpriteBatch batch;
	protected OrthographicCamera camera;
	protected Viewport view;
	private Viewport uiView;
	
	private ArrayList<DisplayObject> displayObjects; //For drawing background / no UI stuff
	private ArrayList<Actor> uiObjects; //For drawing top level UI stuff, will be above everything else
	
	private Stage uiStage;
	
	
	public EngineScreen(Game _game){
		game = _game;
	}

	
	 
	 
	@Override
	public void show() {
		
		displayObjects = new ArrayList<DisplayObject>();
		uiObjects = new ArrayList<Actor>();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(1080, 1920);
		camera.update();
		
		view = new FitViewport(1080, 1920);
		view = new FitViewport(1080, 1920, camera);
		view.update(1080, 1920, true);
		
		//set up ui
		uiView = new FitViewport(1080, 1920);
		uiView.update(1080, 1920, true);
		uiStage = new Stage(uiView);
		view.apply();

	}

	/**
	 * Calls screen render
	 * Override to draw no display and UI object
	 * make sure you call screenRender(delta); 
	 */
	@Override
	public void render(float delta) {
		screenRender(delta);
	}
	
	protected void screenRender(float delta){
		
		
		camera.update();
		
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//bg render
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		view.apply();
		//System.out.println(displayObjects.get(0).getLocation() + "\n" + displayObjects.get(0).getLocation() + "\n\n");
		for(int i = 0; i < displayObjects.size(); i++){
			DisplayObject obj = displayObjects.get(i);
			batch.draw(obj.getTexture(),obj.getLocation().x,obj.getLocation().y, obj.getSize().x, obj.getSize().y);
			Gdx.app.log("EngineScreen", "Drawing: " + i + "\n" + displayObjects.get(i).getName());
		}
		//batch.end();
		
		//ui render
		
		uiStage.act();
		uiStage.draw();
		batch.end();
		
	}

	
	@Override
	public void resize(int _width, int _height) {
		view.update(_width, _height);
		camera.position.set(camera.viewportWidth /2, camera.viewportHeight / 2, 0);
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
	
	/**
	 * Gets the current viewport size as a Vector2
	 * @return Vector2 viewport size.
	 */
	public Vector2 getVieportSize(){
		return new Vector2(view.getWorldWidth(),view.getWorldHeight());
	}
	
	/**
	 * Adds an object to be drawn behind the ui
	 * @param _objectToAdd DisplayObject to add
	 */
	public void addDisplayObject(DisplayObject _objectToAdd){
		displayObjects.add(_objectToAdd);
	}
	
	/**
	 * Adds an object to be drawn At UI level
	 * @param _objectToAdd DisplayObject to add
	 */
	public void addUIObject(Actor _objectToAdd){
		uiStage.addActor(_objectToAdd);
	}
	
	/**
	 * Sets the viewport size
	 * @param _width viewport width
	 * @param _height viewport height
	 */
	public void setViewportSize(int _width, int _height){
		//view.setScreenSize(_width, _height);
		view.setWorldSize(_width, _height);
	}
	
	protected Vector2 getWorldSize(){
		return new Vector2(view.getWorldWidth(),view.getWorldHeight());
	}
	
	protected Stage getUiStage(){
		return uiStage;
	}
	
	

}
