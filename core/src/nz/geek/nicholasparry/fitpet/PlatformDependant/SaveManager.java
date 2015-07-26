package nz.geek.nicholasparry.fitpet.PlatformDependant;

import nz.geek.nicholasparry.fitpet.Player;

public abstract class SaveManager {
	
	public abstract Player getPlayer();
	
	public abstract boolean savePlayer(Player _player);
	
	public abstract boolean autoLoad();
}