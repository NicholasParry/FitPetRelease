package nz.geek.nicholasparry.fitpet.components;

import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;

public class TextDisplayBox extends Group{

	private Table table;
	private Label label;
	
	public TextDisplayBox(String _message) {
		label = new Label(_message, AssetHanldler.battleSkin);
		label.setColor(Color.BLACK);
		table = new Table();
		
		table.row();
		table.add(label);
		table.row();

		table.setFillParent(true);
		table.setOrigin(Align.center);
		//SpriteDrawable tr = new TextureRegion(AssetHanldler.grey, 1, 1);

		
		table.pack();
		//tr = new DrawA
		
		this.setSize(table.getWidth(), table.getHeight());
		addActor(table);
		System.out.println("table width" + table.getWidth());
		System.out.println("label width" + label.getWidth());
		System.out.println("this width" + this.getWidth());
		
	}
	
	public void update(String _newMessage){
		label.setText(_newMessage);
	}

}
