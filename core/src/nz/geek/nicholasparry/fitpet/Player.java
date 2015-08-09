package nz.geek.nicholasparry.fitpet;

import java.io.Serializable;

import engine.rendering.DisplayObject;
import nz.geek.nicholasparry.fitpet.pets.Pet;

/**
 * Contains the player but also settings 'n shit Its kinda basically a save :3
 * 
 * @author nick
 *
 */
public class Player {

	private PlayerCard playerCard;
	private Pet pet;
	private Settings settings;

	public Player() {
		playerCard = new PlayerCard();
		// pet = new Pet();
	}

	public void addSteps(int _steps) {
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
		return true; // TODO: validate properly
	}

	public boolean setPet(Pet pet) {
		this.pet = pet;
		return true;
	}

	@Override
	public String toString() {
		return playerCard.toString() + "\n" + pet.toString();
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}
