package nz.geek.nicholasparry.fitpet.battle;

import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.pets.Pet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import engine.rendering.TextureButton;

public class BattleControles extends Group {
	
	private Image bg;
	private TextureButton attack1B;
	private TextureButton attack2B;
	public Battle battle;
	private Table table;
	
	
	public BattleControles(Battle _battle, int width, int height) {
		battle = _battle;
		this.setWidth(width);
		this.setHeight(height);
		bg = new Image(AssetHanldler.grey);
		bg.setSize(getWidth(), getHeight());
		attack1B = new TextureButton(battle.getUserPet().getAttack1().getButtonTexture());
		attack1B.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				battle.setUserAttack(battle.getUserPet().getAttack1());
				super.clicked(event, x, y);
			}
		});
		attack2B = new TextureButton(battle.getUserPet().getAttack2().getButtonTexture());
		attack2B.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				battle.setUserAttack(battle.getUserPet().getAttack2());
				super.clicked(event, x, y);
			}
		});
		table = new Table();
		
		table.setWidth(width);
		table.row();
		attack1B.setWidth(attack1B.getWidth() / 2);
		attack1B.pack();
		//table.add(attack1B).width(width / 2).height(height / 2);
		table.add(attack1B).width(width / 2).height(attack1B.getHeight() / 2);
		attack2B.setWidth(attack2B.getWidth() / 2);
		attack2B.pack();
		table.add(attack2B).width(width / 2).height(attack2B.getHeight() / 2);;
		table.pack();
		//table.setFillParent(true);
		addActor(table);
		
	}
	
	private void setAttack(){
		
	}
	
	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		//return super.getHeight();
		return 400;
	}

}
