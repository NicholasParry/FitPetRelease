package nz.geek.nicholasparry.fitpet.pets;

import java.io.Serializable;
import java.util.Date;






import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import engine.rendering.DisplayObject;
import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.Interfaces.I_PetActions;
import nz.geek.nicholasparry.fitpet.Interfaces.I_PetBasic;
import nz.geek.nicholasparry.fitpet.Interfaces.I_PetBattle;
import nz.geek.nicholasparry.fitpet.pets.Tools.Elements;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetTypes;
import nz.geek.nicholasparry.fitpet.pets.attacks.Attacks;

public class Pet implements I_PetActions, I_PetBasic, I_PetBattle, Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3644309941759501729L;
	String name;
	PlayerCard owner;
	Attacks attack1;
	Attacks attack2;
	int health;
	boolean isAlive;
	PetTypes petType;
	Elements element;
	int hunger;
	int happy;
	private transient Texture playerTexture;
	private transient Texture foeTexture;
	
	DisplayObject displayObject;
	
	
	@Override
	public String toString() {
		//return attack2.toString();
		
		attack1 = petType.getAttack1();
		return "Name: " + name + "\n"
				+ "owner info would cause recursion" + "\n"
				+ "Attack1: " + attack1.getName() + "\n"
				+ "Attack2: " + attack2.getName() + "\n"
				+ "Health: " + health + "\n"
				+ "PetType: " + petType.getType() + "\n"
				+ "Elemet: " + element.getClass().getName() + "\n"
				+ "Hunger: " + hunger + "\n"
				+ "Happy: " + happy;
		
	}

	public Pet(PetTypes _petType, PlayerCard _owner) {
		this.petType = _petType;
		owner = _owner;
		playerTexture = petType.getTexture();
		foeTexture = petType.getTexture();
	}

	@Override
	public boolean takeDamage(int _damageToTake) {
		if(health > _damageToTake){
			health -= _damageToTake;
		} else {
			health = 0;
			isAlive = false;
		}
		return(isAlive);
	}

	@Override
	public String killed() {
		isAlive = false;
		health = 0;
		return "Your pet: " + name + " died";
	}
	

	@Override
	public String feed() {
		if(getOwner().getFitPoints() >= 1){
			hunger += 10;
			if(hunger >= 100){
				hunger = 100;
			}
			
			health += 5;
			if(health >= 100){
				health = 100;
			}
			getOwner().setFitPoints(getOwner().getFitPoints() - 1);
		}
		
		Gdx.app.log("Pet", "fed, player fitpoints:" + getOwner().getFitPoints());
		return null;
	}

	@Override
	public String play() {
		if(getOwner().getFitPoints() >= 1){
			Gdx.app.log("Pet", "Playing with pet");
			happy += 10;
			if(happy >= 100){
				happy = 100;
			}
			
			health += 5;
			if(health >= 100){
				health = 100;
			}
			getOwner().setFitPoints(getOwner().getFitPoints() - 1);
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	//getters

	@Override
	public Attacks getAttack1() {
		return attack1;
	}

	@Override
	public Attacks getAttack2() {
		return attack2;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public PetTypes getType() {
		return petType;
	}

	@Override
	public Elements getElement() {
		return element;
	}

	@Override
	public String getDescription() {
		return petType.getDescription();
	}

	@Override
	public PlayerCard getOwner() {
		return owner;
	}

	@Override
	public Date getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DisplayObject getDisplayObject() {
		return displayObject;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public int getHappy() {
		return happy;
	}

	@Override
	public int getHP() {
		return health;
	}

	@Override
	public boolean isAlive() {
		if(health <= 0){
			killed(); //fall back incase i screw up
		}
		return isAlive;
	}

	
	//setters
	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(PlayerCard owner) {
		this.owner = owner;
	}

	public void setAttack1(Attacks attack1) {
		attack1 = this.petType.getAttack1();
		this.attack1 = attack1;
	}

	public void setAttack2(Attacks attack2) {
		this.attack2 = attack2;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setPetType(PetTypes petType) {
		this.petType = petType;
	}

	public void setElement(Elements element) {
		this.element = element;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public void setHappy(int happy) {
		this.happy = happy;
	}

	public void setDisplayObject(DisplayObject displayObject) {
		this.displayObject = displayObject;
	}

	public Texture getPlayerTexture() {
		playerTexture = petType.getTexture();
		foeTexture = petType.getTexture();
		return playerTexture;
	}

	public Texture getFoeTexture() {
		playerTexture = petType.getTexture();
		foeTexture = petType.getTexture();
		return foeTexture;
	}

	public void setPlayerTexture(Texture playerTexture) {
		this.playerTexture = playerTexture;
	}

	public void setFoeTexture(Texture foeTexture) {
		this.foeTexture = foeTexture;
	}
	
	

}
