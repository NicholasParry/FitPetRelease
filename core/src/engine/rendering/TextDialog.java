package engine.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

public class TextDialog implements TextInputListener {
	
	private String toReturn;
	private boolean returnReady;

	public TextDialog() {
		returnReady = false;
	}
	
	public String ask(String _dialogTitle, String _initialValue){
		TextDialog listener = new TextDialog();
		Gdx.input.getTextInput(listener, _dialogTitle, _initialValue, "");
		return listener.getReturnString();
	}

	@Override
	public void input(String text) {
		toReturn = text;
		returnReady = true;
		
	}

	@Override
	public void canceled() {
		toReturn = "";
		returnReady = true;
	}
	
	public boolean isReturnReady(){
		return returnReady;
	}
	
	public String getReturnString(){
		return toReturn;
	}
}
