package engine.rendering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * creates a new button with a single texture
 * coz its kinda usfull, ya know?
 * @author nick
 *
 */
public class TextureButton extends Button {
	
	/**
	 * Creates a button using just a texture.
	 * @param _texture
	 */
	public TextureButton(Texture _texture) {
		super(new SpriteDrawable(new Sprite(_texture)), new SpriteDrawable(new Sprite(_texture)));
	}
}
