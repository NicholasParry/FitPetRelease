package nz.geek.nicholasparry.fitpet.DeltaEvents;

public class DeltaEvent {

	private float triggerTime;
	private float elapsedTime;
	
	public DeltaEvent(float _triggerTime) {
		elapsedTime = 0f;
		triggerTime = _triggerTime;
	}
	
	/**
	 * Add time to event
	 * call this in render
	 * returns true if event has been triggered
	 * @param _delta
	 * @return
	 */
	public boolean addTime(float _delta){
		elapsedTime += _delta;
		if(elapsedTime >= triggerTime){
			triger();
			return true;
		}
		return false;
	}
	
	public void triger(){
		
	}

}
