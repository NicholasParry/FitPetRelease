package nz.geek.nicholasparry.fitpet.pets.Tools;

import com.badlogic.gdx.graphics.Texture;







import nz.geek.nicholasparry.fitpet.Assets.Pets;
import nz.geek.nicholasparry.fitpet.pets.attacks.Attacks;


/**
 * used basically as a list of avalible pets
 * heh im lazy
 * everything on this list should also have a class that extends from 'Pet'
 * @author Nick
 *
 */
public enum PetTypes {
	AXOLOTL(
			0,
			"axolotl",
			"A fish with legs, do you think we could teach it kick boxing?",
			Elements.WATER,
			Attacks.SPLASH,
			Attacks.TIDAL_WAVE,
			Pets.axolotl),
	FIRANT(
			1,
			"Fire Ant",
			"An ant with a nasty bite",
			Elements.FIRE,
			Attacks.INFERNO,
			Attacks.FIRE_BITE,
			Pets.fireAnt),
	MOLE(
			2,
			"Mole",
			"A small mammel able to breath underground",
			Elements.EARTH,
			Attacks.ROCK_THROUGH,
			Attacks.DIG,
			Pets.mole);
	
	

	//SNOWYOWL("Snowy Owl","A white owl, particularly active at night", );
	//PLOVER("Plover", "A poisonus bird from austalia, where everthing is poisonus", Elements.AIR),
	
	private final String type;
	private final String description;
	private final Elements element;
	private final Attacks attack1;
	private final Attacks attack2;
	private final int typeID;
	private final Texture texture;
	
	PetTypes(int _typeID,String _type, String _description, Elements _element, Attacks _attack1, Attacks _attack2, Texture _texture){
		typeID = _typeID;
		type = _type;
		description = _description;
		element = _element;
		attack1 = _attack1;
		attack2 = _attack2;
		texture = _texture;
	}

	
	public static PetTypes getTypeByID(){
		return null;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the element
	 */
	public Elements getElement() {
		return element;
	}

	public Attacks getAttack1() {
		return attack1;
	}

	public Attacks getAttack2() {
		return attack2;
	}
	
	public int getTypeID() {
		return typeID;
	}
	
	public Texture getTexture(){
		return texture;
	}
	

}
