package nz.geek.nicholasparry.fitpet.battle;

import nz.geek.nicholasparry.fitpet.Assets.AssetHanldler;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class EndResultPopUp extends Group {
	

	private Image result;

	/**
	 * Box displaying weather the player won or lost
	 * @param _playerWon true if the player won
	 */
	public EndResultPopUp(Boolean _playerWon) {
		if(_playerWon){
			result = new Image(AssetHanldler.wonBattle);
		} else {
			result = new Image(AssetHanldler.lostBattle);
		}
		addActor(result);
	}

}
