package nz.geek.nicholasparry.fitpet;

import java.io.Serializable;

import engine.rendering.DisplayObject;
import nz.geek.nicholasparry.fitpet.pets.Pet;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1891496161829543137L;
	/**
	 * 
	 */
	private PlayerCard playerCard;
	private Pet pet;
	
	
	public Player() {
		playerCard = new PlayerCard();
		//pet = new Pet();
	}
	
	/**
	 * Call this when you load a game
	 * fixes stuff that has to be transient
	 */
	public void onDeserialization(){
		pet.setDisplayObject(new DisplayObject(pet.getType().getTexture()));
	}
	
	public void addSteps(int _steps){
		playerCard.setStepsToday(playerCard.getStepsToday() + _steps);
	}

	public PlayerCard getPlayerCard() {
		return playerCard;
	}

	public Pet getPet() {
		return pet;
	}

	public boolean setPlayerCard(PlayerCard playerCard) {
		this.playerCard = playerCard;
		return true; //TODO: validate properly
	}

	public boolean setPet(Pet pet) {
		this.pet = pet;
		return true;
	}
	
	@Override
	public String toString() {
		return playerCard.toString() + "\n" + pet.toString();
	}
}
