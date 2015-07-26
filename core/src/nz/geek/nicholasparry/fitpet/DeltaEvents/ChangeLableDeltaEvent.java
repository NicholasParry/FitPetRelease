package nz.geek.nicholasparry.fitpet.DeltaEvents;

import nz.geek.nicholasparry.fitpet.Assets.SoundAssets;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ChangeLableDeltaEvent extends DeltaEvent {
	
	private Label lableToChange;
	private String newText;
	private boolean hasTriggered;
	
	public ChangeLableDeltaEvent(float _triggerTime, Label _lableToChange, String _newText) {
		super(_triggerTime);
		lableToChange = _lableToChange;
		newText = _newText;
		hasTriggered = false;
	}
	
	@Override
	public void triger() {
		lableToChange.setText(newText);
		if(!hasTriggered && !(newText.equals(""))){
			SoundAssets.hitFx.play();
			hasTriggered = true;
		}
	}
	
}
