package nz.geek.nicholasparry.fitpet.saves;

public class SaveFileCorruptException extends Exception {
	
	public String message = "No Message Provided";
	public boolean recoverable = false;
	
	/**
	 * 
	 * @param message Message to be outputed
	 * @param recoverable can this be recovered from
	 */
	public SaveFileCorruptException(String _message, boolean _recoverable) {
		message = _message;
		recoverable = _recoverable;
	}
	
}
