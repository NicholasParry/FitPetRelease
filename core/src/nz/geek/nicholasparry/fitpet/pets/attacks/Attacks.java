package nz.geek.nicholasparry.fitpet.pets.attacks;

import com.badlogic.gdx.graphics.Texture;

import nz.geek.nicholasparry.fitpet.Assets.Buttons;
import nz.geek.nicholasparry.fitpet.pets.Tools.Elements;

public enum Attacks {
	//PUNCH("Punch", "The foe is punched", 10, Elements.EARTH),
	//KICK("Kick", "Your pet kicks its foe", 15, Elements.EARTH),
	SPLASH("Splash", "The foe is splashed with water", 10, Elements.WATER, Buttons.splashButton),
	TIDAL_WAVE("Tidal Wave", "A giant tidal wave crushes the foe", 50, Elements.WATER, Buttons.tidalWaveButton),
	//BITE("Bite", "The foe is bitten", 5, Elements.EARTH,),
	FIRE_BITE("Fire Bite","The foe is bitten with jaws of fire", 25, Elements.FIRE, Buttons.fireBiteButton),
	INFERNO("Inferno", "A firy inferno is summoned arround the foe", 50, Elements.FIRE, Buttons.infernoButton),
	ROCK_THROUGH("Rock Throw", "A rock is throwen at the foe", 10, Elements.EARTH, Buttons.rockThrowButton),
	//CLAW("Claw", "The foe is scratched with sharp claws", 20, Elements.EARTH),
	//CALL_OF_THE_WILD("Call of the wild", "Your pet summons its friends from nature who all attack the foe", 75, Elements.EARTH),
	DIG("Dig", "The pet digs a hole and than surprise attacks its foes", 25, Elements.EARTH, Buttons.digButton);
	
	
	private final String name;
	private final String description;
	private final int damage;
	private final Elements element;
	private final Texture buttonTexture;
	
	private Attacks(String _name, String _description, int _damage, Elements _element, Texture _buttonTexture){
		name = _name;
		description = _description;
		damage = _damage;
		element = _element;
		buttonTexture = _buttonTexture;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDamage() {
		return damage;
	}

	public Elements getElement() {
		return element;
	}
	
	@Override
	public String toString() {
		return "name: " + name + "\n"
				+ "description: " + description + "/n"
				+ "damage: " + damage + "/n"
				+ "element: " + element + "/n";
	}

	public Texture getButtonTexture() {
		return buttonTexture;
	}
}
