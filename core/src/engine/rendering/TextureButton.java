package engine.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * creates a new button with a single texture
 * coz its kinda usfull, ya know?
 * @author nick
 *
 */
public class TextureButton extends ImageButton {
	
	/**
	 * Creates a button using just a texture.
	 * @param _texture
	 */
	public TextureButton(Texture _texture) {
		super(new SpriteDrawable(new Sprite(_texture)), new SpriteDrawable(new Sprite(_texture)));
	}
	
	
	/**
	 * Fo when you need an up and down
	 * @param _upTexture
	 * @param _downTexture
	 */
	public TextureButton(Texture _upTexture, Texture _downTexture) {
		super(new SpriteDrawable(new Sprite(_upTexture)), new SpriteDrawable(new Sprite(_downTexture)));
	}
	
	/**
	 * omg im so over writeing these.
	 * Why do you even want documentation, only I shoud see this
	 * Ok should you ever see this
	 * Send me a twix bar and a V and ill write you some documentation
	 * @param _upTexture
	 * @param _downTexture
	 * @param _checkTexture
	 */
	public TextureButton(Texture _upTexture, Texture _downTexture, Texture _checkTexture){
		super(new SpriteDrawable(new Sprite(_upTexture)), new SpriteDrawable(new Sprite(_downTexture)), new SpriteDrawable(new Sprite(_checkTexture)));
	}
}
