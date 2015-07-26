package nz.geek.nicholasparry.fitpet.Interfaces;

import java.util.Date;

import nz.geek.nicholasparry.fitpet.PlayerCard;
import nz.geek.nicholasparry.fitpet.pets.Tools.Elements;
import nz.geek.nicholasparry.fitpet.pets.Tools.PetTypes;
import engine.rendering.DisplayObject;

/**Yeah I called it I_PetBasic, Oh, you dont like the prefix "I_" WELL I DO! 
 * This is my app, and my code, if you have a problem with it go make your own
 * Maybe with black jack and hookers or something
 * 
 * @author Nick
 *
 */
public interface I_PetBasic {
	
	
	public String getName();
	public PetTypes getType();
	public Elements getElement();
	public String getDescription();
	public PlayerCard getOwner();
	public Date getAge();
	
	public DisplayObject getDisplayObject();
	
	public int getHunger();
	public int getHappy();
	public int getHP();
	
	public boolean isAlive();
	
}
