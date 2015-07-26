package nz.geek.nicholasparry.fitpet.Interfaces;

import nz.geek.nicholasparry.fitpet.pets.Tools.Elements;
import nz.geek.nicholasparry.fitpet.pets.attacks.Attacks;

public interface I_PetBattle {
	public Attacks getAttack1();
	public Attacks getAttack2();
	
	/**
	 * 
	 * @param _damageToTake damage to take
	 * @return false if pet is killed
	 */
	public boolean takeDamage(int _damageToTake);
	
	public String killed();
	
	public Elements getElement();
}
