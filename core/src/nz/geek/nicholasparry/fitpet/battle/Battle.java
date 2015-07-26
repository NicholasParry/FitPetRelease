package nz.geek.nicholasparry.fitpet.battle;

import com.badlogic.gdx.Gdx;

import nz.geek.nicholasparry.fitpet.Screen.BattleScreen;
import nz.geek.nicholasparry.fitpet.pets.Pet;
import nz.geek.nicholasparry.fitpet.pets.attacks.Attacks;

public class Battle {
	private Pet userPet;
	private Pet foePet;
	
	private Attacks foeAttack;
	private Attacks userAttack;
	private BattleScreen battleScreen;
	public Battle(Pet _userPet, Pet _foePet, BattleScreen _battleScreen) {
		foePet = _foePet;
		userPet = _userPet;
		battleScreen = _battleScreen;
	}
	
	/**
	 * Randomly selects foes attack, with a 0.5 chance of ether attack
	 */
	public void chooseFoeAttack(){
		if(Math.random() > 0.5){
			foeAttack = foePet.getAttack1();
		} else {
			foeAttack = foePet.getAttack2();
		}
	}
	
	/**
	 * Sets user input when needed
	 */
	public void setUserAttack(Attacks _userAttack){
		userAttack = _userAttack;
		calculateRound();
		Gdx.app.log("Battle", Integer.toString(userPet.getHP()));
	}
	
	/**
	 * Calculates the damage of the round
	 * 50% ether side will win
	 */
	public void calculateRound(){
		chooseFoeAttack();
		if(hasNextRound()){
		
			//TODO: add random
			int foeDamage = (int)(foeAttack.getDamage() * foeAttack.getElement().elementPenalty(userPet.getElement()));
			int userDamage = (int)(userAttack.getDamage() * userAttack.getElement().elementPenalty(foePet.getElement()));
			
			//calculate if pets will survive.
			if(foePet.getHP() < userDamage){
				foePet.killed();
			} else if (userPet.getHP() < foeDamage){
				userPet.killed();
			}
			
			
			try{
			//do damage
				int delayTime = 100;
				if(Math.random() > 0.5){
					foePet.takeDamage(userDamage);
					battleScreen.addChangeDamageEvent(0, true, userDamage);
					userPet.takeDamage(foeDamage);
					battleScreen.addChangeDamageEvent(0.55f, false, foeDamage);
				} else {
					userPet.takeDamage(foeDamage);
					battleScreen.addChangeDamageEvent(0, false, foeDamage);
					foePet.takeDamage(userDamage);
					battleScreen.addChangeDamageEvent(0.55f, true, userDamage);
				}
			} catch (Exception e){
				
			}
		} else {
			battleScreen.endBatlle(playerWon());
		}
		
	}
	
	public boolean hasNextRound(){
		return (userPet.isAlive() && foePet.isAlive());
	}
	
	public boolean playerWon(){
		return (!hasNextRound() && userPet.isAlive());
	}

	public Pet getFoePet() {
		return foePet;
	}

	public Pet getUserPet() {
		return userPet;
	}
	
	
	

}
