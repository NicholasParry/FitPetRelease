package nz.geek.nicholasparry.fitpet.components;

import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;
import nz.geek.nicholasparry.fitpet.pets.Pet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class PetInfoBox extends Group {
	
	private Pet pet;
	
	private Label name;
	private Label health; 
	private Label happy;
	private Label hunger;
	private ProgressBar healthBar;
	private ProgressBar happyBar;
	private ProgressBar hungerBar;
	
	private Table table;
	

	
	public PetInfoBox(Pet _pet) {
		
		//this.setSize(500, 500);
		//this.setScale(3f, 3f);
		pet = _pet;
		
		Skin skin = AssetHanldler.oldSkin;
		
		(name = new Label(_pet.getName(), skin)).setColor(Color.BLACK);//Cool, putting brackets makes it return the new object
		(health = new Label("Health: ", skin)).setColor(Color.BLACK);  
		//health.setColor(Color.BLACK);
		(happy = new Label("Happy: ", skin)).setColor(Color.BLACK);
		//happy.setColor(Color.BLACK);
		(hunger = new Label("Hunger: ", skin)).setColor(Color.BLACK);
		//hunger.setColor(Color.BLACK);
		
		int stepSize = 5;
		healthBar = new ProgressBar(0, 100, stepSize, false, skin, "default");
		happyBar = new ProgressBar(0, 100, stepSize, false, skin, "default");
		hungerBar = new ProgressBar(0, 100, stepSize, false, skin, "default");
		
		healthBar.setValue(pet.getHP());
		healthBar.setAnimateDuration(1f);
		happyBar.setValue(pet.getHappy());
		happyBar.setAnimateDuration(1f);
		hungerBar.setValue(pet.getHunger());
		hungerBar.setAnimateDuration(1f);
		
		
		
		table = new Table();
		//table.setScale(3f,3f);
		table.add(name).align(com.badlogic.gdx.utils.Align.left);
		//table.
		table.row();
		table.add(health).align(Align.left);
		table.add(healthBar);
		table.row();
		table.add(happy).align(Align.left);
		table.add(happyBar);
		table.row();
		table.add(hunger).align(Align.left);
		table.add(hungerBar);
		table.row();

		table.setFillParent(true);
		table.setOrigin(Align.center);
		//SpriteDrawable tr = new TextureRegion(AssetHanldler.grey, 1, 1);

		SpriteDrawable bg = new SpriteDrawable(new Sprite(AssetHanldler.grey));
		table.setBackground(bg);
		table.pack();
		//tr = new DrawA
		
		this.setSize(table.getWidth(), table.getHeight());
		addActor(table);
		
		
		
		
		
		
		//this.setDebug(true, true);
		
	}
	
	@Override
	public void setPosition(float x, float y, int alignment) {
		// TODO Auto-generated method stub
		super.setPosition(x, y, alignment);
	}
	
	public void update(){
		//fitPoints.setText("FitPoint: " + pet.getOwner().getFitPoints());
	}
	

}
